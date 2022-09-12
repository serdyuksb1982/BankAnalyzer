package ru.serdyuk.services.interfaces;

import ru.serdyuk.dao.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseForm(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
