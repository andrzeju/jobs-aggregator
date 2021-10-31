package pl.au.jobsaggregator.domain.joboffer.usecase;

import java.math.BigDecimal;

public record JobOfferCreate(
        String companyName,
        String position,
        BigDecimal salary,
        String description
) {}
