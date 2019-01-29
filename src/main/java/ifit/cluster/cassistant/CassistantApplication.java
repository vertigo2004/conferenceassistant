package ifit.cluster.cassistant;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Calendar;

@SpringBootApplication
public class CassistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(CassistantApplication.class, args);
    }

    @Autowired
    ConferenceRepo conferenceRepo;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){

        return args -> {
            Conference c1 = new Conference("Конференція 1", "Info of conference 1");
            Conference c2 = new Conference("Conference 2", "Info of conference 2");

            Topic t1 = new Topic("Topic 1", "Summary of topic 1", "Speaker of topic 1", Calendar.getInstance().getTime(), c1, 0);
            Topic t2 = new Topic("Topic 2", "Summary of topic 2", "Speaker of topic 2", Calendar.getInstance().getTime(), c1, 0);
            Topic t3 = new Topic("Topic 3", "Summary of topic 3", "Speaker of topic 3", Calendar.getInstance().getTime(), c2, 0);
            Topic t4 = new Topic("Topic 4", "Summary of topic 4", "Speaker of topic 4", Calendar.getInstance().getTime(), c2, 0);

            c1.setTopics(Arrays.asList(t1, t2));
            c2.setTopics(Arrays.asList(t3, t4));

            conferenceRepo.save(c1);
            conferenceRepo.save(c2);

            System.out.println("INITIAL");

        };
    }

}

