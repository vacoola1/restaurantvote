package ua.vacoola.restaurantvote.repository;

import ua.vacoola.restaurantvote.model.Menu;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface MenuRepository {
    List<Menu> getAll();

    Menu get(int id);

    Menu save(Menu menu);

    boolean delete(int id);

    List<Menu> getFilter(boolean FilterByRestaurant, Integer restaurantId, LocalDate startDay, LocalDate endDay);
}
