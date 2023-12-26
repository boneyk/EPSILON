package com.example.finalfinalback3.Controller;

import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Service.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public ResponseEntity showAllTours() throws DataNotFoundException {
        try{
            return new ResponseEntity(tourService.showAll(), HttpStatus.OK);
        }
        catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTourById(@PathVariable Integer id){
        try{
            return new ResponseEntity(tourService.getTourById(id), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/filtered")
    public ResponseEntity showFilteredTours(@RequestParam String country_to,
                                           @RequestParam LocalDate date_start,
                                           @RequestParam Integer nights,
                                            @RequestParam Integer amount){
        try{
            return new ResponseEntity(
                    tourService.showFilteredTours(country_to, date_start, nights, amount),
                    HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/favorite")
    public ResponseEntity showFavoriteTours(@RequestParam String token){
        try{
            return new ResponseEntity(tourService.showFavoriteTours(token), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/favorite/{tour_id}/to/{token}")
    public ResponseEntity addFavorite(@PathVariable Integer tour_id,
                                      @PathVariable String token){
        try{
            tourService.addFavorite(tour_id, token);
            return new ResponseEntity(HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("favorite/{tour_id}/from/{token}")
    public ResponseEntity removeFromFavorite(@PathVariable Integer tour_id,
                                             @PathVariable String token){
        try{
            tourService.removeFromFavorite(tour_id, token);
            return new ResponseEntity(HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/history")
    public ResponseEntity showHistory(@RequestParam String token){
        try{
            return new ResponseEntity(tourService.showHistory(token), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/history/{tour_id}/to/{token}")
    public ResponseEntity addTourToHistory(@PathVariable Integer tour_id,
                                      @PathVariable String token){
        try{
            tourService.addTourToHistory(tour_id, token);
            return new ResponseEntity(HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order")
    public ResponseEntity showOrderDetails(@RequestParam String token,
                                           @RequestParam Integer tour_id){
        try{
            return new ResponseEntity(tourService.showOrderDetails(token, tour_id), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    



}
