package pl.au.jobsaggregator.domain.joboffer.usecase;

import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferPort;

public class JobOfferCreateUseCase {

    final JobOfferPort jobOfferPort;

    public JobOfferCreateUseCase(JobOfferPort jobOfferPort) {
        this.jobOfferPort = jobOfferPort;
    }

    public JobOffer create(JobOfferCreate jobOfferCreate) {
        return jobOfferPort.create(jobOfferCreate);
    }
}
