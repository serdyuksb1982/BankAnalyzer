package ru.serdyuk.services.interfaces;

import ru.serdyuk.domain.SummaryStatistics;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
