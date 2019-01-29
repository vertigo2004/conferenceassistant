package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.service.QuestionService;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;

@Controller
public class TopicController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TopicService topicService;

    @GetMapping("/topic/{id}")
    public String loadTopics(@PathVariable Long id, Model model){
        Topic topic = topicService.getTopic(id);
        model.addAttribute("topic", topic);
        Iterable<Question> questions = questionService.sortQuestion(topic.getQuestions());
        model.addAttribute("questions", questions);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        model.addAttribute("sdf", sdf);
        return "topic";
    }


    @PostMapping("/topic/like")
    public String likeTopic(@RequestParam Long id,
                            @RequestParam String email,
                            @RequestParam(required = false) String nickname) {
        Topic t;
        if (email == null || email.isEmpty()) {
            t = topicService.getTopic(id);
        } else {
            if (nickname == null || nickname.isEmpty()) {
                nickname = email.substring(0, email.indexOf('@'));
            }
            t = topicService.likeTopic(id, new User(email, nickname));

        }
        return "redirect:/conf/1";
    }
}
