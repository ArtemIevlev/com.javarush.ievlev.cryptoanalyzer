package entiti;

import controllers.MainController;
import exception.AppException;

import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            //Result result = mainController.doAction(action, parameters);
            return result;
        } else {
            throw new AppException("no args");
        }
    }
}
