package pl.au.jobsaggregator.domain.joboffer.usecase;

import org.springframework.stereotype.Service;
import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferOutputPort;

@Service
public class JobOfferRetrieveUseCase {

    private final JobOfferOutputPort jobOfferPort;

    public JobOfferRetrieveUseCase(JobOfferOutputPort jobOfferPort) {
        this.jobOfferPort = jobOfferPort;
    }

    public JobOffer retrieve(JobOfferRetrieve usecase) {
        return jobOfferPort.get(usecase.id());
    }
}
