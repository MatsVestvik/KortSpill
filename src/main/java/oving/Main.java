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
    ScreenManager screenManager = new ScreenManager(stage);
    stage.show();
    StartScreen startScreen = new StartScreen(screenManager);
    screenManager.switchToScreen(startScreen);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
