package pl.au.jobsaggregator.domain.joboffer.usecase;

import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferPort;

public class JobOfferRetrieveUseCase {

    private final JobOfferPort jobOfferPort;

    public JobOfferRetrieveUseCase(JobOfferPort jobOfferPort) {
        this.jobOfferPort = jobOfferPort;
    }

    public JobOffer retrieve(JobOfferRetrieve usecase) {
        return jobOfferPort.get(usecase.id());
    }
}
