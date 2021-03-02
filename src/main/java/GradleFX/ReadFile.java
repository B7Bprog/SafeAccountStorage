package GradleFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    private static String[] splitWords;

    public static void load() throws Exception {

        EncryptorAesGcmPassword encryptorAesGcmPassword = new EncryptorAesGcmPassword();

        Scanner scanner = null;
        try {

            scanner = new Scanner(new File("m.games"));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println();
            System.out.println("Locker database does not exist.");
            Thread.sleep(5000);
            System.exit(0);
        }
        String oneLine;
        do {

            oneLine = encryptorAesGcmPassword.myDecrypt(scanner.nextLine());


            System.out.println("This is oneLine from file: " + oneLine);

            //Here using the speacial Unicode UTF8 character: Œ and it's code is: U+008C or encoded byte: c28c
            splitWords = oneLine.split("Œ");

            Account account;
            System.out.println("This is length of splitwords: " + splitWords.length );

            if (splitWords.length == 4) {

                if(splitWords[3].equals("null")){
                    account = new Account(splitWords[0], splitWords[1], splitWords[2], "(No notes.)");
                }else {

                    System.out.println("In splitwords length 4");
                    account = new Account(splitWords[0], splitWords[1], splitWords[2], splitWords[3]);
                }
            }
            else {
                System.out.println("In splitwords length 3");
                account = new Account(splitWords[0], splitWords[1], splitWords[2], "(No notes.)");
        }
            Catalogue.catalogue.add(account);

        } while (scanner.hasNextLine());


    }
}
