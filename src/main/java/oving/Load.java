package oving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Load {

  public static ImageView loadImageView(String path, int height, int width) {
    try {
      ImageView image = new ImageView(new Image(path, width, height, true, false));
      return image;

    } catch (Exception e) {
      ImageView image = new ImageView(new Image("back.png", width, height, true, false));
      return image;
    }

  }
}
