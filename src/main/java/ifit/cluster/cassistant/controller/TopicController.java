package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import ifit.cluster.cassistant.repo.QuestionRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TopicController {
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private ConferenceRepo conferenceRepo;
    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/topic/{id}")
    public String loadTopics(@PathVariable Long id, Model model){
        Topic topic = topicRepo.getById(id);
        model.addAttribute("topic", topic);
        Iterable<Question> questions = topic.getQuestions();
        model.addAttribute("questions", questions);
        return "Topic";
    }
}
