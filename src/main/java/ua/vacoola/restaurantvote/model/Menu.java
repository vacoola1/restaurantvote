package ua.vacoola.restaurantvote.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by r.vakulenko on 30.05.2016.
 */
@NamedQueries({
        @NamedQuery(name = Menu.DELETE, query = "DELETE FROM Menu m WHERE m.id=:id"),
        @NamedQuery(name = Menu.ALL, query = "SELECT m FROM Menu m"),
        @NamedQuery(name = Menu.FILTER, query = "SELECT m FROM Menu m " +
                "WHERE m.day>=:startDay AND m.day<=:endDay " +
                "AND (:FilterByRestaurant = false OR m.restaurant.id = :restaurantId)")
})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "menues", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "day"}, name = "restaurant_id_day_idx")})
public class Menu extends BaseEntity {

    public static final String DELETE = "Menu.delete";
    public static final String ALL = "Menu.getAll";
    public static final String FILTER = "Menu.filter";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "day", nullable = false, columnDefinition = "date default now()")
    @NotNull
    private LocalDate day;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "menu")
    @OrderBy("id DESC")
//    @JsonIgnore
    private List<Dish> dishs;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public List<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs.stream().collect(Collectors.toList());
    }
}
