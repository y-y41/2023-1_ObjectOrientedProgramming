package lab09;

public class Wallet {
    private String name;
    private int balance;
    private int txIndex;

    public Wallet(String name) {
        this.name = name;
        this.balance = 100;
        this.txIndex = 0;
    }

    public int getBalance() {
        return this.balance;
    }

    public void increaseIndex() {
        txIndex += 1;
    }

    public void decreaseBalance(int expense) {
        balance -= expense;
    }

    public String toString() {
        return "name: " + this.name + ", #" + this.txIndex + ", balance: " + this.balance;
    }

    public void empty() throws Exception {
        if (this.balance <= 0) {
            throw new Exception("Go Home");
        }
    }
}