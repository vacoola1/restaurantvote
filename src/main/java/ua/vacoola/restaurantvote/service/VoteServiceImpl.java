package ua.vacoola.restaurantvote.service;

import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.model.Vote;
import ua.vacoola.restaurantvote.repository.RestaurantRepository;
import ua.vacoola.restaurantvote.repository.UserRepository;
import ua.vacoola.restaurantvote.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Created by r.vakulenko on 16.06.2016.
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

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
    public Vote save(int restaurantId, LocalDate day, int userId) {
        User user = Objects.requireNonNull(userRepository.get(userId));
        Restaurant restaurant = Objects.requireNonNull(restaurantRepository.get(restaurantId));
        return repository.save(restaurant, day, user);
    }

    @Override
    public void delete(int id, int userid) {
        repository.delete(id, userid);
    }

    @Override
    public List<Vote> getFilter(boolean filterByRestraunt, Integer restaurantid, boolean filterByUsre, Integer userId, LocalDate startDate, LocalDate endDate) {
        return repository.getFilter(filterByRestraunt, restaurantid, filterByUsre, userId, startDate, endDate);
    }
}
