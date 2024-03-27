package lab12;

public class Buffer {
    private int loc = 0;
    private double[] data;

    public Buffer(int size) {
        data = new double[size];
    }

    public int getSize() {
        return data.length;
    }

    // Add an item to buffer
    synchronized void add(double toAdd) throws InterruptedException {
        while (loc >= data.length) {
            System.out.println("Buffer is full");
            wait(); // Wait until the buffer is not full
        }
        System.out.println("Adding item on " + loc + ": " + toAdd);
        data[loc++] = toAdd;
        notifyAll(); // Notify waiting threads that an item has been added
    }

    // Remove an item from buffer
    synchronized double remove() throws InterruptedException {
        while (loc <= 0) {
            System.out.println("Buffer is empty");
            wait(); // Wait until the buffer is not empty
        }
        double temp = data[--loc];
        System.out.println("Removing item on "+loc+": "+temp);
        data[loc] = 0.0; // Set the removed location to 0.0
        notifyAll(); // Notify waiting threads that an item has been removed
        return temp;
    }
}
