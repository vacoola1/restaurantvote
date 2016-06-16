package ua.vacoola.restaurantvote.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.repository.RestaurantRepository;
import ua.vacoola.restaurantvote.util.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by r.vakulenko on 01.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class JpaRestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) throws NotFoundException {
        return em.createNamedQuery(Restaurant.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return em.find(Restaurant.class, id);
    }

    @Override
    public List<Restaurant> getAll() {
        return em.createNamedQuery(Restaurant.ALL, Restaurant.class).getResultList();
    }

}
