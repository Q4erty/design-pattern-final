package observer;

import model.Transaction;

public interface Observer {
    void update(Transaction transaction);
}