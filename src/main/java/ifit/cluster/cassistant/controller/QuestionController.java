package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.service.QuestionService;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final TopicService topicService;

    @Autowired
    public QuestionController(QuestionService questionService, TopicService topicService) {
        this.questionService = questionService;
        this.topicService = topicService;
    }

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

    @PostMapping("/question/add")
    public String addTopic(@RequestParam Long topicId, Model model){
        model.addAttribute("question", new Question());
        model.addAttribute("topic", topicService.getById(topicId));
        return "question_form";
    }

    @PostMapping("/question/save")
    public String saveQuestion(@RequestParam Long topicId, @ModelAttribute Question question){
        Topic topic = topicService.getById(topicId);
        question.setTopic(topic);
        question.setState(State.NEW);
        questionService.saveQuestion(question);
        return "redirect:/topic/" + topic.getId();
    }

    @PostMapping("/question/delete")
    public String deleteQuestion(@RequestParam Long id){
        Long topicId = questionService.getById(id).getTopic().getId();
        questionService.deleteQuestion(id);
        return "redirect:/topic/" + topicId;
    }
}
