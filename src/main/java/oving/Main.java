package oving;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

  @Override
  public void start(Stage stage) {

    VBox root = new VBox();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
