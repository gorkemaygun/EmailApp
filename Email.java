package EmailApp;

import java.util.*;

public class Email {
    private String firstName, lastName, password, department, alternateEmail, email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = randomPassword(defaultPasswordLength);
        this.department = setDepartment();
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "company.com";

    }

    private String setDepartment() {
        System.out.println(
                "DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0for none\nEnter department code: ");
        Scanner scan = new Scanner(System.in);
        int departName = scan.nextInt();
        if (departName == 1) {
            return "sales";
        } else if (departName == 2) {
            return "dev";
        } else if (departName == 3) {
            return "acct";
        } else {
            return " ";
        }
    }

    private String randomPassword(int length) {
        String passswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?=+";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passswordSet.length());
            password[i] = passswordSet.charAt(rand);
        }
        return new String(password);
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String ShowInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" + "COMPANY EMAIL: " + email + "\n"
                + "MAILBOX CAPACITY: " + mailboxCapacity + " mb\n" + "PASSWORD: " + password + "\nDEPARTMENT: "
                + department;
    }

}