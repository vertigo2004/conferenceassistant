package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @PostMapping("/topic/question")
    public String addQuestion(@RequestParam String email,
                              @RequestParam String text,
                              @RequestParam Long id)
    {
       questionService.newQuestion(id,text,email);
        return "redirect:/topic/" + id;
    }

    @PostMapping("/question/like/{topicId}")
    public String likeQuestion(@PathVariable Long topicId, @RequestParam Long id, @RequestParam String email, @RequestParam(required = false) String nickname) {
        Question q;
        if (email == null || email.isEmpty()) {
            q = questionService.getQuestion(id);
        } else {
            if (nickname == null || nickname.isEmpty()) {
                nickname = email.substring(0, email.indexOf('@'));
            }
            q = questionService.likeQuestion(id, new User(email, nickname));

        }
        return "redirect:/topic/" + topicId;
    }
}
