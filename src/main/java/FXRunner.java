import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FXRunner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXRunner.class.getResource("FXloader.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 732, 432);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        InputStream icon = getClass().getResourceAsStream("imeges/icon.png");
        Image image = new Image(icon);
        primaryStage.getIcons().add(image);

        primaryStage.show();
    }
}
