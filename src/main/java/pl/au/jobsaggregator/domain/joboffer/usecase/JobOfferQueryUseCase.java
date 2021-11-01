package pl.au.jobsaggregator.domain.joboffer.usecase;

import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferPort;

import java.util.List;

public class JobOfferQueryUseCase {
    private JobOfferPort jobOfferPort;

    public JobOfferQueryUseCase(JobOfferPort jobOfferPort) {
        this.jobOfferPort = jobOfferPort;
    }

    public List<JobOffer> query(JobOfferQuery jobOfferQuery) {
        return jobOfferPort.query(jobOfferQuery);
    }
}
