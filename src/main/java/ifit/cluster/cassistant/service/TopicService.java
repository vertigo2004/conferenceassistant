package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepo topicRepo;

    public Topic getById(Long id){
        return topicRepo.getById(id);
    }

    public Topic likeTopic(Long id, User user){
        Topic topic = topicRepo.getById(id);
        topic.getLikes().add(user);
        return topicRepo.save(topic);
    }
}
