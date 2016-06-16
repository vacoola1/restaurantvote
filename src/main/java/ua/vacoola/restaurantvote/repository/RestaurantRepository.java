package ua.vacoola.restaurantvote.repository;

import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    List<Restaurant> getAll();

}
