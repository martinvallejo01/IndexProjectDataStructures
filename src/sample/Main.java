package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.TreeMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(5,5);
        tree.put(1,1);
        tree.put(3,3);
        tree.put(7,7);
        tree.put(9,9);
        for (Integer i: tree.values()) {
            System.out.print(i);
        }
    }
}
