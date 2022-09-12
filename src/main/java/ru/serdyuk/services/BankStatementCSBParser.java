package ru.serdyuk.services;

import ru.serdyuk.dao.BankTransaction;
import ru.serdyuk.services.interfaces.BankStatementParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSBParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseForm(String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_TIME);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        List<BankTransaction> list = new ArrayList<>();
        for (String line : lines) {
            BankTransaction bankTransaction = parseForm(line);
            list.add(bankTransaction);
        }
        return list;
    }
}
