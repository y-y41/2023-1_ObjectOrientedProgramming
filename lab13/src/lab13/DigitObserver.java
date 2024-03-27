package lab13;

// Observer implementation for displaying the generated number as a digit
public class DigitObserver implements Observer {
    private NumberGenerator num;

    public DigitObserver(NumberGenerator num) {
        this.num = num;
        num.addObserver(this);
    }

    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNumber());
        try {
            Thread.sleep(100); // thread delay for 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

