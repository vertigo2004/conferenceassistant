package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    void IncrementRate(Topic topic) {
        topic.setRate(topic.getRate() + 1);
    }

    //нахіба нам цей метод, не пам'ятаю поки що. Skipped.
    private boolean checkEmail(String email) {
        return false;
    }

    public Topic getTopic(Long topicID) {
        return topicRepo.getTopic(topicID);
    }

}
