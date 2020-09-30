package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Math");
            primaryStage.show();
        } catch (Exception e) {
            System.out.print(e);
        }
    }


    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
