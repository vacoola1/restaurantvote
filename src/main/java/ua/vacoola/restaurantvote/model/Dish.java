package ua.vacoola.restaurantvote.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by r.vakulenko on 30.05.2016.
 */
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "dishes")
@NamedQueries({
@NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id AND d.menu.id=:menuId"),
@NamedQuery(name = Dish.DELETE_FOR_MENU, query = "DELETE FROM Dish d WHERE d.menu.id=:menuId"),
@NamedQuery(name = Dish.ALL_FOR_MENU, query = "SELECT d FROM Dish d WHERE d.menu.id=:menuId"),
})
public class Dish extends NamedEntity {

    public static final String DELETE = "Dish.delete";
    public static final String ALL_FOR_MENU = "Dish.AllForMenu";
    public static final String DELETE_FOR_MENU = "Dish.deleteForMenu";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "price", nullable = true)
    private Integer price;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
