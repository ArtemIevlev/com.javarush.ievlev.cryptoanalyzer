package entiti;

import exception.AppException;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static boolean isFileExist(String path){
        Path path1 = Path.of(path);
        if (Files.isExecutable(path1)) {
            return true;
        }
        return false;
    }
    public static void makeFile (String path){

    }
}
