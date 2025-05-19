package observer;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionNotifier implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer o : observers) {
            o.update(transaction);
        }
    }
}
