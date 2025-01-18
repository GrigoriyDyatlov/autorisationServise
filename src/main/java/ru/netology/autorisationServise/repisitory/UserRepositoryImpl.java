package ru.netology.autorisationServise.repisitory;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.netology.autorisationServise.authorities.Authorities;
import ru.netology.autorisationServise.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
@Component
@Repository
public class UserRepositoryImpl implements UserRepository {
    private ConcurrentHashMap<String, User> users;


    public UserRepositoryImpl (){
    users.put("Petya", new User("Petya", "1234",
            List.of(Authorities.READ, Authorities.DELETE)));
}
    @Override
    public List<Authorities> getUserAuthorities(String userId, String password) {
        if (users.containsKey(userId)) {
            User requestedUser = users.get(userId);
            if (requestedUser.getPassword().equals(password)) {
                return requestedUser.getAuthorities();
            } else return new ArrayList<>();
        } else return new ArrayList<>();
    }

    public void createUser(String userId, String password, List<Authorities> authorities) {
        users.put(userId, new User(userId, password, authorities));
    }
}

