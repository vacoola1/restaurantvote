package ua.vacoola.restaurantvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.repository.RestaurantRepository;
import ua.vacoola.restaurantvote.util.exception.ExceptionUtil;

import java.util.List;

/**
 * Created by r.vakulenko on 01.06.2016.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public Restaurant get(int id) {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return ExceptionUtil.check(repository.save(restaurant), restaurant.getId());
    }
}
