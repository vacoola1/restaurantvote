package ua.vacoola.restaurantvote.repository;

import ua.vacoola.restaurantvote.model.Dish;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface DishRepository {
    Dish save(Dish dish);
}
