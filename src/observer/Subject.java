package observer;

import model.Transaction;

public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(Transaction transaction);
}
