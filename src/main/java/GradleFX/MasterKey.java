package GradleFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class MasterKey {

    // public static boolean jobDone = false;
    static int numOfTryLeft;
    static boolean isRightKey = false;


    public void requestKey(String mainKeyIn) throws IOException, InterruptedException {


        //default key:gom....5


        if (mainKeyIn.equals("")) {
            SceneController.noKeyEnteredNote();
        }
        if (compareKey(mainKeyIn)) {
            //WriteWrongKey.writeWrongKey("1559");
            isRightKey = true;


            try {
                ReadFile.load();
            } catch (Exception e) {
                //System.out.println(e);
            }


        } else if (!mainKeyIn.equals("")) {
            //wrongKey();
            SceneController.wrongKey();


        }

    }

    public static boolean compareKey(String keyIn) throws FileNotFoundException {
        System.out.println("In compareKey");

        if (keyIn.equals(readKey("mk.games"))) {
            return true;
        }
        return false;
    }

    public static void changeKey(String key) throws Exception {


        System.out.print("Type current Main Locker Key first: ");

        System.out.println();


        System.out.print("New key must be at least 8 characters. Type new Key here: ");


        System.out.println();

        WriteMainKey.writeKey(key);
        ReCryptDatabase.recrypt();

        NewPWSceneController.disablemyCreateButton();
        NewPWSceneController.prompt("Main Key has been changed successfully.");
        /*do {
            if (jobDone) {
                NewPWSceneController.enableBackButton();
                jobDone = false;
            }
        }while(jobDone);*/


    }


    public static String readKey(String filename) throws FileNotFoundException {


        String toReturn = "test";
        try {
            toReturn = EncryptorAesGcmPassword.getDecodedText("mk.games");
        } catch (Exception e) {
            System.out.println("Wrong password");
        }
        System.out.println("This is decoded main key: " + toReturn);
        return toReturn;
    }
}
