package controllers;

import comands.Action;
import entiti.Result;
import entiti.ResultCode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class FXController {

    private String[] args;
    @FXML
    private Button encodeButton;

    @FXML
    private TextField encodeTextField;

    @FXML
    protected void selectEncode(){
        args = new String[3];
        encodeButton.setText("Зашифровать");
    }
    @FXML
    protected void selectDecode(){
        args = new String[3];
    }
    @FXML
    protected void selectBruteForce(){
        args = new String[2];
    }

    @FXML
    protected void chooseFileToEncode(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Select File.txt", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            args[0] = file.getAbsolutePath();
        }
    }
    @FXML
    protected void chooseFileToSave(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Select File.txt", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            args[1] = file.getAbsolutePath();
        }
    }
    @FXML
    protected void onEncodeButtonClick(){
        args[2] = encodeTextField.getText();
        Action action = Actions.find("encoder");
        Result execute = action.execute(args);
        if (execute.getResultCode() == ResultCode.OK){
            encodeButton.setText("Успешно!");
        }
    }
    @FXML
    protected void onDecodeButtonClick(){

    }

}
