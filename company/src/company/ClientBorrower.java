package company;

import java.util.Random;

/**
 * Created by Sergey on 14.12.2015.
 */
public class ClientBorrower implements Runnable {
    private final Bank bank;

    public ClientBorrower(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        Random random = new Random();
        long requiredMoneyAmount = random.nextInt(6000) + 500;
        System.out.println("Required money is " + requiredMoneyAmount);

        BankResponse response = bank.requestLoan(new BankRequest(requiredMoneyAmount, true));
        System.out.println(response);

        if(response.isRejected()) {
            throw new RuntimeException("Loan request has been rejected");
        }

        for(int i = 0; i < response.getNumberOfMonths(); i++) {
            BankResponse rsp = bank.payMonthLoanFee(
                    new BankRequest(response.getMonthPaymentAmount(), true));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("We are FREEE!!!!");
    }


}