package lab13;

// Observer implementation for displaying the generated number as a '*'
public class GraphObserver implements Observer {
    private NumberGenerator num;
    public GraphObserver(NumberGenerator num) {
        this.num = num;
        num.addObserver(this);
    }
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver: ");
        for(int i = 0; i < generator.getNumber(); i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100); // thread delay for 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
