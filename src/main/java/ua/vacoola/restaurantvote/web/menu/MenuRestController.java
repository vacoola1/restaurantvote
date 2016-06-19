package ua.vacoola.restaurantvote.web.menu;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.vacoola.restaurantvote.model.Dish;
import ua.vacoola.restaurantvote.model.Menu;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.web.restaurant.RestaurantRestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by r.vakulenko on 03.06.2016.
 */
@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController extends AbstractMenuController {

    public static final String REST_URL = "/rest/admin/menues";

    @RequestMapping(method = RequestMethod.GET)
    public List<Menu> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Menu get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/filter/{day}", method = RequestMethod.GET)
    public List<Menu> getFilterPerDay(@PathVariable("day") LocalDate day)
    {
        return super.getFilterPerDay(day);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<Menu> getFilter(@RequestParam(name = "restaurantId", required = false) Integer restaurantId,
                          @RequestParam(name = "startDay", required = false) LocalDate startDay,
                          @RequestParam(name = "endDay", required = false) LocalDate endDay)
    {
        return super.getFilter(restaurantId, startDay, endDay);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createWithLocation(@RequestBody Menu menu) {

        Menu created = super.create(menu);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Menu menu, @PathVariable("id") int id) {
        super.update(menu, id);
    }

    /////// Dish ///////

    @RequestMapping(value = "/dishes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createDishWithLocation(@RequestBody Dish dish) {

        Dish created = super.createDish(dish);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @RequestMapping(value = "/dishes/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Dish dish, @PathVariable("id") int id) {
        super.updateDish(dish, id);
    }

    @RequestMapping(value = "/{menuId}/dishes/{id}", method = RequestMethod.DELETE)
    public void deleteDish(@PathVariable("menuId") int menuId, @PathVariable("id") int id) {
        super.deleteDish(id, menuId);
    }

}
