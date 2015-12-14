package company;

/**
 * Created by Sergey on 14.12.2015.
 */
public class BankRequest {
    private final long amount;
    private final boolean isLoan;

    public BankRequest(long requiredAmount, boolean isLoan) {
        this.amount = requiredAmount;
        this.isLoan =isLoan;
    }

    public long getAmount() {
        return amount;
    }

    public boolean isLoan() {
        return isLoan;
    }



}
