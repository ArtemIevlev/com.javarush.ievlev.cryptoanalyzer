package controllers;

import comands.Action;
import entiti.Result;

public class MainController {
    public Result doAction(String actionName, String[] parameters){
        Action action = Actions.find(actionName);
        Result execute = action.execute(parameters);
        return execute;
    }
}
