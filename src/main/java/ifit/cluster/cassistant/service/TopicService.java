package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepo topicRepo;


}
