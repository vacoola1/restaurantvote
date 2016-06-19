package ua.vacoola.restaurantvote.service;

import ua.vacoola.restaurantvote.model.Dish;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface DishService{
    Dish save(Dish dish);

    Dish update(Dish dish);

    void delete(int id, int menuId);
}
