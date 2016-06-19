package ua.vacoola.restaurantvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vacoola.restaurantvote.model.Dish;
import ua.vacoola.restaurantvote.repository.DishRepository;
import ua.vacoola.restaurantvote.util.exception.ExceptionUtil;

/**
 * Created by r.vakulenko on 16.06.2016.
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository repository;

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return ExceptionUtil.check(repository.save(dish), dish.getId());
    }

    @Override
    public void delete(int id, int menuId) {
        repository.delete(id, menuId);
    }
}
