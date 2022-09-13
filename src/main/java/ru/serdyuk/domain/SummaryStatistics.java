package ru.serdyuk.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;

}
