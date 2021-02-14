package sample;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    private Button buttonSend;

    @FXML
    void enterSend() {
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (textField != null) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        textArea.appendText(textField.getText());
                        textField.clear();
                        textArea.appendText("\n");
                    }
                }
            }
        });

    }

    @FXML
    void initialize() {

        if (textField != null) {
            buttonSend.setOnAction(actionEvent -> {
                try {
                    textArea.appendText(textField.getText());
                    textField.clear();
                    textArea.appendText("\n");


                } catch (Exception e) {
                    System.out.println("Регистрация не загружается");
                }
            });
        }
    }

    public void buttonAnimated(MouseEvent mouseEvent) {
        buttonSend.setStyle("-fx-background-color: #d9FFbf;" + "-fx-text-fill: #000000");
    }

    public void buttonFree(MouseEvent mouseEvent) {
        buttonSend.setStyle("-fx-background-color: #57998d;");
    }
}


