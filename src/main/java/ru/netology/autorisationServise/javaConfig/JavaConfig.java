package ru.netology.autorisationServise.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.autorisationServise.controller.UserController;
import ru.netology.autorisationServise.repisitory.UserRepository;
import ru.netology.autorisationServise.repisitory.UserRepositoryImpl;
import ru.netology.autorisationServise.service.UserService;

//@Configuration
//public class JavaConfig {
//    @Bean
//    public UserRepository userRepository() {
//        return new UserRepositoryImpl();
//    }
//
//    @Bean
//    public UserService userService(UserRepository userRepository) {
//        return new UserService(userRepository);
//    }
//
//    @Bean
//    public UserController userController(UserService userService) {
//        return new UserController(userService);
//    }
//
//}
