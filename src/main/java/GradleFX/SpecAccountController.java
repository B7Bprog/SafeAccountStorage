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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SpecAccountController implements Initializable {

    private static String specAccountName = "";
    protected static boolean accExist = true;


    @FXML
    private Label allText;

    @FXML
    private Label detailList;

    @FXML
    private TextField specAccountField;

    @FXML
    private Label time;

    @FXML
    private ProgressBar bar;


    private static Label myTextLabel;
    private static TextField mySpecAccountField;
    private static Label myDetailList;
    private static Label myTime;
    private static ProgressBar myBar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myTextLabel = allText;
        mySpecAccountField = specAccountField;
        myDetailList = detailList;
        myTime = time;
        myBar = bar;

        ActivatedWindows.isSpecAccountController = true;

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


    public void setSpecAccountName() throws IOException, InterruptedException {
        SceneController.timercount = 241;

        //resetText();

        specAccountName = mySpecAccountField.getText();
        PrintCatalogue.printSpecificAccount(specAccountName);

        if (accExist) {
            System.out.println("Just before set Text to zero");
            String text = PrintCatalogue.accountDetails;
            mySpecAccountField.setText("");
            myDetailList.setText("");

            myDetailList.setText(text);
        } else {
            myDetailList.setText("");
            myDetailList.setText("The specified account does not exist.");

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
