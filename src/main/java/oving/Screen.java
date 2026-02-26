package oving;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class Screen {
  protected Pane root;
  protected Scene scene;
  protected ScreenManager screenManager;

  public Screen(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  protected final void init() {
    this.root = createRoot();
    this.scene = new Scene(root, 800, 600);
    setupButtons();
  }

  protected abstract Pane createRoot();

  protected abstract void setupButtons();

  public Scene getScene() {
    return scene;
  }

  public void onEnter() {
  } // Called when screen becomes active

  public void onExit() {
  } // Called when screen is left
}
