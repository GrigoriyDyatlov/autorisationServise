package ru.netology.autorisationServise.service;

import org.springframework.stereotype.Component;
import ru.netology.autorisationServise.authorities.Authorities;
import ru.netology.autorisationServise.exceptions.InvalidCredentials;
import ru.netology.autorisationServise.exceptions.UnauthorizedUser;
import ru.netology.autorisationServise.repisitory.UserRepository;

import java.util.List;

@Component
@org.springframework.stereotype.Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(java.util.List<?> str) {
        return str == null || str.isEmpty();
    }
}
