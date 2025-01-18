package ru.netology.autorisationServise.user;

import lombok.Getter;
import lombok.Setter;
import ru.netology.autorisationServise.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {
    private String userId;
    private String password;
    private List<Authorities> authorities = new ArrayList<>();

    public User() {
    }
    public String getPassword(){
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public User(String userId, String password, List<Authorities> authorities) {
        this.userId = userId;
        this.password = password;
        this.authorities = authorities;
    }

}
