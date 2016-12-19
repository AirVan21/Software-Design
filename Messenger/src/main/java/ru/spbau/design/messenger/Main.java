package ru.spbau.design.messenger;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.view.IView;
import ru.spbau.design.messenger.view.JavaGUI;

import java.util.List;
import java.util.logging.Level;

public class Main extends Application {
    private final Logger LOGGER = new Logger(getClass().getName());

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGGER.log(Level.INFO, "Starting application...");

        final List<String> args = getParameters().getRaw();
        if (args.size() < 2) {
            LOGGER.log(Level.WARNING, "Invalid number of input arguments!");
        }

        int port = 8080;
        try {
            port = Integer.parseInt(args.get(1));
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            LOGGER.log(Level.INFO, "Starting Application on port = " + Integer.toString(port));
        }

        final IMessenger messenger = new Messenger(args.get(0), port);
        final IView gui = new JavaGUI(messenger, primaryStage);
        messenger.addView(gui);
        messenger.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
