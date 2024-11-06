package comands;

import controllers.Validator;
import entiti.Result;
import entiti.ResultCode;
import util.Constants;

public class BruteForce implements Action{

    //Не тупи и нормально реши проблемы с путем для создания файлов в зависимости от системы
    @Override
    public Result execute(String[] parameters) {

        new Validator("bruteforce").validate(parameters);

        Encode encode = new Encode();
        String[] args = new String[3];
        args[0] = parameters[0];
        String pathOfFileToBrutForce = parameters[1];
        char separator = pathOfFileToBrutForce.charAt(0) == '/' ? '/': '\\';
        for (int key = 0; key < Constants.ALPHABET.size(); key++) {
            args[1] = pathOfFileToBrutForce + separator + "brutForceKey"+ key;
            args[2] = Integer.valueOf(key).toString();
            encode.execute(args);
        }
        return new Result("The BrutForce was successful", ResultCode.OK);
    }
}
