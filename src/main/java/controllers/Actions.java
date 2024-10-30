package controllers;

import comands.Action;
import comands.Encode;
import exception.AppException;

public enum Actions {
    ENCODER(new Encode());

    private final Action action;
    Actions(Action action) {
        this.action = action;
    }
    public static Action find (String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            Action action = value.action;
            return action;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + actionName, e);
        }
    }
}
