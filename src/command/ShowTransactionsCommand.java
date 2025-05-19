package command;

import model.Transaction;

public class ShowTransactionsCommand implements Command {
    private final TransactionRepository repository;

    public ShowTransactionsCommand(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        for (Transaction t : repository.getAll()) {
            System.out.println(t);
        }
    }

    @Override
    public String getName() {
        return "Show all transactions";
    }
}
