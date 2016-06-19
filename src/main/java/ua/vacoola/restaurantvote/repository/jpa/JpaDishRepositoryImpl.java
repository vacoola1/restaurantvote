package ua.vacoola.restaurantvote.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vacoola.restaurantvote.model.Dish;
import ua.vacoola.restaurantvote.repository.DishRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by r.vakulenko on 16.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class JpaDishRepositoryImpl implements DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Dish> getForMenu(int menuId) {
        return em.createNamedQuery(Dish.ALL_FOR_MENU).setParameter("menuId", menuId).getResultList();
    }

    @Override
    @Transactional
    public Dish save(Dish dish) {
        if (dish.isNew()) {
            em.persist(dish);
            return dish;
        } else {
            return em.merge(dish);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int menuId) {
        return em.createNamedQuery(Dish.DELETE)
                .setParameter("id", id)
                .setParameter("menuId", menuId)
                .executeUpdate() != 0;
    }

    @Override
    public boolean deleteForMenu(int menuId) {
        return em.createNamedQuery(Dish.DELETE_FOR_MENU)
                .setParameter("menuId", menuId)
                .executeUpdate() != 0;
    }
}
