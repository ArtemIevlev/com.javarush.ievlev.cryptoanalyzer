package util;

import entiti.FileManager;
import exception.AppException;

import java.util.Scanner;

public class ArgsMaker {
    public static String[] doArgs(){
        Scanner sca = new Scanner(System.in);
        System.out.println("""
                Select the operating mode:
                1. Encoder
                2. Decoder
                3. BruteForce
                4.Analysis
                """);
        String mode = sca.nextLine();
        if (mode.equalsIgnoreCase("encoder")){
            String[] args = makeEncoderArgs(sca);
            return args;
        }else if (mode.equalsIgnoreCase("decoder")){
            String[] args = makeDecoderArgs(sca);
            return args;
        } else if (mode.equalsIgnoreCase("bruteforce")) {
            throw  new AppException("function not ready now");
        } else if (mode.equalsIgnoreCase("Analysis")) {
            throw  new AppException("function not ready now");
        }else {
            throw new AppException("mode not found");
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
}
