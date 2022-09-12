package ru.serdyuk.services;

import ru.serdyuk.dao.BankTransaction;
import ru.serdyuk.services.interfaces.BankTransactionFilter;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bank : bankTransactions) total += bank.getAmount();
        return total;
    }

    public double calculateTotalInMonth(final Month month ) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth().equals(month)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions)
            if (bankTransaction.getDescription().equals(category)) total += bankTransaction.getAmount();
        return total;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction b : bankTransactions) {
            if (bankTransactionFilter.test(b)) {
                result.add(b);
            }
        }
        return result;
    }


}
