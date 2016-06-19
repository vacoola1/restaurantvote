package ua.vacoola.restaurantvote.web.vote;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.vacoola.restaurantvote.LoggedUser;
import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.model.Vote;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 03.06.2016.
 */
@RestController
@RequestMapping(value = ProfileVoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileVoteRestController extends AbstractVoteController{
    public static final String REST_URL = "/rest/profile/votes";

    @RequestMapping(method = RequestMethod.GET)
    public List<Vote> getAll() {
        return super.getAll(LoggedUser.id());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Vote get(@PathVariable("id") int id) {
        return super.get(id, LoggedUser.id());
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<Vote> getFilter(@RequestParam(name = "restaurantId", required = false) Integer restaurantId,
                          @RequestParam(name = "startDay", required = false) LocalDate startDay,
                          @RequestParam(name = "endDay", required = false) LocalDate endDay)
    {
        return super.getFilter(restaurantId, LoggedUser.id(), startDay, endDay);
    }

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public Vote getNow() {
        return super.getNow(LoggedUser.id());
    }

    @RequestMapping(value = "/now/{restaurantId}/{day}", method = RequestMethod.POST)
    public ResponseEntity<Vote> createWithLocation(@PathVariable("restaurantId") int restaurantId, @PathVariable("day") LocalDate day) {

        Vote created = super.create(restaurantId, day, LoggedUser.id());

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);

    }

    @RequestMapping(value = "/now/{restaurantId}/{day}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("restaurantId") int restaurantId, @PathVariable("day") LocalDate day) {
        super.update(restaurantId, day, LoggedUser.id());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id, LoggedUser.id());
    }
}
