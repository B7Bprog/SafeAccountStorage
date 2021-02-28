package GradleFX;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;


public class Timer extends Task {
    //static boolean notCalled = true;
    private ActionEvent actionEvent;

    @Override
    protected Integer call() throws Exception {
        //boolean notCalled = true;

        while (SceneController.timercount > 0) {
            SceneController sceneController = new SceneController();
            AccountListController accountListController = new AccountListController();
            MenuSceneController menuSceneController = new MenuSceneController();
            SpecAccountController specAccountController = new SpecAccountController();
            AddAccountSceneController addAccountSceneController = new AddAccountSceneController();
            DeleteAccountSceneController deleteAccountSceneController = new DeleteAccountSceneController();
            NewPWSceneController newPWSceneController = new NewPWSceneController();
            PopupSceneController popupSceneController = new PopupSceneController();
            //System.out.println(SceneController.timercount);
            Thread.sleep(1000);


            //Show time left
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {

                        sceneController.setBar();

                    } finally {

                    }
                }
            });


            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        //FX Stuff done here
                        sceneController.setTimeLabel(Integer.toString(SceneController.timercount));

                        if (ActivatedWindows.isAccountListController) {
                            accountListController.setTimeLabel(Integer.toString(SceneController.timercount));
                            accountListController.setBar();
                        }
                        if (ActivatedWindows.isMenuActivated) {
                            menuSceneController.setTimeLabel(Integer.toString(SceneController.timercount));
                            menuSceneController.setBar();
                        }
                        if (ActivatedWindows.isSpecAccountController) {
                            specAccountController.setTimeLabel(Integer.toString(SceneController.timercount));
                            specAccountController.setBar();
                        }
                        if (ActivatedWindows.isAddAccountSceneController) {
                            addAccountSceneController.setTimeLabel(Integer.toString(SceneController.timercount));
                            addAccountSceneController.setBar();
                        }
                        if (ActivatedWindows.isDeleteAccountSceneController) {
                            deleteAccountSceneController.setTimeLabel(Integer.toString(SceneController.timercount));
                            deleteAccountSceneController.setBar();
                        }
                        if (ActivatedWindows.isNewPWSceneController) {
                            newPWSceneController.setTimeLabel(Integer.toString(SceneController.timercount));
                            newPWSceneController.setBar();
                        }
                        if (ActivatedWindows.isPopup) {
                            popupSceneController.setTimeLabel(Integer.toString(SceneController.timercount));
                            popupSceneController.setBar();
                        }


                    } finally {

                    }
                }
            });


            SceneController.timercount--;


            if (SceneController.timercount == 60) {


                if (PopupSceneController.notCalled) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                PopupSceneController popupSceneController = new PopupSceneController();
                                //FX Stuff done here
                                sceneController.popup();
                                ActivatedWindows.isPopup = true;
                                popupSceneController.setTimeLabel(Integer.toString(SceneController.timercount));

                            } finally {

                            }
                        }
                    });

                    PopupSceneController.notCalled = false;
                }


            }


        }
        System.exit(0);

        return null;
    }


    public void setOnFinished(Object o) {

    }
}
