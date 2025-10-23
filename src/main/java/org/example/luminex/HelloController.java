package org.example.luminex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private HBox cardLayout;


    @FXML
    private GridPane bookContainer;

    private List<Book> recentlyAdded;
    private List<Book> recommended;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = new ArrayList<>(recentlyAdded());
        recommended = new ArrayList<>(books());
        int column=0, row=1;
        try{
            for (Book value : recentlyAdded) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(value);
                cardLayout.getChildren().add(cardBox);

            }
            for (Book book : recommended){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("book.fxml"));
                VBox bookBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
               bookController.setData(book);

                if(column==6){
                    column=0;
                    ++row;
                }
                bookContainer.add(bookBox, column++, row);
                GridPane.setMargin(bookBox, new Insets(10));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private List<Book> recentlyAdded(){
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setName("Rich Dad\nPoor Dad");
        book.setImageSrc("/org/example/luminex/img/no-cats-in-the-library-9781665933681_lg.jpg");
        book.setAuthor("Robert T.Kiyosaki");
        ls.add(book);


        book = new Book();
        book.setName("Atomic Habits");
        book.setImageSrc("/org/example/luminex/img/no-cats-in-the-library-9781665933681_lg.jpg");
        book.setAuthor("James Clear");
        ls.add(book);

        book = new Book();
        book.setName("The Alchemist");
        book.setImageSrc("/org/example/luminex/img/no-cats-in-the-library-9781665933681_lg.jpg");
        book.setAuthor("Paulo Coelho");
        ls.add(book);
        return ls;
    }

    private List<Book> books(){
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setName("Rich Dad\nPoor Dad");
        book.setImageSrc("/org/example/luminex/img/no-cats-in-the-library-9781665933681_lg.jpg");
        book.setAuthor("Robert T.Kiyosaki");
        ls.add(book);


        book = new Book();
        book.setName("Atomic Habits");
        book.setImageSrc("/org/example/luminex/img/no-cats-in-the-library-9781665933681_lg.jpg");
        book.setAuthor("James Clear");
        ls.add(book);

        book = new Book();
        book.setName("The Alchemist");
        book.setImageSrc("/org/example/luminex/img/no-cats-in-the-library-9781665933681_lg.jpg");
        book.setAuthor("Paulo Coelho");
        ls.add(book);
        return ls;
    }
}
