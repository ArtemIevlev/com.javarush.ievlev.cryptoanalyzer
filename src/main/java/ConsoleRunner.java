import entiti.Application;
import entiti.Result;
import util.ArgsMaker;

import java.util.Arrays;

public class ConsoleRunner {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        if (args.length == 0){
            args = ArgsMaker.doArgs();
        }
        Application application = new Application();
        Result result =  application.run(args);
        System.out.println(result);
    }
}
