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
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//This must be replaces to javaFX import: import java.awt.event.ActionEvent;

public class SceneController implements Initializable {


    static Stage dialogStage = new Stage();

    public static String password = "";
    protected static int timercount = 241;
    protected static String mainKey = "";


    @FXML
    private Button Enter;

    @FXML
    private Button Exit;


    @FXML
    private Label bottomLabel;

    @FXML
    private Label loading;

    @FXML
    private PasswordField PWField;
    @FXML
    private Label showPWLabel;

    @FXML
    private Label time;

    @FXML
    private Button extend;

    @FXML
    private ProgressBar bar;

    protected static Label myBottomLabel;
    private static PasswordField myPWField;
    private static Label myShowPWLabel;
    private static Button myButton;
    private static Button myExit;
    private static Label myLoading;
    private static Button myExtend;
    private static Label myTime;
    private static ProgressBar myBar;


    private static int tries;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Timer timerTask = new Timer();
        LoadingTimer loadingTimer = new LoadingTimer();
        new Thread(loadingTimer).start();
        //TimerForWrongPassword timerForWrongPassword = new TimerForWrongPassword();

        myBottomLabel = bottomLabel;
        myPWField = PWField;
        myShowPWLabel = showPWLabel;
        myButton = Enter;
        myExit = Exit;
        myLoading = loading;
        myExtend = extend;
        myTime = time;
        myBar = bar;


        dialogStage.initStyle(StageStyle.UNDECORATED);
        myPWField.setDisable(true);
        myPWField.setVisible(false);

        new Thread(timerTask).start();
        //new Thread(timerForWrongPassword).start();


    }

    /***********************************************************************
     /*This method runs if button is pressed in main application,
     but can't make it work by calling it from Timer Class */


    public void extendTime(){
        timercount=241;
    }

    public void setTimeLabel(String timeLeft){
        myTime.setText(timeLeft);
    }

    public void setBar(){
        myBar.setProgress((double)timercount/241);
    }

    public void popup() {

        //Stage dialogStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("popup.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        //dialogStage.initStyle(StageStyle.UNDECORATED);

        dialogStage.setScene(new Scene(root));
        dialogStage.setResizable(false);

        dialogStage.show();
    }


    //**************************************************************************
    public void showPW() {
        timercount = 241;
        myShowPWLabel.setText(myPWField.getText());
    }

    public void hidePW() {
        myShowPWLabel.setText("");
    }

    public void exit() {
        System.exit(0);
    }


    public static void setLabel() throws InterruptedException {
        myBottomLabel.setText("");
        myBottomLabel.setText("Database has been permanently erased.");

    }

    public static void enablePWField() {
        myPWField.setVisible(true);
        myPWField.setDisable(false);
    }

    public static void setWrongKeyLabel() throws InterruptedException {
        myBottomLabel.setTextFill(Color.RED);
        myBottomLabel.setText("Wrong password has been entered! \n Wait 20 seconds to try again!");
        TimerForWrongPassword timerForWrongPassword = new TimerForWrongPassword();
        new Thread(timerForWrongPassword).start();

    }

    public static void noKeyEnteredNote() {
        myBottomLabel.setTextFill(Color.BLACK);
        myBottomLabel.setText("No key entered. Type Main Key.");
    }


    public static void wrongKey() throws InterruptedException {
        tries = MasterKey.numOfTryLeft;
        if (tries > 0) {
            myBottomLabel.setTextFill(Color.RED);
            myBottomLabel.setText("!!!Wrong key!!! You've got " + tries + " tries left!");

        }
    }

    public static void disableEnterButton() {
        myButton.setVisible(false);
    }

    public static void enableEnterButton() {
        myButton.setVisible(true);
    }

    public static void disableExitButton() {
        myExit.setVisible(false);
    }

    public static void enableExitButton() {
        myExit.setVisible(true);
    }

    public static void disableLoadingLabel() {
        myLoading.setVisible(false);
        myLoading.setDisable(true);
    }


    public void getMainKey() throws IOException, InterruptedException {
        timercount = 241;
        MasterKey masterKey = new MasterKey();
        System.out.println("Inside SceneController");

        mainKey = myPWField.getText();

        masterKey.requestKey(mainKey);


    }

    public void changeScreen(ActionEvent event) throws IOException, InterruptedException {

        timercount = 241;
        getMainKey();
        System.out.println("This is mainkey" + mainKey);
        //Thread.sleep(1000);
        if (MasterKey.isRightKey) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
    }


}


//id.getchildren().remove(0)