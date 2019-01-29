package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.service.QuestionService;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ModeratorController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/moderator/{id}")
    public String questionList(@PathVariable Long id, Model model) {
        Topic topic = topicService.getTopic(id);
        model.addAttribute("topic", topic);
        List<Enum<State>> states = questionService.loadStates();
        model.addAttribute("states", states);
        Iterable<Question> questions = questionService.sortQuestion(topic.getQuestions());
        model.addAttribute("questions", questions);

        return "moderator";
    }

    @PostMapping("/moderator/{topicId}/{questionId}")
    public String changeState(@PathVariable Long topicId,
                              @PathVariable Long questionId,
                              @RequestParam String state)
    {
        questionService.changeState(questionId, state);
        return "redirect:/moderator/" + topicId;
    }
}
