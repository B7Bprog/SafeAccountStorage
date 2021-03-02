package GradleFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAccountSceneController implements Initializable {
    @FXML
    private TextField accName;
    @FXML
    private TextField username;
    @FXML
    private TextField addPW;
    @FXML
    private Label prompt;

    @FXML
    private Label time;

    @FXML
    private TextArea notes;

    @FXML
    private ProgressBar bar;

    private static Label myPrompt;


    private static TextField myAccName;
    private static TextField myUsername;
    private static TextField myAddPW;

    protected static String newAccountName;
    protected static String newUsername;
    protected static String newAccountPW;
    protected static String newNotes;
    private static Label myTime;
    private static ProgressBar myBar;
    private static TextArea myNotes;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myAccName = accName;
        myUsername = username;
        myAddPW = addPW;
        myPrompt = prompt;
        myTime = time;
        myBar = bar;
        myNotes = notes;
        ActivatedWindows.isAddAccountSceneController = true;
    }

    public void setBar(){
        myBar.setProgress((double)SceneController.timercount/241);
    }

    public void extendTime(){
        SceneController.timercount=241;
    }

    public void setTimeLabel(String timeLeft){
        myTime.setText(timeLeft);
    }

    public void setParameters() throws Exception {
        SceneController.timercount = 241;
        newAccountName = myAccName.getText();
        newUsername = myUsername.getText();
        newAccountPW = myAddPW.getText();
        newNotes = myNotes.getText();
        AddAccount.add();
    }

    public static void accExxists() {
        myPrompt.setTextFill(Color.RED);
        myPrompt.setText("This account already exists. Choose an other name.");
    }

    public static void success() {
        myPrompt.setTextFill(Color.DARKGREEN);
        myPrompt.setText("New account has been created successfully.");

    }

    public static void emptyName() {
        myPrompt.setTextFill(Color.RED);
        myPrompt.setText("All fields must contain at least one character!");
    }

    public static void tooLongNames() {
        myPrompt.setTextFill(Color.RED);
        myPrompt.setText("All fields must be shorter than 70 characters and notes less than 500!");
    }


    public void backToMenu(ActionEvent event) throws IOException, InterruptedException {
        SceneController.timercount = 241;
        if (MasterKey.isRightKey) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        }
    }

}
