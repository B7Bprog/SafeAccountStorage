package GradleFX;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class TimerForWrongPassword extends Task {

    @Override
    protected Object call() throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {

                    SceneController.disableEnterButton();
                    SceneController.disableExitButton();


                } finally {

                }
            }
        });

        Thread.sleep(20000);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //FX Stuff done here
                    SceneController.enableEnterButton();
                    SceneController.enableExitButton();


                } finally {

                }
            }
        });
        return null;
    }
}
