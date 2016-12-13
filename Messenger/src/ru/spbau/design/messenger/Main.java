package ru.spbau.design.messenger;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.spbau.design.messenger.view.GUI;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI gui = new GUI(primaryStage);
        gui.update("Hello, world!");
        gui.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
