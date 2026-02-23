package oving;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
  private Stage stage;
  private Scene scene;

  public ScreenManager(Stage stage) {
    this.stage = stage;
  }

  public void switchToScreen(Screen screen) {
    stage.setScene(screen.getScene());
    screen.onEnter();
  }
}
