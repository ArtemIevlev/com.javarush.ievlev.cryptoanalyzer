package util;

import entiti.FileManager;
import exception.AppException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ArgsMaker {
    private static final String MENU = """
                Select the operating mode:
                1. Encoder
                2. Decoder
                3. BruteForce
                4. Analysis
                """;
    public static String[] doArgs(){
        Scanner sca = new Scanner(System.in);
        System.out.println(MENU);

        switch (sca.nextLine().toLowerCase()){
            case "encoder":  return makeEncoderArgs(sca);
            case "decoder":  return makeDecoderArgs(sca);
            case "bruteforce": return makeBrutForceArgs(sca);
            case "analysis":  throw  new AppException("function not ready now");
            default: throw new AppException("mode not found");
        }
    }
    private static String[] makeEncoderArgs(Scanner sca){
        String[] args = new String[4];
        args[0] = "encoder";
        while (true) {
            System.out.println("___________________________");
            System.out.println("Write the full name of the file to encode");
            args[1] = sca.nextLine().trim();
            if (!FileManager.isFileExist(args[1])){
                System.out.println("File is not exist");
                continue;
            }
            System.out.println("Write the full name of the file where to encrypt");
            args[2] = sca.nextLine().trim();
            if (!FileManager.isFileExist(args[2])){
                System.out.println("File is not exist");
                continue;
            }
            System.out.println("Write a key");
            args[3] = sca.nextLine().trim();
            try {
                Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.out.println("Is not a number");
                continue;
            }
            return args;
        }

    }
    private static String[] makeDecoderArgs(Scanner sca){
        String[] args = new String[4];
        args[0] = "decoder";
        while (true) {
            System.out.println("__________________________");
            System.out.println("Write the full name of the file to decode");
            args[1] = sca.nextLine().trim();
            if (!FileManager.isFileExist(args[1])){
                System.out.println("File is not exist");
                continue;
            }
            System.out.println("Write the full name of the file where to decode");
            args[2] = sca.nextLine().trim();
            if (!FileManager.isFileExist(args[1])){
                System.out.println("File is not exist");
                continue;
            }
            System.out.println("Write a key");
            args[3] = sca.nextLine().trim();
            try {
                Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.out.println("Is not a number");
                continue;
            }
            return args;
        }
    }
    private static String[] makeBrutForceArgs(Scanner sca){
        String[] args = new String[3];
        args[0] = "bruteforce";
        while (true){
            System.out.println("Write the full name of the file to decode");
            args[1] = sca.nextLine().trim();
            if (!FileManager.isFileExist(args[1])){
                System.out.println("File is not exist");
                continue;
            }
            System.out.println("Write the full name of the package where to decode");
            args[2] = sca.nextLine().trim();
            if (!Files.isDirectory(Path.of(args[2]))){
                System.out.println("Is not a directory");
                continue;
            }
            return args;
        }
    }
}
