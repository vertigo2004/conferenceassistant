package ifit.cluster.cassistant.controllers.rest;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class TopicRestController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/rest/topic")
    List<Topic> findBySpeaker(@RequestParam(name = "speaker") String speaker) {
        return topicRepository.findBySpeaker(speaker);

    }

    @GetMapping("/rest/topicByLike")
    List<Topic> findByLike(@RequestParam(name = "email") String email) {
        return topicRepository.findByLikes(new User(email, null));
    }

    @GetMapping("/rest/topics/byNameOrSpeaker")
    List<Topic> findByOr(@RequestParam(name = "name") String name, @RequestParam(name = "speaker") String speaker) {
        return topicRepository.findByNameOrSpeaker(name, speaker);
    }

    @GetMapping("/rest/topics")
    List<Topic> findAll() {
        Iterator<Topic> iterator = topicRepository.findAll().iterator();
        List<Topic> topics = new ArrayList<>();
        while (iterator.hasNext()) {
            topics.add(iterator.next());
        }
        return topics;
    }

    @GetMapping("/rest/topics/asc")
    List<Topic> findBySpeakerAsc() {
        return topicRepository.findAllByOrderBySpeakerAsc();
    }

    @GetMapping("/rest/topics/desc")
    List<Topic> findBySpeakerDesc() {
        return topicRepository.findAllByOrderBySpeakerDesc();

    }

    @GetMapping("/rest/topic/count")
    int countBySpeaker(@RequestParam(name = "speaker") String speaker) {
        return topicRepository.countBySpeaker(speaker);

    }
}
