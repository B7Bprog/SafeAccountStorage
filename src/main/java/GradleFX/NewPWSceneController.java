package GradleFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewPWSceneController implements Initializable {
    @FXML
    private PasswordField new1;
    @FXML
    private PasswordField new2;
    @FXML
    private Label prompt;
    @FXML
    private Label pwLabel;
    @FXML
    private Button Back;

    @FXML
    private Button create;

    @FXML
    private Label time;

    @FXML
    private ProgressBar bar;

    protected static PasswordField myNew1;
    private static PasswordField myNew2;
    private static Label myPrompt;
    private static Label myPWLabel;
    protected static Button myBackButton;
    protected static Button myCreateButton;
    private static Label myTime;
    private static ProgressBar myBar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myNew1 = new1;
        myNew2 = new2;
        myPrompt = prompt;
        myPWLabel = pwLabel;
        myBackButton = Back;
        myCreateButton = create;
        myTime = time;
        myBar = bar;
        ActivatedWindows.isNewPWSceneController = true;
        myBackButton.setDisable(true);
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

    public static void disablemyCreateButton() {
        myCreateButton.setDisable(true);
    }

    public static void enablemyCreateButton() {
        myCreateButton.setDisable(false);
    }

    public static void disableBackButton() {
        myBackButton.setDisable(true);
    }

    public static void enableBackButton() {
        myBackButton.setDisable(false);
    }


    public void showPW() {
        SceneController.timercount = 241;
        myPWLabel.setText(myNew1.getText());
    }

    public void hidePW() {
        myPWLabel.setText("");
    }


    public static void prompt(String text) {
        myPrompt.setTextFill(Color.DARKGREEN);
        myPrompt.setText(text);
    }

    public static void prompKeyAlreadyExists(String text) {
        myPrompt.setTextFill(Color.RED);
        myPrompt.setText(text);
    }

    public void changePW() throws Exception {

        SceneController.timercount = 241;
        if (myNew1.getText().equals(myNew2.getText())) {
            if (myNew1.getText().length() > 7) {


                /*SleepTimer sleepTimer = new SleepTimer();
                new Thread(sleepTimer).start();*/
                MasterKey.changeKey(myNew1.getText());


            } else {
                myPrompt.setText("");
                myPrompt.setTextFill(Color.RED);
                myPrompt.setText("The new password must be at least 8 characters! ");
            }


        } else {
            myPrompt.setText("");
            myPrompt.setTextFill(Color.RED);
            myPrompt.setText("The two words must match. ");

        }
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
