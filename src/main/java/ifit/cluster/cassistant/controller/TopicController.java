package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topic/{id}")
    public String topic(@PathVariable Long id, Model model){
        Topic topic = topicService.getById(id);
        model.addAttribute("topic", topic);
        model.addAttribute("questions", topic.getQuestions());
        return "topic";
    }
}
