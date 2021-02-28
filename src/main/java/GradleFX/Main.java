package GradleFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) throws Exception {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception, InterruptedException {

        Thread.setDefaultUncaughtExceptionHandler(Main::showError);
        //Object a = null;
        //Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)  a );


        this.stage = stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();


    }

    public void setStage(boolean state) {
        if (!state) {
            stage.close();
        } else {
            this.stage = stage;
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("main.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);

            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
    }

    private static void showError(Thread t, Throwable e) {
        System.err.println("***Default exception handler***");
        if (Platform.isFxApplicationThread()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //System.exit(0);
            showErrorDialog(e);
        } else {
            System.err.println("An unexpected error occurred in " + t);

        }
    }

    private static void showErrorDialog(Throwable e) {
        StringWriter errorMsg = new StringWriter();
        e.printStackTrace(new PrintWriter(errorMsg));
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Error.fxml"));
        try {
            Parent root = loader.load();
            ((ErrorController) loader.getController()).setErrorText(errorMsg.toString());
            dialog.setScene(new Scene(root, 250, 400));
            dialog.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
