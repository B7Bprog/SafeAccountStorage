package GradleFX;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;


public class PopupSceneController implements Initializable {


    @FXML
    private Label time;
    @FXML
    private ProgressBar bar;

    static boolean notCalled = true;
    private static Label myTime;
    private static ProgressBar myBar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myTime = time;
        myBar = bar;
    }

    public void setBar() {
        myBar.setProgress((double) SceneController.timercount / 241);
    }

    public void setTimeLabel(String timeLeft) {


        myTime.setText(timeLeft);
    }

    public void ok() {
        SceneController.timercount = 241;
        notCalled = true;
        closePopup();
    }

    public void exit() {
        System.exit(0);
    }

    public void closePopup() {
        //Stage stage = (Stage) AnchorPane.getScene().getWindow();
        // do what you have to do
        //stage.close();
        //Platform.exit();
        SceneController.dialogStage.close();
        /*Scene scene = null;
        SceneController.dialogStage.setScene(scene);*/


    }


}
