package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/topic/")
@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("{id}")
    public String getTopic(@PathVariable Long id, Model model) {
        model.addAttribute("topic", topicService.getTopic(id));
        return "topic";
    }



}
