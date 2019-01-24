package ifit.cluster.cassistant.configuration;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Calendar;

@Configuration
public class DatabaseInitials {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {

            Conference c = new Conference("Conf 1", "Conf 1 Info Info Info", null);
            Topic t1 = new Topic("Topic #1", "Summary 1 Summary 1 Summary 1 ", "Speaker 1", Calendar.getInstance().getTime(), c);
            Topic t2 = new Topic("Topic #2", "Summary 2 Summary 2 Summary 2 ", "Speaker 2", Calendar.getInstance().getTime(), c);
            Topic t3 = new Topic("Topic #3", "Summary 3 Summary 3 Summary 3 ", "Speaker 3", Calendar.getInstance().getTime(), c);
            Topic t4 = new Topic("Topic #4", "Summary 4 Summary 4 Summary 4 ", "Speaker 4", Calendar.getInstance().getTime(), c);

            c.setTopics(Arrays.asList(t1, t2, t3, t4));
            c = conferenceRepository.save(c);

            System.out.println(">>> conference id >>> " + c.getId());
        };
    }

}