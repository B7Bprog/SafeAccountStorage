package GradleFX;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class WriteToFile {

    public static String toWrite;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static void write(String key) throws Exception {
        File myFile = new File("m.games");
        FileWriter myWriter = new FileWriter(myFile);
        BufferedWriter myBuff = new BufferedWriter(myWriter);

        for (int i = 0; i < Catalogue.catalogue.size(); i++) {
            //System.out.println("Inside for in WriteToFile");
            //toWrite = (Encoder.encode(Catalogue.catalogue.get(i).toString()));

            System.out.println("This is cuttently in the Catalogue: " + Catalogue.catalogue.get(i).toString());

            toWrite = EncryptorAesGcmPassword.encrypt(Catalogue.catalogue.get(i).toString().getBytes(UTF_8), key);


            myBuff.write(toWrite + "\n");


        }
        myBuff.close();
        //NewPWSceneController.enableBackButton();
    }

    public static void clearFile() throws IOException {
        File myFile = new File("m.games");
        FileWriter myWriter = new FileWriter(myFile);
        BufferedWriter myBuff = new BufferedWriter(myWriter);
        myBuff.write("");
    }
}
