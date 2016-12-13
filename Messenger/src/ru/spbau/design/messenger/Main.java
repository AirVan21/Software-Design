package ru.spbau.design.messenger;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.view.IView;
import ru.spbau.design.messenger.view.JavaGUI;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        IMessenger messenger = new Messenger("localhost");
        IView gui = new JavaGUI(primaryStage);
        messenger.addView(gui);
        messenger.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
