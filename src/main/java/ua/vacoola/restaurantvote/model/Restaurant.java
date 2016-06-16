package ua.vacoola.restaurantvote.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by r.vakulenko on 30.05.2016.
 */
@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.ALL, query = "SELECT r FROM Restaurant r"),
        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT r FROM Restaurant r ORDER BY r.name"),
})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {
    public static final String DELETE = "Restaurant.delete";
    public static final String ALL = "Restaurant.getAll";
    public static final String ALL_SORTED = "Restaurant.getAllSorted";

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant() {
    }
}
