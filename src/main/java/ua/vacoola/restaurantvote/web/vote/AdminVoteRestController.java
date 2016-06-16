package ua.vacoola.restaurantvote.web.vote;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.model.User;
import ua.vacoola.restaurantvote.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 03.06.2016.
 */
@RestController
@RequestMapping(value = AdminVoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminVoteRestController extends AbstractVoteController {
    public static final String REST_URL = "/rest/admin/votes";

    @RequestMapping(method = RequestMethod.GET)
    public List<Vote> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Vote get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public Vote getFilter(@RequestParam(name = "restaurantId", required = false) Integer restaurantId,
                          @RequestParam(name = "userId", required = false) Integer userId,
                          @RequestParam(name = "startDay", required = false) LocalDate startDay,
                          @RequestParam(name = "endDay", required = false) LocalDate endDay)
    {
        return super.getFilter(restaurantId, userId, startDay, endDay);
    }

}
