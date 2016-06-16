package ua.vacoola.restaurantvote.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.service.RestaurantService;
import ua.vacoola.restaurantvote.service.UserService;

import java.time.LocalDate;
import java.util.List;


public abstract class AbstractRestaurantController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public List<Restaurant> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Restaurant get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(null);
        log.info("create " + restaurant);
        return service.save(restaurant);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        restaurant.setId(id);
        log.info("update " + restaurant);
        service.update(restaurant);
    }

}
