package Customer;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class CustomerFunctions {
    
    public void signUp(CustomerDatabase customerDatabase) {
        Customer customer = new Customer();
        System.out.println("Enter the new Login ID: ");
        customer.setLoginID(scanner.next());
        System.out.println("Set your new password: ");
        customer.setLoginPassword(scanner.next());
        System.out.println("Enter your name: ");
        customer.setNameOfuser(scanner.next());
        System.out.println("Enter your phone number: ");
        customer.setPhoneNumberOfUser(scanner.next());
        System.out.println("Enter 1: To become premium user \nEnter 2: To skip ");
        int option = scanner.nextInt();
        if (option == 1) {
            customer.setPremiumUser(true);
        } else {
            customer.setPremiumUser(false);
        }
        customerDatabase.getCustomerMap().put(customer.getLoginID(), new Customer(customer.getNameOfuser(), customer.getPhoneNumberOfUser(), customer.getLoginPassword(), customer.isPremiumUser()));
    }

    public void signIn(CustomerDatabase customerDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (customerDatabase.getCustomerMap().containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (customerDatabase.getCustomerMap().get(enteredID).getLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
            } else {
                System.out.println("Password is wrong");
            }
        }
    }
}
