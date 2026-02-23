package oving;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShopScreen extends Screen {

  private Scene scene;
  private Button exit;

  public ShopScreen(ScreenManager screenManager) {
    super(screenManager);
  }

  @Override
  protected Pane createRoot() {
    return new VBox(10);
  }

  @Override
  protected void setupButtons() {
    Button exit = new Button("exit");

    exit.setOnAction(e -> {
      screenManager.switchToScreen(new StartScreen(screenManager));
    });

    root.getChildren().addAll(exit);
  }

  @Override
  public void onEnter() {
  }

  @Override
  public void onExit() {
  }
}
