package pl.au.jobsaggregator.domain.joboffer.model;

import java.math.BigDecimal;

public record JobOffer(
        Long id,
        String company,
        String position,
        BigDecimal salary,
        String description
) {}
