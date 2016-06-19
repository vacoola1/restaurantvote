package ua.vacoola.restaurantvote.repository;

        import ua.vacoola.restaurantvote.model.Dish;

        import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface DishRepository {
    Dish save(Dish dish);

    List<Dish> getForMenu(int menuId);

    boolean delete(int id, int menuId);

    boolean deleteForMenu(int id);
}
