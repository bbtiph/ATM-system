package kz.iitu.lw1;

import java.util.Scanner;

public class ATM implements BankService{

    @Override
    public void CheckBalance(Account account) {
        System.out.println("In your account at the moment: " + account.getBalance() +"kzt");
    }

    @Override
    public void WithDraw(Account account) {
        System.out.print("How much do you want to withdraw: ");
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        account.setBalance(account.getBalance() - sum);
        System.out.println("In your account at the moment: " + account.getBalance() +"kzt");
    }

    @Override
    public void TopUp(Account account) {
        System.out.println("top uping...");
        System.out.print("How much do you want to top up: ");
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        account.setBalance(account.getBalance() + sum);
        System.out.println("In your account at the moment: " + account.getBalance() +"kzt");
    }
}
