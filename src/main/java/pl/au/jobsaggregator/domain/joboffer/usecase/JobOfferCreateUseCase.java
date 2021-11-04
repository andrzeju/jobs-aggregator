package pl.au.jobsaggregator.domain.joboffer.usecase;

import org.springframework.stereotype.Service;
import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferOutputPort;

@Service
public class JobOfferCreateUseCase {

    final JobOfferOutputPort jobOfferPort;

    public JobOfferCreateUseCase(JobOfferOutputPort jobOfferPort) {
        this.jobOfferPort = jobOfferPort;
    }

    public JobOffer create(JobOfferCreate jobOfferCreate) {
        return jobOfferPort.create(jobOfferCreate);
    }
}
