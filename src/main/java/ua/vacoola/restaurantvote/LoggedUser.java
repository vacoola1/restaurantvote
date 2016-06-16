package ua.vacoola.restaurantvote;

import ua.vacoola.restaurantvote.model.BaseEntity;

import static java.util.Objects.requireNonNull;

public class LoggedUser {
    private static int id = BaseEntity.START_SEQ;

    private LoggedUser() {
    }

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }
}