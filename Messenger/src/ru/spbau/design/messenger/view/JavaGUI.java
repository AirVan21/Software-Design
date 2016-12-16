package ru.spbau.design.messenger.view;


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
import ru.spbau.design.messenger.IMessenger;
import ru.spbau.design.messenger.model.ILogger;
import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class JavaGUI implements IView {
    private Stage stage;
    private TextArea chat;
    private IMessenger application;
    private final ILogger logger = new Logger(getClass().getName());

    public JavaGUI(IMessenger application, Stage stage) {
        this.application = application;
        this.stage = stage;
        addScene();
    }

    @Override
    public void sendData(String data, String targetHost, int port) {
        logger.log(Level.INFO, "sending data = " + data);
        application.sendMessage(data, targetHost, port);
    }

    @Override
    public void show() {
        stage.show();
    }

    @Override
    public void handleUpdate(Optional<List<IMessage>> messages) {
        if (!messages.isPresent()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        for (IMessage message : messages.get()) {
            sb.append("<")
                    .append(message.getAddress())
                    .append(">: ")
                    .append(message.getText())
                    .append("\n");
        }
        chat.setText(sb.toString());
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
        userNameField.setText(application.getHost() + ":" + Integer.toString(application.getPort()));

        Label friendIp = new Label("Friend IP:");
        grid.add(friendIp, 0, 2);
        TextField friendIpField = new TextField();
        grid.add(friendIpField, 1, 2);

        Label friendPort = new Label("Friend Port:");
        grid.add(friendPort, 0, 3);
        TextField friendPortField = new TextField();
        grid.add(friendPortField, 1, 3);

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
            if (!friendIp.getText().isEmpty() && !friendPortField.getText().isEmpty() && !messageArea.getText().isEmpty()) {
                String address = friendIpField.getText();
                int port = Integer.parseInt(friendPortField.getText());
                String text = messageArea.getText();
                sendData(text, address, port);
            }
        });

        return grid;
    }
}
