package ua.vacoola.restaurantvote.service;

import ua.vacoola.restaurantvote.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 31.05.2016.
 */
public interface VoteService {
    List<Vote> getAll();

    Vote get(int id);

    List<Vote> getAll(int userId);

    Vote get(int id, int userId);

    Vote getNow(int userId);

    Vote save(int restaurantId, LocalDate day, int userId);

    void delete(int id, int userid);

    List<Vote> getFilter(boolean FilterByRestraunt, Integer restaurantid, boolean filterByUsre, Integer userId, LocalDate localDate, LocalDate localDate1);

}
