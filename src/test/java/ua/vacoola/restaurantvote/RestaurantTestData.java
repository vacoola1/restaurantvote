package ua.vacoola.restaurantvote;

import ua.vacoola.restaurantvote.TestUtil.ToStringModelMatcher;
import ua.vacoola.restaurantvote.matcher.ModelMatcher;
import ua.vacoola.restaurantvote.model.Restaurant;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static ua.vacoola.restaurantvote.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class RestaurantTestData {

    public static final ModelMatcher<Restaurant, String> MATCHER = new ToStringModelMatcher<>(Restaurant.class);

    public static final int REST1_ID = START_SEQ + 2;


    public static final Restaurant REST1 = new Restaurant(REST1_ID, "Ресторан грузинской кухни Шоти");
/*
    public static final UserMeal MEAL2 = new UserMeal(MEAL1_ID + 1, of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
    public static final UserMeal MEAL3 = new UserMeal(MEAL1_ID + 2, of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);
    public static final UserMeal MEAL4 = new UserMeal(MEAL1_ID + 3, of(2015, Month.MAY, 31, 10, 0), "Завтрак", 500);
    public static final UserMeal MEAL5 = new UserMeal(MEAL1_ID + 4, of(2015, Month.MAY, 31, 13, 0), "Обед", 1000);
    public static final UserMeal MEAL6 = new UserMeal(MEAL1_ID + 5, of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);
    public static final UserMeal ADMIN_MEAL = new UserMeal(ADMIN_MEAL_ID, of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510);
    public static final UserMeal ADMIN_MEAL2 = new UserMeal(ADMIN_MEAL_ID + 1, of(2015, Month.JUNE, 1, 21, 0), "Админ ужин", 1500);

    public static final List<UserMeal> USER_MEALS = Arrays.asList(MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1);
*/

    public static Restaurant getCreated() {
        return new Restaurant(null, "Шотиииииии");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(REST1_ID, "new restaurant");
    }
}
