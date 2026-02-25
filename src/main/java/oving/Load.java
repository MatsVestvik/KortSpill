package oving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Load {

  public static ImageView loadImageView(String path, int height) {
    try {
      String resourceUrl = Load.class.getClassLoader().getResource(path).toExternalForm();
      Image image = new Image(resourceUrl);

      double ratio = image.getWidth() / image.getHeight();

      ImageView imageView = new ImageView(new Image(resourceUrl, height * ratio, height, true, false));
      return imageView;
    } catch (NullPointerException e) {
      throw new RuntimeException("Resource not found: " + path, e);
    }
  }
}
