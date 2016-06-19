package ua.vacoola.restaurantvote.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.model.Vote;
import ua.vacoola.restaurantvote.service.VoteService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 03.06.2016.
 */
public class AbstractVoteController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService service;

    public List<Vote> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Vote get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public List<Vote> getFilter(Integer restaurantId, Integer userId, LocalDate startDay, LocalDate endDay) {
        log.info("getFilter");
        return service.getFilter(restaurantId != null, restaurantId, userId != null, userId, (startDay == null) ? LocalDate.MIN : startDay, (endDay == null) ? LocalDate.MAX : endDay);
    }

    public List<Vote> getAll(int userId) {
        log.info("getAll userId " + userId);
        return service.getAll(userId);
    }

    public Vote get(int id, int userId) {
        log.info("get " + id + " userId " + userId);
        return service.get(id, userId);
    }

    public Vote getNow(int userId) {
        log.info("getNow userId " + userId);
        return service.getNow(userId);
    }

    public Vote create(int restaurantId, LocalDate day, int userId) {
        log.info("create restaurantId " + restaurantId+", day "+ ", userId "+userId);
        return service.save(restaurantId, day, userId);    }

    public void update(int restaurantId, LocalDate day, int userId) {
        log.info("update restaurantId " + restaurantId+", day "+ ", userId "+userId);
        service.save(restaurantId, day, userId);
    }

    public void delete(int id, int userid) {
        log.info("delete " + id + ", userId " + userid);
        service.delete(id, userid);
    }
}
