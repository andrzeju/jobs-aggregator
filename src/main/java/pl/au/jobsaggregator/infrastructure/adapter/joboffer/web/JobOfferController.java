package pl.au.jobsaggregator.infrastructure.adapter.joboffer.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.usecase.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("job-offer")
public class JobOfferController {

    private final JobOfferCreateUseCase jobOfferCreateUseCase;
    private final JobOfferRetrieveUseCase jobOfferRetrieveUseCase;
    private final JobOfferQueryUseCase jobOfferQueryUseCase;

    public JobOfferController(JobOfferCreateUseCase jobOfferCreateUseCase, JobOfferRetrieveUseCase jobOfferRetrieveUseCase,
                            JobOfferQueryUseCase jobOfferQueryUseCase) {
        this.jobOfferCreateUseCase = jobOfferCreateUseCase;
        this.jobOfferRetrieveUseCase = jobOfferRetrieveUseCase;
        this.jobOfferQueryUseCase = jobOfferQueryUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobOffer(@PathVariable Long id) {
        return Optional.ofNullable(jobOfferRetrieveUseCase.retrieve(JobOfferRetrieve.from(id)))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createJobOffer(@RequestBody JobOfferCreate jobOffer) {
        return ResponseEntity.ok(jobOfferCreateUseCase.create(jobOffer));
    }

    @PostMapping("/query")
    public ResponseEntity<List<JobOffer>> findJobOffers(@RequestBody JobOfferQuery jobOfferQuery) {
        return ResponseEntity.ok(jobOfferQueryUseCase.query(jobOfferQuery));
    }

}
