package ua.vacoola.restaurantvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vacoola.restaurantvote.model.Dish;
import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.repository.DishRepository;
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
    private MenuRepository menuRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Menu> getAll() {
        return menuRepository.getAll();
    }

    @Override
    public Menu get(int id) {
        return ExceptionUtil.check(menuRepository.get(id), id);
    }

    @Override
    @Transactional
    public Menu save(Menu menu) {

        Menu savedMenu = menuRepository.save(menu);


        List<Dish> oldDishs = dishRepository.getForMenu(savedMenu.getId());
        List<Dish> newDishs = menu.getDishs();

        for (int i = oldDishs.size() - 1; i >= 0; i--) {
            if (!newDishs.contains(oldDishs.get(i))) {
                dishRepository.delete(oldDishs.get(i).getId(), savedMenu.getId());
            }
        }

        savedMenu.getDishs().clear();

        for (Dish dish : newDishs) {
            savedMenu.getDishs().add(dishRepository.save(dish));
        }

        return savedMenu;
    }

    @Override
    @Transactional
    public void delete(int id) {

        ExceptionUtil.check(dishRepository.deleteForMenu(id), id);
        ExceptionUtil.check(menuRepository.delete(id), id);

    }

    @Override
    @Transactional
    public Menu update(Menu menu) {

        Menu savedMenu = ExceptionUtil.check(menuRepository.save(menu), menu.getId());

        List<Dish> oldDishs = dishRepository.getForMenu(savedMenu.getId());
        List<Dish> newDishs = menu.getDishs();

        for (int i = oldDishs.size() - 1; i >= 0; i--) {
            if (!newDishs.contains(oldDishs.get(i))) {
                dishRepository.delete(oldDishs.get(i).getId(), savedMenu.getId());
            }
        }

        savedMenu.getDishs().clear();

        for (Dish dish : newDishs) {
            savedMenu.getDishs().add(dishRepository.save(dish));
        }

        return savedMenu;
    }

    @Override
    public List<Menu> getFilter(boolean FilterByRestaurant, Integer restaurantId, LocalDate startDay, LocalDate endDay) {
        return menuRepository.getFilter(true, restaurantId, startDay, endDay);
    }
}
