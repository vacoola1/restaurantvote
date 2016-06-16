package ua.vacoola.restaurantvote.service;

import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;

import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface RestaurantService {
    List<Restaurant> getAll();

    Restaurant get(int id);

    Restaurant save(Restaurant restaurant);

    void delete(int id);

    Restaurant update(Restaurant restaurant);
}
