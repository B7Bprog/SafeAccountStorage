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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountListController implements Initializable {

    @FXML
    private Label allText;

    private static Label myTextLabel;

    @FXML
    private Label time;

    @FXML
    private ProgressBar bar;

    private static Label myTime;
    private static ProgressBar myBar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myTextLabel = allText;
        myTime = time;
        ActivatedWindows.isAccountListController = true;
        myBar = bar;

    }

    public void setBar(){
        myBar.setProgress((double)SceneController.timercount/241);
    }

    public static void writeToTextArea() {
        SorterFirst sorterFirst = new SorterFirst();
        Sorter sorter = new Sorter();
        sorterFirst.sort();
        sorter.sort();


        PrintCatalogue.printAccountNames();
        myTextLabel.setText(PrintCatalogue.accountNames);
    }

    public void setTimeLabel(String timeLeft){
        myTime.setText(timeLeft);
    }

    public void extendTime(){
        SceneController.timercount=241;
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
