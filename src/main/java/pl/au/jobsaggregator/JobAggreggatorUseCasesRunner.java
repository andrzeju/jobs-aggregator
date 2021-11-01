package pl.au.jobsaggregator;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.au.jobsaggregator.domain.joboffer.model.JobOffer;
import pl.au.jobsaggregator.domain.joboffer.usecase.*;
import pl.au.jobsaggregator.infrastructure.adapter.joboffer.cli.JobOfferCli;
import pl.au.jobsaggregator.infrastructure.adapter.joboffer.persistence.InMemoryJobOfferDataAdapter;

import java.math.BigDecimal;
import java.util.List;

@Log
@Component
public class JobAggreggatorUseCasesRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        InMemoryJobOfferDataAdapter dataAdapter = new InMemoryJobOfferDataAdapter();

        JobOfferCli cli = new JobOfferCli(
                new JobOfferCreateUseCase(dataAdapter),
                new JobOfferRetrieveUseCase(dataAdapter),
                new JobOfferQueryUseCase(dataAdapter));

        log.info("Creating and retrieving articles...");

        JobOffer offer = cli.create(new JobOfferCreate(
                "Dell",
                "Software Developer",
                BigDecimal.valueOf(150000),
                "To create the best app in the world!"
        ));

        JobOffer article = cli.get(1L);
        log.info("Article: " + article);

        List<JobOffer> articles = cli.query(new JobOfferQuery("Dell"));
        log.info("Articles: " + articles);
    }
}
