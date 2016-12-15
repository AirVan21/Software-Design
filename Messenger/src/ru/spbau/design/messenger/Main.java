package ru.spbau.design.messenger;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.view.IView;
import ru.spbau.design.messenger.view.JavaGUI;

import java.util.List;
import java.util.logging.Level;

public class Main extends Application {
    private Logger logger = new Logger(getClass().getName());

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> args = getParameters().getRaw();
        if (args.size() < 2) {
            logger.log(Level.WARNING, "invalid number of input arguments!");
        }
        System.out.println(args);
        IMessenger messenger = new Messenger(args.get(0), Integer.parseInt(args.get(1)));
        IView gui = new JavaGUI(messenger, primaryStage);
        messenger.addView(gui);
        messenger.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
