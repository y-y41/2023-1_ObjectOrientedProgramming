package lab12;

public class ProdCons {
    private Buffer buffer;
    private Producer[] producers;
    private Consumer[] consumers;

    public ProdCons() {
        buffer = new Buffer(5);
        producers = new Producer[]{new Producer(buffer), new Producer(buffer)};
        consumers = new Consumer[]{new Consumer(buffer), new Consumer(buffer)};
    }

    private class Producer extends Thread {
        private final Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void produce() throws InterruptedException {
            for (int i = 0; i < buffer.getSize(); i++) {
                buffer.add(Math.random() * 100); // Add a random number to buffer
            }
        }

        public void run() {
            try {
                produce(); // Call produce() method when thread starts
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Consumer extends Thread {
        private final Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void consume() throws InterruptedException {
            for (int i = buffer.getSize(); i>0; i--) {
                buffer.remove(); // Remove an item from the buffer
            }
        }

        public void run() {
            try {
                consume(); // Call consume() method when thread starts
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void startThread() {
        for (int i=0; i< producers.length; i++) {
            producers[i].start(); // Start the producer thread
            consumers[i].start(); // Start the consumer thread
        }
    }
}
