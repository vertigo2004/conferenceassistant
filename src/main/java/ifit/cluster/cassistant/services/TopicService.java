package ifit.cluster.cassistant.services;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic getTopic(Long id) {
        return topicRepository.findById(id).get();
    }

    public Topic likeTopic(Long id, User user) {
        Topic t = topicRepository.findById(id).get();

        t.getLikes().add(user);
        return topicRepository.save(t);
    }

}
