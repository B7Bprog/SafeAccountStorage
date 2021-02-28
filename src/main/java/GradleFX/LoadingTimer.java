package GradleFX;

import javafx.application.Platform;
import javafx.concurrent.Task;

public class LoadingTimer extends Task {

    @Override
    protected Object call() throws Exception {
        Thread.sleep(5000);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {

                    SceneController.disableLoadingLabel();
                    SceneController.enablePWField();


                } finally {

                }
            }
        });
        return null;
    }
}
