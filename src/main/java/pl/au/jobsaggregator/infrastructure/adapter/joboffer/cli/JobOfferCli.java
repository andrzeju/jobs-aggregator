package pl.au.jobsaggregator.infrastructure.adapter.joboffer.cli;

import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferPort;
import pl.au.jobsaggregator.domain.joboffer.usecase.*;

import java.util.List;

public class JobOfferCli implements JobOfferPort {

    private final JobOfferCreateUseCase jobOfferCreateUseCase;
    private final JobOfferRetrieveUseCase jobOfferRetrieveUseCase;

    public JobOfferCli(JobOfferCreateUseCase jobOfferCreateUseCase, JobOfferRetrieveUseCase jobOfferRetrieveUseCase) {
        this.jobOfferCreateUseCase = jobOfferCreateUseCase;
        this.jobOfferRetrieveUseCase = jobOfferRetrieveUseCase;
    }

    @Override
    public JobOffer create(JobOfferCreate jobOffer) {
        return jobOfferCreateUseCase.create(jobOffer);
    }

    @Override
    public JobOffer get(Long id) {
        return jobOfferRetrieveUseCase.retrieve(JobOfferRetrieve.from(id));
    }

    @Override
    public List<JobOffer> query(JobOfferQuery query) {
        return null;
    }
}
