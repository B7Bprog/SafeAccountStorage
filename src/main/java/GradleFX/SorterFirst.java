package GradleFX;

import java.util.Comparator;

public class SorterFirst implements Comparator<Account> {
    public void sort() {


        Catalogue.catalogue.sort(this);

    }

    public int compare(Account o1, Account o2) {
        int back = 0;

        for (int i = 0; i < o1.getAccountNname().toString().length() && i < o2.getAccountNname().toString().length(); i++) {
            if ((o1.getAccountNname().toString().charAt(i) - o2.getAccountNname().toString().charAt(i)) != 0) {
                back = (o1.getAccountNname().toString().charAt(i) - o2.getAccountNname().toString().charAt(i));
            }

            // else return (o1.getAccountNname().toString().charAt(0) - o2.getAccountNname().toString().charAt(0));
        }
        return back;
    }
}
