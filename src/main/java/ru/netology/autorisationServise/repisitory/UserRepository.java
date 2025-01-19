package ru.netology.autorisationServise.repisitory;

import ru.netology.autorisationServise.authorities.Authorities;
import ru.netology.autorisationServise.user.User;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(User user);

    void createUser(User user, List<Authorities> authorities);
}
