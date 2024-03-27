package lab09;

import java.util.Scanner;

public class Market {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("my wallet");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                wallet.empty();

                System.out.print("Enter price: ");
                int price = scanner.nextInt();
                scanner.nextLine();

                if (price < 0) {
                    throw new NegativeException();
                } else if (price > 100) {
                    throw new TooMuchExpenseException(price);
                } else if (price > wallet.getBalance()) {
                    throw new TooMuchExpenseException();
                } else {
                    wallet.increaseIndex();
                    wallet.decreaseBalance(price);
                }
            } catch (NegativeException e) {
                System.out.println(e);
            } catch (TooMuchExpenseException e) {
                System.out.println(e);
                if (e.getMessage().equals("Over the limit!"))
                    System.out.println("you pay " + e.getInputNum());
            } catch (Exception e) {
                System.out.println(e);
                return;
            } finally {
                System.out.println(wallet);
                System.out.println("---transaction complete---\n");
            }
        }
    }
}