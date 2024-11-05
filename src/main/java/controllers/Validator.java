package controllers;

import exception.AppException;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    private String action;

    public Validator(String action) {
        this.action = action;
    }

    public boolean validate(String[] parameters) {
        boolean isValid = false;
        switch (Actions.valueOf(action.toUpperCase())) {
            case DECODER -> isValid = decoderValidate(parameters);
            case ENCODER -> isValid = encoderValidate(parameters);
            case BRUTEFORCE -> isValid = bruteForceValidate(parameters);
        }
        return isValid;
    }

    private boolean encoderValidate(String[] parameters) {
        if (parameters.length != 3) {
            throw new AppException("Incorrect number of arguments");
        }
        if (!Files.isExecutable(Path.of(parameters[0])) &&
                !Path.of(parameters[1]).isAbsolute()) {
            throw new AppException("File not found", new FileNotFoundException());
        }
        try {
            Integer.parseInt(parameters[2]);
        } catch (NumberFormatException e) {
            throw new AppException("Not valid Key",e);
        }
        return true;
    }
    private boolean decoderValidate(String[] parameters){
        return encoderValidate(parameters);
    }
    private boolean bruteForceValidate(String[] parameters){
        if (parameters.length != 2){
            throw new AppException("Incorrect number of arguments");
        }
        if (!Files.isExecutable(Path.of(parameters[0]))){
            throw new AppException("File not found", new FileNotFoundException());
        }
        if (!Files.isDirectory(Path.of(parameters[1])) && !Files.exists(Path.of(parameters[1]))){
            throw new AppException("Is not a directory, or directory not exist", new FileNotFoundException());
        }
        return true;
    }
}
