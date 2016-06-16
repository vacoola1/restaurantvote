package ua.vacoola.restaurantvote.repository;

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

    List<Vote> getFilter(Integer restaurantId, Integer userId, LocalDate startDate, LocalDate endDate);

    Vote getForDay(LocalDate now, int userId);

    Vote save(int restaurantId, int day, int userId);

    void delete(int id, int userid);

}
