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
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuSceneController implements Initializable {

    @FXML
    private Button viewSpecific;

    @FXML
    private Label time;

    @FXML
    private ProgressBar bar;


    public MenuSceneController() {

    }

    private static Button myViewSpecific;
    private static Label myTime;
    private static ProgressBar myBar;

    public static Stage stage2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myTime = time;


        myViewSpecific = viewSpecific;

        myBar = bar;

        ActivatedWindows.isMenuActivated = true;
    }

    public void setBar(){
        myBar.setProgress((double)SceneController.timercount/241);
    }

    public void removeFirstScene() {



        Main.stage.close();
    }

    public void exit() {
        System.exit(0);
    }

    public void changeScreen(ActionEvent event) throws IOException, InterruptedException {

        SceneController.timercount = 241;

        if (MasterKey.isRightKey) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("accountList.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            AccountListController.writeToTextArea();
            window.show();


        }

    }

    public void extendTime(){
        SceneController.timercount=241;
    }

    public void setTimeLabel(String timeLeft){
        myTime.setText(timeLeft);
    }

    public void changeToSpecAccount(ActionEvent event) throws IOException, InterruptedException {
        SceneController.timercount = 241;
        if (MasterKey.isRightKey) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("specAccount.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            System.out.println("changeToSpecAccount went great");


        }

    }

    public void changeToAddAccount(ActionEvent event) throws IOException, InterruptedException {
        SceneController.timercount = 241;
        if (MasterKey.isRightKey) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("addAccount.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();


        }

    }

    public void changeToDeleteAccountSceneController(ActionEvent event) throws IOException, InterruptedException {
        SceneController.timercount = 241;
        if (MasterKey.isRightKey) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("deleteAccount.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();


        }

    }

    public void changeToNewPWSceneController(ActionEvent event) throws IOException, InterruptedException {

        SceneController.timercount = 241;
        if (MasterKey.isRightKey) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("changeMainKey.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();


        }

    }


}
