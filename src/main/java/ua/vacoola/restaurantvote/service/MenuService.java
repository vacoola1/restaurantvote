package ua.vacoola.restaurantvote.service;

import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface MenuService {
    List<Menu> getAll();

    Menu get(int id);

    Menu save(Menu menu);

    void delete(int id);

    Menu update(Menu menu);

    List<Menu> getFilter(boolean FilterByRestaurant, Integer restaurantId, LocalDate startDay, LocalDate endDay);
}
