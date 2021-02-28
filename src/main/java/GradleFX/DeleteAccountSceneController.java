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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteAccountSceneController implements Initializable {
    protected static String accountToDelete = "";
    protected static boolean permission = false;

    @FXML
    private TextField select;
    @FXML
    private Label prompt;
    @FXML
    private Button delete;
    @FXML
    private Button yes;
    @FXML
    private Button no;
    @FXML
    private Label time;
    @FXML
    private ProgressBar bar;


    private static TextField mySelect;
    private static Label myPrompt;
    private static Button myDelete;
    protected static Button myYes;
    protected static Button myNo;
    private static Label myTime;
    private static ProgressBar myBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mySelect = select;
        myPrompt = prompt;
        myDelete = delete;
        myYes = yes;
        myNo = no;
        myTime = time;
        myBar = bar;
        ActivatedWindows.isDeleteAccountSceneController = true;
    }

    public void setBar() {
        myBar.setProgress((double) SceneController.timercount / 241);
    }

    public void extendTime() {
        SceneController.timercount = 241;
    }

    public void setTimeLabel(String timeLeft) {
        myTime.setText(timeLeft);
    }

    public static void prompt(String text) {
        myPrompt.setText(text);

    }

    public void givePermission() throws Exception {
        SceneController.timercount = 241;
        permission = true;
        DeleteAccount.deleteHere(accountToDelete);
    }

    public void denyPermission() throws Exception {
        SceneController.timercount = 241;
        permission = false;
        DeleteAccount.deleteHere(accountToDelete);
    }


    public void delete() throws IOException {
        SceneController.timercount = 241;
        if (!mySelect.getText().equals("")) {
            accountToDelete = mySelect.getText();
            DeleteAccount.delete(accountToDelete);
        } else {
            prompt("Type account name.");
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
