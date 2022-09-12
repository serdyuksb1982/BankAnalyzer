package ru.serdyuk.services.interfaces;

import ru.serdyuk.dao.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
   boolean test(BankTransaction bankTransaction);
}
