package ua.vacoola.restaurantvote.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.repository.MenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 17.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class JpaMenuRepositoryImpl implements MenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Menu> getAll() {
        return em.createNamedQuery(Menu.ALL, Menu.class).getResultList();
    }

    @Override
    public Menu get(int id) {
        return em.find(Menu.class, id);
    }

    @Override
    @Transactional
    public Menu save(Menu menu) {
        if (menu.isNew()) {
            em.persist(menu);
            return menu;
        } else {
            return em.merge(menu);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Menu.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<Menu> getFilter(boolean FilterByRestaurant, Integer restaurantId, LocalDate startDay, LocalDate endDay) {
        return em.createNamedQuery(Menu.FILTER)
                .setParameter("FilterByRestaurant", FilterByRestaurant)
                .setParameter("restaurantId", restaurantId)
                .setParameter("startDay", startDay)
                .setParameter("endDay", endDay)
                .getResultList();
    }
}
