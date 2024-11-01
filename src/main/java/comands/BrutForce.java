package comands;

import entiti.Result;
import entiti.ResultCode;
import util.Constants;

public class BrutForce implements Action{
    @Override
    public Result execute(String[] parameters) {
        Encode encode = new Encode();
        String[] args = new String[3];
        args[0] = parameters[0];
        String pathOfFileToBrutForce = parameters[1];
        for (int key = 0; key < Constants.ALPHABET.size(); key++) {
            args[1] = pathOfFileToBrutForce + "\\" + "brutForceKey"+ key;
            args[2] = Integer.valueOf(key).toString();
            encode.execute(args);
        }
        return new Result("The BrutForce was successful", ResultCode.OK);
    }
}
