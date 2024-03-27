package lab13;

import java.util.ArrayList;

public abstract class NumberGenerator {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public abstract int getNumber(); // Abstract method to get the generated number
    public abstract void execute(); // Abstract method to execute the number generation

    public void addObserver(Observer observer) {
        observers.add(observer); // Add observer to the list
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer); // Remove observer from the list
    }

    public void notifyObserver() {
        for(int i=0; i<observers.size(); i++) {
            observers.get(i).update(this); // Notify all observers by calling update method
        }
    }
}
