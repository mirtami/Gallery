package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GalleryController {

    private Stage thisStage;
    private Controller controller;

    @FXML
    private TilePane tilePane;
    @FXML
    private Button button;


    public GalleryController(Controller controller) {

        this.controller = controller;
        thisStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Gallery.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.showAndWait();
    }

    public void initialize() {

        Path destPath = Paths.get(controller.getSourcePath() + File.separator + controller.getDirName());

        File[] listOfPictures = destPath.toFile().listFiles();
        for (File pic : listOfPictures) {
            Image image = new Image("file:"+pic.getPath(), 130,0,true,true);
            ImageView imageView = new ImageView();
            imageView.setImage(image);

            tilePane.getChildren().addAll(imageView);
        }

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openMenu();
            }
        });


    }

    public void openMenu(){
        Controller controller = new Controller();
        controller.showStage();
    }


}
