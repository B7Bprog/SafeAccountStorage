package GradleFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ReadFile2 {
    private static String[] splitWords;

    public static String load(String filename) throws InterruptedException, UnsupportedEncodingException {

        Scanner scanner = null;
        try {

            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println();
            System.out.println("File does not exist.");
            Thread.sleep(5000);
            System.exit(0);
        }
        String oneLine;
        do {

            oneLine = scanner.nextLine();


        } while (scanner.hasNextLine());
        //System.out.println("This is text from file: " + oneLine);

        return oneLine;
    }
}
