package company;

import java.util.Random;

/**
 * Created by Sergey on 14.12.2015.
 */
public class Bank {
    //AtomicLong
    private long capital;

    public Bank(long capital) {
        this.capital = capital;
    }

    public synchronized BankResponse openDeposit(BankRequest bankRequest) {
        //check if request is not loan
        if(bankRequest.getAmount() < 1000) {
            throw new RuntimeException("Amount of money is not enough");
            //new BankResponse(0, 0, 0, true);
        }
        capital += bankRequest.getAmount();

        Random random = new Random();
        int periodInMonths = random.nextInt(12) + 1;
        int percentPerMonth = random.nextInt(3) + 1;
        long totalAmount = bankRequest.getAmount()
                + bankRequest.getAmount()* periodInMonths * percentPerMonth / 100;
        return new BankResponse(totalAmount, periodInMonths, percentPerMonth, false);
    }

    public synchronized BankResponse closeDeposit(BankRequest bankRequest) {
        //check if we can pay such amount of money
        capital -= bankRequest.getAmount();
        return new BankResponse(bankRequest.getAmount(), 0, 0, false);
    }

    public synchronized BankResponse requestLoan(BankRequest bankRequest){
        //check if request is loan
        if(this.capital <= bankRequest.getAmount()) {
            System.out.println("Bank does not have such amount of money");
            return new BankResponse(0, 0, 0, true);
        }

        capital -= bankRequest.getAmount();

        Random random = new Random();
        int periodInMonths = random.nextInt(12) + 1;
        long amountPerMonth = bankRequest.getAmount()
                * (random.nextInt(6) + 1)
                / 100;

        return new BankResponse(bankRequest.getAmount(), periodInMonths, amountPerMonth, false);
    }

    public synchronized BankResponse payMonthLoanFee(BankRequest bankRequest) {
        //check if bankRequest.getAmount() is greater than 0
        capital += bankRequest.getAmount();
        return new BankResponse(bankRequest.getAmount(), 0, 0, false);
    }
}
