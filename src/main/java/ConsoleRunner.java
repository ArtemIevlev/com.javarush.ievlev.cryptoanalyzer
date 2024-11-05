import entiti.Application;
import entiti.Result;
import util.ArgsMaker;


public class ConsoleRunner {

    public static void main(String[] args) {

        if (args.length == 0)
            args = ArgsMaker.doArgs();

        Application application = new Application();
        Result result =  application.run(args);
        System.out.println(result);
    }
}
