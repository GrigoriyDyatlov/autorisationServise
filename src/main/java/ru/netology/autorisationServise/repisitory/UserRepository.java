package ru.netology.autorisationServise.repisitory;

import ru.netology.autorisationServise.authorities.Authorities;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(String user, String password);
}
