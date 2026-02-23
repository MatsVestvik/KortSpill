package oving;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {

    Card card = new Card(11, 'C');
    card.createDisplayObject(5);
    Scene scene = new Scene(card.getDisplayObject());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
