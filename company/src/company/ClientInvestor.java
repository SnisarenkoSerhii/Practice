package company;

import java.util.Random;

/**
 * Created by Sergey on 14.12.2015.
 */
 public class ClientInvestor implements Runnable {
    private final Bank bank;

    public ClientInvestor(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        Random random = new Random();
        long requiredMoneyAmount = random.nextInt(15000) + 500;
        System.out.println("Required money is " + requiredMoneyAmount);

        BankResponse response = bank.openDeposit(new BankRequest(requiredMoneyAmount, false));
        System.out.println(response);

        try {
            Thread.sleep(1000 * response.getNumberOfMonths());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response = bank.closeDeposit(new BankRequest(response.getAmount(), false));
        System.out.println(response);
    }
}
