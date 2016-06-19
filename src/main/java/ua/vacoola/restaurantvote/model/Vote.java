package ua.vacoola.restaurantvote.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by r.vakulenko on 30.05.2016.
 */
@NamedQueries({
        @NamedQuery(name = Vote.GET_BY_PARAM, query = "SELECT v FROM Vote v WHERE v.user.id=:userId AND v.restaurant.id=:restaurantId " +
                "AND v.day=:day"),
        @NamedQuery(name = Vote.GET_FOR_DAY_BY_USER, query = "SELECT v FROM Vote v WHERE v.user.id=:userId AND v.day=:day"),
        @NamedQuery(name = Vote.DELETE, query = "DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userid"),
        @NamedQuery(name = Vote.ALL, query = "SELECT v FROM Vote v"),
        @NamedQuery(name = Vote.ALL_BY_USER, query = "SELECT v FROM Vote v WHERE v.user.id=:userId"),
        @NamedQuery(name = Vote.FILTER, query = "SELECT v FROM Vote v WHERE v.day>=:startDate AND v.day<=:endDate " +
                "AND (:FilterByRestaurant = false OR v.restaurant.id = :restaurantId) " +
                "AND (:FilterByUser = false OR v.user.id = :userId) ")
})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "day"}, name = "user_id_day_idx")})
public class Vote extends BaseEntity {

    public static final String DELETE = "Vote.delete";
    public static final String ALL = "Vote.getAll";
    public static final String FILTER = "Vote.filter";
    public static final String ALL_BY_USER = "Vote.ALL_BY_USER";
    public static final String GET_BY_PARAM = "Vote.get";
    public static final String GET_FOR_DAY_BY_USER = "Vote.getForDayByUser";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "day", nullable = false, columnDefinition = "date default now()")
    @NotNull
    private LocalDate day;


    public Vote() {
        super();
    }

    public Vote(User user, Restaurant restaurant, LocalDate day) {
        super();
        this.user = user;
        this.restaurant = restaurant;
        this.day = day;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
