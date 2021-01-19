package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Stage thisStage;

    @FXML
    private TilePane tilePane;

    Path sourcePath = Paths.get("C:\\Users\\Tatiana\\Documents\\Pictures");
    List<String> dirsNames = new ArrayList<>();
    List<String> name = new ArrayList<>(1);

    public Controller() {

        thisStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showStage() {
        thisStage.showAndWait();
    }

    public Path getSourcePath(){
        return sourcePath;
    }

    public void initialize() {

        File[] listOfDirs = sourcePath.toFile().listFiles();
        for (File dir : listOfDirs) {

            dirsNames.add(dir.getName());

            Image image = new Image("file:dir.png", 130,0,true,true);
            ImageView imageView = new ImageView(image);
            Label label = new Label();
            label.setText(dir.getName());
            VBox vBox = new VBox();
            vBox.setPadding(new Insets(10,10,10,10));
            vBox.getChildren().addAll(imageView, label);
            vBox.setAlignment(Pos.CENTER);

            tilePane.getChildren().add(vBox);

            label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    if (mouseEvent.getClickCount() == 2){
                       String dirName = label.getText();
                       name.add(dirName);

                       openGallery();
                       name.clear();

                    }
                }
            });
        }
    }

    public void openGallery(){
        GalleryController gallery = new GalleryController(this);
        gallery.showStage();
    }

    public String getDirName() {
        return name.get(0);
    }

}
