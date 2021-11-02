package pl.au.jobsaggregator.domain.joboffer.port;

import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.usecase.JobOfferCreate;
import pl.au.jobsaggregator.domain.joboffer.usecase.JobOfferQuery;

import java.util.List;

public interface JobOfferOutputPort {

    JobOffer create(JobOfferCreate jobOffer);

    JobOffer get(Long id);

    List<JobOffer> query(JobOfferQuery query);
}
