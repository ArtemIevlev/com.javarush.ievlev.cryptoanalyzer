package comands;

import entiti.Result;
import util.Constants;

public class Decode implements Action{
    @Override
    public Result execute(String[] parameters) {
        Integer i = Constants.ALPHABET.size() - Integer.parseInt(parameters[2]);
        parameters[2] = i.toString();
        Result execute = new Encode().execute(parameters);
        return execute;
    }
}
