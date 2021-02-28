package GradleFX;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteMainKey {
    public static String toWrite;

    public static void writeKey(String keyToWrite) throws Exception {


        File myFile = new File("mk.games");
        FileWriter myWriter = new FileWriter(myFile);
        BufferedWriter myBuff = new BufferedWriter(myWriter);
        toWrite = EncryptorAesGcmPassword.encrypt(keyToWrite.getBytes(StandardCharsets.UTF_8), keyToWrite);
        //toWrite = Salter.salt(toWrite);
        myBuff.write(toWrite);


        myBuff.close();
    }
}
