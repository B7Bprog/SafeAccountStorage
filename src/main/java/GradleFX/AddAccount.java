package GradleFX;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AddAccount {
    public static boolean checkExisting(String accName) {
        boolean condition = false;
        for (int i = 0; i < Catalogue.catalogue.size(); i++) {
            if (Catalogue.catalogue.get(i).getAccountNname().equals(accName)) {

                condition = true;

            }
        }

        return condition;
    }

    public static void add() throws Exception {
        SorterFirst sorterFirst = new SorterFirst();
        Sorter sorter = new Sorter();


        Account account = new Account();


        if ((AddAccountSceneController.newAccountName.equals("")) || (AddAccountSceneController.newUsername.equals("")) || (AddAccountSceneController.newAccountPW.equals(""))) {
            AddAccountSceneController.emptyName();
        } else {
            if (AddAccountSceneController.newAccountName.length() > 70 || AddAccountSceneController.newUsername.length() > 70 || AddAccountSceneController.newAccountPW.length() > 70 || AddAccountSceneController.newNotes.length() > 500) {
                AddAccountSceneController.tooLongNames();
            } else {
                if (checkExisting(AddAccountSceneController.newAccountName)) {
                    System.out.println();
                    AddAccountSceneController.accExxists();
                    System.out.println("<<< This account name already exists. Please choose an other one. >>>");
                    System.out.println();
                    //add();
                } else {
                    account.setAccountName(AddAccountSceneController.newAccountName);
                    System.out.print("Type user name: ");
                    account.setUserName(AddAccountSceneController.newUsername);
                    System.out.print("Type password: ");
                    account.setPassWord(AddAccountSceneController.newAccountPW);

                    //AddAccountSceneController.newNotes.equals("null") ||

                    if (AddAccountSceneController.newNotes.equals("")) {
                        account.setNotes("No notes.");
                    } else {
                        account.setNotes(AddAccountSceneController.newNotes);
                    }

                    Catalogue.catalogue.add(account);
                    System.out.println();
                    sorterFirst.sort();
                    sorter.sort();
                    WriteToFile.write(SceneController.mainKey);
                    AddAccountSceneController.success();
                    System.out.println("<<< New account " + account.getAccountNname() + " has been added successfully. >>>");
                }
            }
        }
    }
}
