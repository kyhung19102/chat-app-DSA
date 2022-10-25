import java.io.IOException;
import java.util.Scanner;

import controller.Account;
import model.Message;
import repository.MessageRepository;
import service.AccountService;

public class App {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Set up Repository
        AccountService accountSV = new AccountService();
        // Set up Account
        Account accOne = new Account(accountSV);
        Account accTwo = new Account(accountSV);
        Account[] accounts = new Account[] { accOne, accTwo };

        // Executed Application
        while (true) {
            Account from = accounts[0];
            Account to = accounts[1];
            fillInforAccount(from, to);
            if (!isValidAccountName(from.getName(), to.getName())) {
                System.out.println("The account must have name!");
                System.out.println("Please register again!");
                System.out.println("Do you want to continue? (Y/N)");
                if (!sc.nextLine().equalsIgnoreCase("Y"))
                    break;
            } else {
                int choice = 0;
                while (true) {
                    choice = createMenu(choice);
                    if (choice == 0) {
                        System.out.println("Account logged out successfully!\n");
                        return;
                    }
                    process(choice, from, to);
                    // update after sending message
                    if (choice == 1) {
                        swapAccount(accounts);
                        from = accounts[0];
                        to = accounts[1];
                    }
                }
            }
        }

    }

    static void clearBuffer() {
        sc.nextLine();
    }

    static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    static void fillInforAccount(Account from, Account to) {
        System.out.print("Enter your name: ");
        String nameFrom = sc.nextLine();
        from.setName(nameFrom);
        System.out.print("Enter your name you want to send: ");
        String nameTo = sc.nextLine();
        to.setName(nameTo);
    }

    static int createMenu(int choice) {
        System.out.println(String.format("%9s", "---------------------------------------------"));
        System.out.println("1. Send message");
        System.out.println("2. Show all messages");
        System.out.println("3. Get messages");
        System.out.println("0. Exit");
        System.out.println(String.format("%9s", "---------------------------------------------"));
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        clearBuffer();

        return choice;
    }

    static boolean isValidAccountName(String from, String to) {
        return !from.equalsIgnoreCase("") &&
                !to.equalsIgnoreCase("");
    }

    static void process(int choice, Account from, Account to) {
        clearConsole();
        System.out.println(String.format("Username: [%s]", from.getName()));
        switch (choice) {
            case 1:
                while (true) {
                    System.out.println(String.format("[%s] enter the text you want to send to [%s]", from.getName(),
                            to.getName()));
                    String text = sc.nextLine();
                    if (text.length() > 250) {
                        System.out.println("*************************************************************");
                        System.out.println("*****The text must be less or equal than 250 characters!*****");
                        System.out.println("*************************************************************");
                    } else {
                        from.send(new Message(from.getName(), text, to.getName()));
                    }
                    System.out.println("Do you want to continue to type text ?(Y/N)");
                    String end = sc.nextLine();
                    if (!end.equalsIgnoreCase("Y")) {
                        clearConsole();
                        System.out.println(String.format("Switch send message to %s account.", to.getName()));
                        break;
                    }
                }
                break;

            case 2:
                System.out.println("----- Show all messages ------\n");
                from.showAllMessages();
                System.out.println();
                break;

            case 3:
                System.out.println("----- Show latest messages ------\n");
                from.showLatestMessage();
                System.out.println();
                break;

            default:
                System.out.println("This future is coming soon !\n");
                break;
        }
    }

    static void swapAccount(Account[] a) {
        final Account temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }
}
