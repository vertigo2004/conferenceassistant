package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TopicService {
    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> sortTopics(Iterable<Topic> topics) {
        List<Topic> topicList = StreamSupport
                .stream(topics.spliterator(), false)
                .collect(Collectors.toList());
        Collections.sort(topicList, new Comparator<Topic>() {
            @Override
            public int compare(Topic o1, Topic o2) {
                return o2.getRate().compareTo(o1.getRate());
            }
        });
        return topicList;
    }

    public Topic getTopic(Long id) {
        return topicRepo.findById(id).get();
    }

    public Topic likeTopic(Long id, User user) {
        Topic t = topicRepo.findById(id).get();

        if(!t.getLikes().contains(user)) {
            t.getLikes().add(user);
            t.setRate(t.getRate() + 1);
        }else {
            t.setRate(t.getRate() - 1);
            t.getLikes().remove(user);
        }
        return topicRepo.save(t);
    }

    public Topic addQuestionToTopic(Long id, Question question){
        Topic t = getTopic(id);
        List<Question> questions = t.getQuestions();
        questions.add(question);
        topicRepo.save(t);
        return t;
    }
}