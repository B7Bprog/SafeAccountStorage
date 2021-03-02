package GradleFX;

public class Account {
    private String accountName;
    private String userName;
    private String passWord;
    private String notes;

    public Account() {

    }

    public Account(String accountName, String userName, String passWord, String notes) {
        this.accountName = accountName;
        this.userName = userName;
        this.passWord = passWord;
        this.notes = notes;
    }
    public Account(String accountName, String userName, String passWord) {
        this.accountName = accountName;
        this.userName = userName;
        this.passWord = passWord;

    }

    public String getAccountNname() {
        return accountName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setNotes(String notes){this.notes = notes;}

    public String getNotes(){return notes;}

    public String toString() {
        //Here using the speacial Unicode UTF8 character: Œ and it's code is: U+008C or encoded byte: c28c
        return getAccountNname() + "Œ" + getUserName() + "Œ" + getPassWord() + "Œ" + getNotes();
    }

    public String toString2() {
        return "********************************************************************" + "\n" + "Account name: " + getAccountNname() + "\n" + "Username: " + getUserName() + "\n" + "Password: " + getPassWord() + "\n" + "Notes: " + getNotes() + "\n" + "********************************************************************" + "\n";
    }

    public String toString3() {
        return "Account: " + getAccountNname();
    }


}
