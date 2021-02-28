package GradleFX;

import java.util.Comparator;

public class Sorter implements Comparator<Account> {


//Running new thread and calling 'sort' on Catalogue


    public void sort() {


        Catalogue.catalogue.sort(this);

    }

    //Comparing up to the second character of the brand

    public int compare(Account o1, Account o2) {

        //if ((o1.getAccountNname().toString().toLowerCase().charAt(0) - o2.getAccountNname().toString().toLowerCase().charAt(0)) == 0) {
        if (((o1.getAccountNname().toString().toLowerCase().charAt(0) - o2.getAccountNname().toString().toLowerCase().charAt(0)) == 0) && (o1.getAccountNname().length() > 1) && (o2.getAccountNname().length() > 1)) {
            return (o1.getAccountNname().toString().toLowerCase().charAt(1) - o2.getAccountNname().toString().toLowerCase().charAt(1));
        } else
            return (o1.getAccountNname().toString().toLowerCase().charAt(0) - o2.getAccountNname().toString().toLowerCase().charAt(0));
    }


}

