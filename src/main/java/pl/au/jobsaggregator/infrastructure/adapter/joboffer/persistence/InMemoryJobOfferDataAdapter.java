package pl.au.jobsaggregator.infrastructure.adapter.joboffer.persistence;

import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.port.JobOfferOutputPort;
import pl.au.jobsaggregator.domain.joboffer.usecase.JobOfferCreate;
import pl.au.jobsaggregator.domain.joboffer.usecase.JobOfferQuery;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryJobOfferDataAdapter implements JobOfferOutputPort {

    private final ConcurrentHashMap<Long, JobOffer> offers = new ConcurrentHashMap<>();

    @Override
    public JobOffer create(JobOfferCreate created) {
        long id = offers.size() + 1;
        JobOffer jobOffer = new JobOffer(
                id,
                created.companyName(),
                created.position(),
                created.salary(),
                created.description());
        offers.put(id, jobOffer);
        return jobOffer;
    }

    @Override
    public JobOffer get(Long id) {
        return offers.get(id);
    }

    @Override
    public List<JobOffer> query(JobOfferQuery query) {
        return offers.values().stream()
                .filter(offer -> offer.company().equals(query.companyName()))
                .toList();
    }
}
