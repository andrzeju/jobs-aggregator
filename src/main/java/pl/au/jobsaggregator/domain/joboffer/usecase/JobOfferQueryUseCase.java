package pl.au.jobsaggregator.domain.joboffer.usecase;

import org.springframework.stereotype.Service;
import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferOutputPort;

import java.util.List;

@Service
public class JobOfferQueryUseCase {
    private JobOfferOutputPort jobOfferPort;

    public JobOfferQueryUseCase(JobOfferOutputPort jobOfferPort) {
        this.jobOfferPort = jobOfferPort;
    }

    public List<JobOffer> query(JobOfferQuery jobOfferQuery) {
        return jobOfferPort.query(jobOfferQuery);
    }
}
