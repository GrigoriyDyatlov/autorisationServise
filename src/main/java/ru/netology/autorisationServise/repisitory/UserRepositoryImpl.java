package ru.netology.autorisationServise.repisitory;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.netology.autorisationServise.authorities.Authorities;
import ru.netology.autorisationServise.user.User;
import ru.netology.autorisationServise.user.UserAuthorities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final ConcurrentHashMap<String, UserAuthorities> users = new ConcurrentHashMap<>();


    public UserRepositoryImpl() {
    }

    @Override
    public List<Authorities> getUserAuthorities(User user) {
        createUser(user, List.of(Authorities.READ));
        if (users.containsKey(user.getUserId())) {
            UserAuthorities requestedUserAuthorities = users.get(user.getUserId());
            if (requestedUserAuthorities.getPassword().equals(user.getPassword())) {
                return requestedUserAuthorities.getAuthorities();
            } else return new ArrayList<>();
        } else return new ArrayList<>();
    }

    @Override
    public void createUser(User user, List<Authorities> authorities) {
        UserAuthorities userAuthorities = new UserAuthorities(user, authorities);
        users.put(user.getUserId(), userAuthorities);
    }
}

