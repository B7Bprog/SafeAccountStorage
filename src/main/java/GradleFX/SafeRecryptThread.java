package GradleFX;

import javafx.concurrent.Task;

public class SafeRecryptThread extends Task {
    @Override
    protected Object call() throws Exception {
        ReCryptDatabase.recrypt();
        MasterKey.successfulResult = true;
        return null;
    }
}
