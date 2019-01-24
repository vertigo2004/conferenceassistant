package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}