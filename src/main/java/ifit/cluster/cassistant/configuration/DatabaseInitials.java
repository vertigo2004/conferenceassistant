package ifit.cluster.cassistant.configuration;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.repo.ConferenceRepo;
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
    private ConferenceRepo conferenceRepo;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){

        return args -> {
            Conference c1 = new Conference("Автомобілі майбутнього", "Тенденції і напрямки розвитку галузі автомобілебудування");
            Conference c2 = new Conference("Шкідливі звички", "Вплив шкідливих звичок на життя людини");

            Topic t1 = new Topic("Електромобілі", "Переваги та недоліки електромобілів", "Ілон Маск", Calendar.getInstance().getTime(), c1);
            Topic t2 = new Topic("Гібридні автомобілі", "Переваги та недоліки гібридних автомобілів", "Директор Тойоти", Calendar.getInstance().getTime(), c1);
            Topic t3 = new Topic("Куріння", "Шкідливий вплив куріння", "Курець", Calendar.getInstance().getTime(), c2);
            Topic t4 = new Topic("Алкоголь", "Шкідливий вплив алкоголю", "Алкоголік", Calendar.getInstance().getTime(), c2);

            Question q1 = new Question("email1@ukr.net", "Який запас ходу електромобіля на одному заряді?", t1, State.NEW);
            Question q2 = new Question("email2@ukr.net", "Який час повної зарядки електромобіля?", t1, State.NEW);
            Question q3 = new Question("email3@ukr.net", "Яка витрата палива гібридного автомобіля?", t2, State.NEW);
            Question q4 = new Question("email4@ukr.net", "Яка сумарна потужність гібридного автомоблія?", t2, State.NEW);
            Question q5 = new Question("email5@ukr.net", "Скільки сигарет в день Ви викурюєте?", t3, State.NEW);
            Question q6 = new Question("email6ukr.net", "Зі скількох років Ви палите?", t3, State.NEW);
            Question q7 = new Question("email7@ukr.net", "Скільки Вам треба алкоголю для повного щастя?", t4, State.NEW);
            Question q8 = new Question("email8@ukr.net", "Яким напоям Ви надаєте перевагу?", t4, State.NEW);

            t1.setQuestions(Arrays.asList(q1, q2));
            t2.setQuestions(Arrays.asList(q3, q4));
            t3.setQuestions(Arrays.asList(q5, q6));
            t4.setQuestions(Arrays.asList(q7, q8));

            c1.setTopics(Arrays.asList(t1, t2));
            c2.setTopics(Arrays.asList(t3, t4));

            conferenceRepo.save(c1);
            conferenceRepo.save(c2);

            System.out.println("INITIAL");
        };
    }
}
