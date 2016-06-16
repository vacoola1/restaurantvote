package ua.vacoola.restaurantvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vacoola.restaurantvote.model.Vote;
import ua.vacoola.restaurantvote.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 16.06.2016.
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository repository;

    @Override
    public List<Vote> getAll() {
        return repository.getAll();
    }

    @Override
    public Vote get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Vote> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Vote get(int id, int userId) {
        return repository.get(id, userId);
    }

    @Override
    public Vote getNow(int userId) {
        return repository.getForDay(LocalDate.now(), userId);
    }

    @Override
    public Vote save(int restaurantId, int day, int userId) {
        return repository.save(restaurantId, day, userId);
    }

    @Override
    public void delete(int id, int userid) {
        repository.delete(id, userid);
    }

    @Override
    public List<Vote> getFilter(Integer restaurantid, Integer userId, LocalDate startDate, LocalDate endDate) {
        return repository.getFilter(restaurantid, userId, startDate, endDate);
    }
}
