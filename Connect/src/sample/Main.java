package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Parent firstRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Parent secondRoot = FXMLLoader.load(getClass().getResource("Gallery.fxml"));
//
//
//        Scene scene = new Scene(firstRoot, 400, 600);
//
//
//        primaryStage.setMinHeight(400);
//        primaryStage.setMinWidth(600);
//        primaryStage.setScene(scene);
//        primaryStage.show();


        Controller controller = new Controller();
        controller.showStage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
