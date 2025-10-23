package org.example.luminex;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class CardController {

    @FXML
    private HBox box;

    @FXML
    private ImageView bookImage;

    @FXML
    private Label bookName;

    @FXML
    private Label authorName;

    private String[] colors = {"#B9E5FF", "#BDB2FE", "#FB9AA8", "#FF5056"};

    public void setData(Book book) {
        Image image = new Image(getClass().getResourceAsStream(book.getImageSrc()));
        bookImage.setImage(image);

        bookName.setText(book.getName());
        authorName.setText(book.getAuthor());
        box.setStyle("-fx-background-color: " + Color.web(colors[(int)(Math.random() * colors.length)]));
    }
}