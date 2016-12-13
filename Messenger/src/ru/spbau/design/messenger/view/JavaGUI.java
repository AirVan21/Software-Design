package ru.spbau.design.messenger.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.spbau.design.messenger.model.ILogger;
import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.Message;

import java.util.logging.Level;

public class JavaGUI implements IView {
    private Stage stage;
    private TextArea chat;
    private final ILogger logger = new Logger();

    public JavaGUI(Stage stage) {
        this.stage = stage;
        addScene();
    }

    @Override
    public void show() {
        stage.show();
    }

    public void update(IMessage message) {

    }

    private void addScene()  {
        final GridPane grid = buildGrid();
        Scene scene = new Scene(grid, 600, 500);
        stage.setScene(scene);
    }

    private GridPane buildGrid() {
        final GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(20);
        grid.setVgap(25);
        grid.setPadding(new Insets(25, 25, 25, 25));

        final Text sceneTitle = new Text("Instant messenger");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        grid.add(sceneTitle, 0, 0, 2, 1);

        final Label userName = new Label("Your Name:");
        grid.add(userName, 0, 1);
        final TextField userNameField = new TextField();
        grid.add(userNameField, 1, 1);

        Label friendIp = new Label("Friend IP:");
        grid.add(friendIp, 0, 2);
        TextField friendIpField = new TextField();
        grid.add(friendIpField, 1, 2);

        Label friendName = new Label("Friend Name:");
        grid.add(friendName, 0, 3);
        TextField friendNameField = new TextField();
        grid.add(friendNameField, 1, 3);

        chat = new TextArea();
        grid.add(chat, 1, 4);
        chat.setEditable(false);

        Label userMessage = new Label("Message:");
        grid.add(userMessage, 0, 5);
        TextArea messageArea = new TextArea();
        messageArea.setMaxHeight(100);
        grid.add(messageArea, 1, 5);

        Button button = new Button("Send message");
        HBox hbBtn = new HBox(25);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(button);
        grid.add(hbBtn, 1, 6);
        button.setOnAction(event -> {
            String address = friendIpField.getText();
            String text = messageArea.getText();
            IMessage message = new Message(address, text);
            logger.log(Level.INFO, message.toString());
            sendMessage(message);
        });

        return grid;
    }

    @Override
    public void handleMessage(IMessage message) {

    }

    @Override
    public void sendMessage(IMessage message) {
        logger.log(Level.INFO, "Sent message: " + message.toString());
    }
}
