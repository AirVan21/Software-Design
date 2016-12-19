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
import ru.spbau.design.messenger.model.interfaces.ILogger;
import ru.spbau.design.messenger.model.interfaces.IMessage;
import ru.spbau.design.messenger.model.Logger;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class JavaGUI implements IView {
    private IMessenger application;
    private Stage stage;
    private final ILogger logger = new Logger(getClass().getName());
    // GUI elements
    private Optional<Label> warningLabel = Optional.empty();
    private TextField userNameField;
    private TextField friendIpField;
    private TextField friendPortField;
    private TextArea messageArea;
    private TextArea chat;

    public JavaGUI(IMessenger application, Stage stage) {
        this.application = application;
        this.stage = stage;
        addScene();
    }

    @Override
    public void sendData(String data, String targetHost, int port) {
        logger.log(Level.INFO, "sends data = " + data);
        logger.log(Level.INFO, "sending data = " + data);
        application.sendMessage(data, targetHost, port);
    }

    @Override
    public void show() {
        stage.show();
    }

    @Override
    public void close() {
        stage.close();
    }

    @Override
    public void handleUpdate(String address, Optional<List<IMessage>> messages) {
        logger.log(Level.INFO, "handles update from = " + address);
        if (!messages.isPresent() || messages.get().isEmpty()) {
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
        updateFriendFields(address);
    }

    private void updateFriendFields(String address) {
        String[] friendInfo = address.split(":");
        // 2 -> ip:port
        if (friendInfo.length != 2) {
            return;
        }
        friendIpField.setText(friendInfo[0]);
        friendPortField.setText(friendInfo[1]);
    }

    /**
     * Adds scene to stage
     */
    private void addScene()  {
        logger.log(Level.INFO, "adds scene");
        final GridPane grid = buildGrid();
        Scene scene = new Scene(grid, 600, 500);
        stage.setScene(scene);
    }

    /**
     * Builds grid and adds main fields to grid
     * @return
     */
    private GridPane buildGrid() {
        logger.log(Level.INFO, "builds grid");
        final GridPane grid = new GridPane();
        // Sets gaps
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(20);
        grid.setVgap(25);
        grid.setPadding(new Insets(25, 25, 25, 25));

        final Text sceneTitle = new Text("Instant messenger");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        grid.add(sceneTitle, 0, 0, 2, 1);

        final Label userName = new Label("Your Name:");
        grid.add(userName, 0, 1);
        userNameField = new TextField();
        grid.add(userNameField, 1, 1);
        userNameField.setText(application.getHost() + ":" + Integer.toString(application.getPort()));

        final Label friendIp = new Label("Friend IP:");
        grid.add(friendIp, 0, 2);
        friendIpField = new TextField();
        grid.add(friendIpField, 1, 2);

        final Label friendPort = new Label("Friend Port:");
        grid.add(friendPort, 0, 3);
        friendPortField = new TextField();
        grid.add(friendPortField, 1, 3);

        chat = new TextArea();
        grid.add(chat, 1, 4);
        chat.setEditable(false);

        final Label userMessage = new Label("Message:");
        grid.add(userMessage, 0, 5);
        messageArea = new TextArea();
        messageArea.setMaxHeight(100);
        grid.add(messageArea, 1, 5);

        addButtonToGrid(grid);

        return grid;
    }

    /**
     * Adds button to grid
     * @param grid - grid where button will be added
     */
    private void addButtonToGrid(GridPane grid) {
        final Button button = new Button("Send message");
        final HBox hbBtn = new HBox(25);

        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(button);
        grid.add(hbBtn, 1, 6);

        button.setOnAction(event -> {
            if (!mainFieldIsEmpty()) {
                String address = friendIpField.getText();
                int port = Integer.parseInt(friendPortField.getText());
                String name = userNameField.getText();
                String text = "(" + name + ") " + messageArea.getText();
                sendData(text, address, port);
                messageArea.clear();
                if (warningLabel.isPresent())  {
                    warningLabel.get().setText("");
                }
            } else {
                if (!warningLabel.isPresent()) {
                    warningLabel = Optional.of(new Label("Fill fields!"));
                    grid.add(warningLabel.get(), 0, 6);
                }
            }
        });
    }

    /**
     * Checks are mandatory fields are empty
     * @return true if one of mandatory fields is Empty()
     *         false otherwise
     */
    private boolean mainFieldIsEmpty() {
        return friendPortField.getText().isEmpty() || friendPortField.getText().isEmpty() || messageArea.getText().isEmpty();
    }
}
