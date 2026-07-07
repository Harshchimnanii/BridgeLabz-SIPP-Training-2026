class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATM {

    static void withdraw(int balance, int amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Withdrawal Failed!\nAvailable Balance = ₹"
                            + balance +
                            "\nRequested Amount = ₹" + amount);
        }

        System.out.println("Withdrawal Successful.");
        System.out.println("Remaining Balance = ₹" + (balance - amount));
    }

    public static void main(String[] args) {

        try {

            withdraw(5000, 8000);

        }
        catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        }

    }
}