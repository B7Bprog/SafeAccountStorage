package GradleFX;


import java.io.IOException;

public class PrintCatalogue {
    public static String accountNames = "";
    public static String accountDetails = "";

    public static void printAccountNames() {
        accountNames = "";

        System.out.println();
        System.out.println("------------------------------------");
        for (int i = 0; i < Catalogue.catalogue.size(); i++) {
            accountNames += (Catalogue.catalogue.get(i).toString3()) + "\n";
        }
        System.out.println("------------------------------------");
    }

    public static void printSpecificAccount(String accName) throws IOException, InterruptedException {
        accountDetails = "";

        boolean bol = false;
        for (int i = 0; i < Catalogue.catalogue.size(); i++) {
            if (Catalogue.catalogue.get(i).getAccountNname().equals(accName)) {

                SpecAccountController.accExist = true;

                bol = true;

                accountDetails += (Catalogue.catalogue.get(i).toString2() + "\n");


            }


        }
        if (bol) {

        }
        if (!bol) {

            SpecAccountController.accExist = false;
        }

    }
}
