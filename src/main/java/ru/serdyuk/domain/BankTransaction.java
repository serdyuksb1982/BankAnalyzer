package ru.serdyuk.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Getter@Setter
@EqualsAndHashCode
public class BankTransaction {
    private final LocalDate date;
    public final double amount;
    public final String description;


}
