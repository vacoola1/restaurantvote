package ua.vacoola.restaurantvote.service;


import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.util.exception.NotFoundException;

import java.util.List;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

    void evictCache();

    void enable(int id, boolean enable);

}
