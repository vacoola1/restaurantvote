package ua.vacoola.restaurantvote.web.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.vacoola.restaurantvote.model.Dish;
import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.service.DishService;
import ua.vacoola.restaurantvote.service.MenuService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 03.06.2016.
 */
public class AbstractMenuController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    @Autowired
    private DishService dishService;

    public List<Menu> getAll() {
        log.info("getAll");
        return menuService.getAll();
    }

    public Menu get(int id) {
        log.info("get " + id);
        return menuService.get(id);
    }

    public Menu create(Menu menu) {
        menu.setId(null);
        log.info("create " + menu);
        return menuService.save(menu);
    }

    public void delete(int id) {
        log.info("delete " + id);
        menuService.delete(id);
    }

    public void update(Menu menu, int id) {
        menu.setId(id);
        log.info("update " + menu);
        menuService.update(menu);
    }

    public List<Menu> getFilterPerDay(LocalDate day) {
        log.info("getFilterPerDay");
        return menuService.getFilter(day, day);
    }

    public List<Menu> getFilter(Restaurant restaurant, LocalDate startDay, LocalDate endDay) {
        log.info("getFilter");
        if (restaurant == null) {
            return menuService.getFilter((startDay == null) ? LocalDate.MIN : startDay, (endDay == null) ? LocalDate.MAX : endDay);
        } else {
            return menuService.getFilter(restaurant, (startDay == null)? LocalDate.MIN: startDay, (endDay == null)? LocalDate.MAX: endDay);
        }

    }

    public Dish createDish(Dish dish) {
        dish.setId(null);
        log.info("create " + dish);
        return dishService.save(dish);
    }

    public void updateDish(Dish dish, int id) {
        dish.setId(id);
        log.info("update " + dish);
        dishService.update(dish);
    }

}

