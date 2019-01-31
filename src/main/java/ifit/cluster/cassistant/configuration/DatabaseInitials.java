package ifit.cluster.cassistant.configuration;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

@Configuration
public class DatabaseInitials {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {

            User a = new User("alan@gmail.com", "Alan");
            User b = new User("bob@bbb.com", "Bob");
            User c = new User("cemical@brothers.inc", "Calvin");

            Conference conf = new Conference("Conf 1", "Conf 1 Info Info Info", null);
            Topic t1 = new Topic("Topic 1", "Summary 1 Summary 1 Summary 1 ", "Zinedine Zidane", Calendar.getInstance().getTime(), conf);
            Topic t2 = new Topic("Topic 2", "Summary 2 Summary 2 Summary 2 ", "Valentino", Calendar.getInstance().getTime(), conf);
            Topic t3 = new Topic("Topic 3", "Summary 3 Summary 3 Summary 3 ", "Valentino", Calendar.getInstance().getTime(), conf);
            Topic t4 = new Topic("Topic 4", "Summary 4 Summary 4 Summary 4 ", "Wanda Wunderbar Waldermot", Calendar.getInstance().getTime(), conf);
            Topic t5 = new Topic("Topic 5", "Summary 5 Summary 5 Summary 5 ", "Xavier X-Man", Calendar.getInstance().getTime(), conf);

            t2.setLikes(new HashSet<>(Arrays.asList(b)));
            t3.setLikes(new HashSet<>(Arrays.asList(b, c)));
            t4.setLikes(new HashSet<>(Arrays.asList(a, b )));
            t5.setLikes(new HashSet<>(Arrays.asList(a, b, c)));

            conf.setTopics(Arrays.asList(t1, t2, t3, t4, t5));
            conf = conferenceRepository.save(conf);

            System.out.println(">>> conference id >>> " + conf.getId());
        };
    }

}
