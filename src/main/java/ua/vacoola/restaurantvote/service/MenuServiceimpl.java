package ua.vacoola.restaurantvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.repository.MenuRepository;
import ua.vacoola.restaurantvote.util.exception.ExceptionUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 16.06.2016.
 */
@Service
public class MenuServiceimpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> getAll() {
        return repository.getAll();
    }

    @Override
    public Menu get(int id) {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public Menu save(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public Menu update(Menu menu) {
        return ExceptionUtil.check(repository.save(menu), menu.getId());
    }

    @Override
    public List<Menu> getFilter(LocalDate startDay, LocalDate endDay) {
        return repository.getFilter(startDay, endDay);
    }

    @Override
    public List<Menu> getFilter(Restaurant restaurant, LocalDate startDay, LocalDate endDay) {
        return repository.getFilter(restaurant, startDay, endDay);
    }
}
