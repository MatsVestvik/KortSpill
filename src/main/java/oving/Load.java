package oving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Load {

  public static ImageView loadImageView(String path, int height) {
    Image image = new Image(path);

    double ratio = image.getWidth() / image.getHeight();

    ImageView imageView = new ImageView(new Image(path, height * ratio, height, true, false));
    return imageView;

  }
}
