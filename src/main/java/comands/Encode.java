package comands;

import entiti.Result;
import entiti.ResultCode;
import exception.AppException;
import util.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Encode implements Action {
    @Override
    public Result execute(String[] parameters) {
        String pathFileToEncrypt = parameters[0];
        String pathFileToEncode = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return doResult(pathFileToEncrypt, pathFileToEncode, key);
    }
    private Result doResult(String fileToEncrypt, String fileToEncode, int key){
        key = key % Constants.ALPHABET.size();

        try (var bufferedReader = Files.newBufferedReader(Path.of(fileToEncrypt));
        var bufferedWriter = Files.newBufferedWriter(Path.of(fileToEncode))){
            while (bufferedReader.ready()){
                String string = bufferedReader.readLine();
                bufferedWriter.write(encode(string.toLowerCase(), key));
            }
            return new Result("Еhe encryption was successful", ResultCode.OK);
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
    private String encode (String messageForCoding, int key){
        char[] charArray = messageForCoding.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            int indexInAlphabet = Constants.ALPHABET.indexOf(Character.valueOf(c));
            if (indexInAlphabet < 0){
                stringBuilder.append(c);
                continue;
            }
            int newIndex = (indexInAlphabet + key) % Constants.ALPHABET.size();
            stringBuilder.append(Constants.ALPHABET.get(newIndex));
        }
        return stringBuilder.toString();
    }
}
