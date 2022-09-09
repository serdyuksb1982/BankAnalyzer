package ru.serdyuk.main;

import ru.serdyuk.domain.BankTransaction;
import ru.serdyuk.services.BankStatementCSBParser;
import ru.serdyuk.services.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class SecontMainBankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/resources.csv";
    private static final BankStatementCSBParser bankStatementCSBParser = new BankStatementCSBParser();

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction>  bankTransactions = bankStatementCSBParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth( Month.JANUARY ));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
