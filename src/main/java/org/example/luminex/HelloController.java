package org.example.luminex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private HBox cardLayout;
    private List<Book> recentlyAdded;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = new ArrayList<>(recentlyAdded());
        try{
            for(int i=0; i<recentlyAdded.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(recentlyAdded.get(i));
                cardLayout.getChildren().add(cardBox);

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
}
