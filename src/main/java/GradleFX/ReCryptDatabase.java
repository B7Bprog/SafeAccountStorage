package GradleFX;

public class ReCryptDatabase {
    public static void recrypt() throws Exception {
        //ReadFile.load();
        WriteToFile.write(NewPWSceneController.myNew1.getText(),"temp.games");
        WriteToFile.clearFile("m.games");
        WriteToFile.write(NewPWSceneController.myNew1.getText(),"m.games");
        WriteToFile.clearFile("temp.games");

    }
}
