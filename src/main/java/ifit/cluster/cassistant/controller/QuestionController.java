package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question/like")
    public String likeQuestion(@RequestParam Long id, @RequestParam String email, @RequestParam(required = false) String nickname){
        Question question;
        if (email == null || email.isEmpty()){
            question = questionService.getById(id);
        } else {
            if(nickname == null || nickname.isEmpty()){
                nickname = email.substring(0, email.indexOf('@'));
            }
            question = questionService.likeQuestion(id, new User(email, nickname));
        }
        return "redirect:/topic/" + question.getTopic().getId();
    }
}
