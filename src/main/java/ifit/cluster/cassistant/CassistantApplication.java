package ifit.cluster.cassistant;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import ifit.cluster.cassistant.repo.QuestionRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.*;


@SpringBootApplication
public class CassistantApplication {
    @Autowired
    private ConferenceRepo conferenceRepo;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public static void main(String[] args) {
        SpringApplication.run(CassistantApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {
            Conference conf1 = new Conference("Conference about Something:)"
                    , "This conference will held on 4th of July from 10 AM to 1PM, and a lot more text must be here... Just a testing text"
            );

            Calendar calendar1 = new GregorianCalendar(2019,2,30,16,30,0);
            Topic topic1 = new Topic("Environment Protection"
                    , "Summary about this topic, actually idk what must be here"
                    , "Opra"
                    , calendar1
                    , conf1
                    , Arrays.asList()
                    , 9);
            Calendar calendar2 = new GregorianCalendar(2019,1,21,18,0,0);
            calendar1.set(2019,1,30,13,30);
            Topic topic2 = new Topic("How to quite smoking"
                    , "Summary about this topic, actually idk what must be here"
                    , "Jonny Ive"
                    , calendar2
                    , conf1
                    , Arrays.asList()
                    , 12);

            Question question1 = new Question("any@gmail.com"
                    , "Same shit here, must be very smart question to the speaker"
                    , 5
                    , topic1
                    , Collections.singleton(State.NEW));
            Question question2 = new Question("somemail@gmail.com"
                    , "Here must be very smart question to the speaker?"
                    , 3
                    , topic1
                    , Collections.singleton(State.IN_PROGRESS));

            Question question3 = new Question("email@gmail.com"
                    , "How long time person has to quite smoking, instantly or for a while time ?"
                    , 5
                    , topic2
                    , Collections.singleton(State.ANSWERED));
            Question question4 = new Question("mailexample@gmail.com"
                    , "What is the best practice for quite smoking without downsides?"
                    , 3
                    , topic2
                    , Collections.singleton(State.REMOVED));
            conferenceRepo.save(conf1);
            topicRepo.save(topic1);
            topicRepo.save(topic2);
            questionRepo.save(question1);
            questionRepo.save(question2);
            questionRepo.save(question3);
            questionRepo.save(question4);
        };

    }
}