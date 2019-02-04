package ifit.cluster.cassistant.controllers;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/like")
    public String likeTopic(@RequestParam Long id, @RequestParam String email, @RequestParam(required = false) String nickname) {
        Topic t;
        if (email == null || email.isEmpty()) {
            t = topicService.getTopic(id);
        } else {
            if (nickname == null || nickname.isEmpty()) {
                nickname = email.substring(0, email.indexOf('@'));
            }
            t = topicService.likeTopic(id, new User(email, nickname));
        }
        return "redirect:/conference/" + t.getConference().getId();
    }
}
