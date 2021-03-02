package GradleFX;

import java.io.IOException;


public class DeleteAccount {
    public static void delete(String accName) throws IOException {


        boolean bol = false;
        for (int i = 0; i < Catalogue.catalogue.size(); i++) {
            if (Catalogue.catalogue.get(i).getAccountNname().equals(accName)) {
                bol = true;


            }
        }


        if (bol) {

            ask(accName);

        }
        if (!bol) {

            System.out.println("<<< Account does not exist. Please check spelling and try again. >>>");
            DeleteAccountSceneController.prompt("Selected account called " + accName + " not found.");
        }

    }

    public static void ask(String accName) {
        DeleteAccountSceneController.prompt("Are you sure you want to delete this account: " + accName);
        DeleteAccountSceneController.myNo.setVisible(true);
        DeleteAccountSceneController.myYes.setVisible(true);
    }

    public static void deleteHere(String accName) throws Exception {
        SorterFirst sorterFirst = new SorterFirst();
        Sorter sorter = new Sorter();
        if (DeleteAccountSceneController.permission) {
            for (int i = 0; i < Catalogue.catalogue.size(); i++) {
                if (Catalogue.catalogue.get(i).getAccountNname().equals(accName)) {


                    Catalogue.catalogue.remove(i);
                    System.out.println();
                    System.out.println();
                    sorterFirst.sort();
                    sorter.sort();
                    WriteToFile.write(SceneController.mainKey,"m.games");
                    DeleteAccountSceneController.myNo.setVisible(false);
                    DeleteAccountSceneController.myYes.setVisible(false);
                    DeleteAccountSceneController.prompt("Selected account " + "'" + accName + "'" + " has been deleted.");
                    System.out.println();
                }
            }
        } else {
            DeleteAccountSceneController.myNo.setVisible(false);
            DeleteAccountSceneController.myYes.setVisible(false);
            DeleteAccountSceneController.prompt("Account called " + accName + " has NOT been deleted.");

        }
    }

}
