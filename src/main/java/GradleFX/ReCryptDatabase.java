package GradleFX;

public class ReCryptDatabase {
    public static void recrypt() throws Exception {
        //ReadFile.load();
        WriteToFile.clearFile();
        WriteToFile.write(NewPWSceneController.myNew1.getText());

    }
}
