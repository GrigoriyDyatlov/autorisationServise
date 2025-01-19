package ru.netology.autorisationServise.user;

import lombok.Getter;
import lombok.Setter;
import ru.netology.autorisationServise.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UserAuthorities {
    private User user;
    private List<Authorities> authorities = new ArrayList<>();

    public UserAuthorities() {
    }

    public UserAuthorities(User user, List<Authorities> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public String getPassword() {
        return user.getPassword();
    }
    public String getUserId(){
        return getUserId();
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

}
