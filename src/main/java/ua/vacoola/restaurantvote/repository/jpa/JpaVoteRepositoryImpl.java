package ua.vacoola.restaurantvote.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.model.Vote;
import ua.vacoola.restaurantvote.repository.VoteRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Created by r.vakulenko on 19.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class JpaVoteRepositoryImpl implements VoteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vote> getAll() {
        return em.createNamedQuery(Vote.ALL).getResultList();    }

    @Override
    public List<Vote> getAll(int userId) {
        return em.createNamedQuery(Vote.ALL_BY_USER)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Vote get(int id) {
        return em.find(Vote.class, id);
    }

    @Override
    public Vote get(int id, int userId) {
        HashMap<String, Object> parametrs = new HashMap<>();
        parametrs.put("userId", userId);
        return em.find(Vote.class, id, parametrs);
    }

    @Override
    public List<Vote> getFilter(boolean FilterByRestaurant, Integer restaurantId, boolean FilterByUser, Integer userId, LocalDate startDate, LocalDate endDate) {
        return em.createNamedQuery(Vote.FILTER)
                .setParameter("FilterByRestaurant", FilterByRestaurant)
                .setParameter("restaurantId", restaurantId)
                .setParameter("filterByUsre", FilterByUser)
                .setParameter("userId", userId)
                .setParameter("startDay", startDate)
                .setParameter("endDay", endDate)
                .getResultList();    }

    @Override
    public Vote getForDay(LocalDate day, int userId) {
        return em.createNamedQuery(Vote.GET_FOR_DAY_BY_USER, Vote.class)
                .setParameter("day", day)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public Vote save(Restaurant restaurant, LocalDate day, User user) {
        List<Vote> votes = em.createNamedQuery(Vote.GET_BY_PARAM, Vote.class)
                .setParameter("restaurantId", restaurant.getId())
                .setParameter("day", day)
                .setParameter("userId", user.getId())
                .getResultList();

        if (votes.size() != 1) {
            Vote vote = new Vote(user, restaurant, day);
            em.persist(vote);
            return vote;
        } else {
            return em.merge(votes.get(0));
        }
    }

    @Override
    public boolean delete(int id, int userid) {
        return em.createNamedQuery(Vote.DELETE)
                .setParameter("id", id)
                .setParameter("userid", userid)
                .executeUpdate() != 0;

    }
}
