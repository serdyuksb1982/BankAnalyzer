package ru.serdyuk.services;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;


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
    }
}
