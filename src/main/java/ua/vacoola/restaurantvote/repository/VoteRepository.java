package ua.vacoola.restaurantvote.repository;

import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface VoteRepository {
    List<Vote> getAll();

    List<Vote> getAll(int userId);

    Vote get(int id);

    Vote get(int id, int userId);

    List<Vote> getFilter(boolean FilterByRestaurant, Integer restaurantId, boolean FilterByUser, Integer userId, LocalDate startDate, LocalDate endDate);

    Vote getForDay(LocalDate day, int userId);

    Vote save(Restaurant restaurant, LocalDate day, User user);

    boolean delete(int id, int userid);

}
