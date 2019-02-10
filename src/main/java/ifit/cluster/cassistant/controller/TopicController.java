package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/topic/like")
    public String likeTopic(@RequestParam Long id, @RequestParam String email, @RequestParam(required = false) String nickname){
        Topic topic;
        if (email == null || email.isEmpty()){
            topic = topicService.getById(id);
        } else {
            if(nickname == null || nickname.isEmpty()){
                nickname = email.substring(0, email.indexOf('@'));
            }
            topic = topicService.likeTopic(id, new User(email, nickname));
        }
        return "redirect:/conference/" + topic.getConference().getId();
    }
}
