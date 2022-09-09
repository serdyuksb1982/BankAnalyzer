package ru.serdyuk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String RESOURCES = "src/main/resources/resources.csv";

    public static void main(String[] args) throws IOException {

        final BankStatementCSBParser bankStatementCSBParser = new BankStatementCSBParser();
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementCSBParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is :" + calculateTotalAmount(bankTransactions));

        System.out.println("Transactions in January " + selectInMonth(bankTransactions,Month.AUGUST));
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    
    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth().equals(month)) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        
        return bankTransactions;
    }


}
