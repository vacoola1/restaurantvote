package ua.vacoola.restaurantvote.web.restaurant;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ua.vacoola.restaurantvote.RestaurantTestData;
import ua.vacoola.restaurantvote.RestaurantTestData.*;
import ua.vacoola.restaurantvote.model.Restaurant;
import ua.vacoola.restaurantvote.service.RestaurantService;
import ua.vacoola.restaurantvote.web.AbstractControllerTest;
import ua.vacoola.restaurantvote.web.json.JsonUtil;


import java.util.Arrays;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by r.vakulenko on 02.06.2016.
 */
public class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL + '/';

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testCreateWithLocation() throws Exception {
        Restaurant created = RestaurantTestData.getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created))
/*
                .with(userHttpBasic(ADMIN))
*/
        );

        Restaurant returned = RestaurantTestData.MATCHER.fromJsonAction(action);
        created.setId(returned.getId());

        RestaurantTestData.MATCHER.assertEquals(created, returned);
//        RestaurantTestData.MATCHER.assertCollectionEquals(Arrays.asList(ADMIN_MEAL2, created, ADMIN_MEAL), service.getAll(ADMIN_ID));

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }
}