package company;

/**
 * Created by Sergey on 14.12.2015.
 */
public class BankResponse {
    private final long amount;
    private final long monthPaymentAmount;

    public long getAmount() {
        return amount;
    }

    public long getMonthPaymentAmount() {
        return monthPaymentAmount;
    }

    public boolean isRejected() {
        return rejected;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    private final boolean rejected;
    private final int numberOfMonths;

    public BankResponse(long amount, int numberOfMonths, long monthPaymentAmount, boolean rejected) {
        this.amount = amount;
        this.numberOfMonths = numberOfMonths;
        this.monthPaymentAmount = monthPaymentAmount;
        this.rejected = rejected;
    }
}
