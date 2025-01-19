package ru.netology.autorisationServise.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.autorisationServise.authorities.Authorities;
import ru.netology.autorisationServise.service.UserService;
import ru.netology.autorisationServise.user.User;

import java.util.List;

@Component
@RestController
public class UserController {
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(User user) {
        return service.getAuthorities(user);
    }
}
