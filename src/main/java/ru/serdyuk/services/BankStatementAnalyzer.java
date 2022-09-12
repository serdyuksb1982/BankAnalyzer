package ru.serdyuk.services;

import ru.serdyuk.services.interfaces.BankStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/resources.csv";

    public void analyze(final BankStatementParser parser) throws IOException {
        final var path = Paths.get(RESOURCES);
        final var lines = Files.readAllLines(path);
        final var bankTransactions = parser.parseLinesFrom(lines);
        final var bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth( Month.JANUARY ));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is: " + bankStatementProcessor.calculateTotalForCategory("Royalities"));
        final var transactions = bankStatementProcessor.findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000);
        System.out.println("The filter " + transactions.toString());
    }
}
