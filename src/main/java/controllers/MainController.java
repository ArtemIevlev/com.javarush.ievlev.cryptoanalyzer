package controllers;

import comands.Action;
import entiti.Result;

public class MainController {
    public Result doAction(String actionName, String[] parameters){
        Action action = Actions.find(actionName);
        new Validator(actionName).validate(parameters);
        Result execute = action.execute(parameters);
        return execute;
    }
}
