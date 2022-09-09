package ru.serdyuk.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
@Data
@Getter@Setter
@EqualsAndHashCode
@ToString
public class BankTransaction {
    private final LocalDate date;
    public final double amount;
    public final String description;
}
