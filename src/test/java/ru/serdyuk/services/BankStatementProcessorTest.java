package ru.serdyuk.services;

import org.junit.Assert;
import org.junit.Test;
import ru.serdyuk.dao.BankTransaction;

import java.time.LocalDate;
import java.time.Month;



public class BankStatementProcessorTest {

    private final BankStatementParser statementParser = new BankStatementCSBParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseForm(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, " Tesco");

        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    public void shouldParseOneNotCorrectLine() throws Exception {
        final String line = "30-01-2017,-51,Tesco";

        final BankTransaction result = statementParser.parseForm(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, " Tesco");

        Assert.assertNotEquals(expected.getAmount(), result.getAmount());
    }
}