package com.example.finalfinalback3.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class UserEntity{// implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String login;
    private String password;
    private String password_confirm;
    //@Column(columnDefinition = "varchar(255) default 'ROLE_USER'")
    private String role;
    private String token;

    @ManyToMany
    @JoinTable(name="user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id")
    )
    private List<TourEntity> favorites;

    @ManyToMany
    @JoinTable(name="user_history",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id")
    )
    private List<TourEntity> history;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DocumentEntity> doc;
    //TODO Добавить картинку пользователя
    //@Enumerated(EnumType.STRING)
    //private RoleEnum role;


   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
        //return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
*/
}
