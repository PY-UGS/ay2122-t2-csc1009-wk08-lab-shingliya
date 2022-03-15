import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemoTest {
    public static void main (String[] arg)
    {
        CheckingAccount acc = null;
        Scanner s = new Scanner(System.in);
        boolean flag = true;

        do{
            System.out.print("Enter a number for ur account: ");
            try {
                int in = s.nextInt();
                if(in <= 0)
                    throw new IllegalArgumentException();
                acc = new CheckingAccount(in);
                }catch (InputMismatchException e) {
                    System.out.println("Only digits allowed!\n");
                    s.nextLine();
                }catch (IllegalArgumentException e) {
                    System.out.println("Number should be larger then 0!\n");
                }
            }
            while (acc == null);

        while(flag)
        {
            System.out.print("Welcome, " + acc.getNumber() + ", how can you help me?\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n>:");

            try {
                int choice = s.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.print("How much to deposit\n>:");
                        acc.deposit(s.nextDouble());
                        break;
                    case 2:
                        System.out.print("How much to withdraw\n>:");
                        acc.withdraw(s.nextDouble());
                        System.out.println("The balance after withdraw is: $" + acc.getBalance() + "\n");
                        break;
                    case 3:
                        System.out.println("Current balance is: $" + acc.getBalance() + "\n");
                        break;
                    case 4:
                        System.out.println("Goodbye World\n");
                        flag = false;
                        break;
                    default:
                        throw new InputMismatchException();
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input!\n");
                s.nextLine();
            }catch (IllegalArgumentException e) {
                System.out.println("Amount should be larger then 0!\n");
            }catch (InsufficientFundsException e) {
                System.out.println("Sorry, but your account is short by: $" + e.getAmount() + "\n");
            }
        }
    }
}
