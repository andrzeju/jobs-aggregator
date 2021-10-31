package pl.au.jobsaggregator.domain.joboffer.usecase;

public record JobOfferRetrieve(Long id) {

    public static JobOfferRetrieve from(Long id) {
        return new JobOfferRetrieve(id);
    }

}
