package ru.serdyuk.main;

import ru.serdyuk.services.BankStatementAnalyzer;
import ru.serdyuk.services.BankStatementCSBParser;
import ru.serdyuk.services.BankStatementParser;

import java.io.IOException;


public class MainApplication {

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSBParser();

        bankStatementAnalyzer.analyze( bankStatementParser);
    }

}
