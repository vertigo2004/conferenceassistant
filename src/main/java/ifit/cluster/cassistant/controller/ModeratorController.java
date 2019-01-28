package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.QuestionRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import ifit.cluster.cassistant.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class ModeratorController {
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/moderator/{id}")
    public String questionList(@PathVariable Long id, Model model) {
        Topic topic = topicRepo.getById(id);
        model.addAttribute("topic", topic);
        List<Enum<State>> states = new ArrayList<>();
        states.add(State.NEW);
        states.add(State.IN_PROGRESS);
        states.add(State.ANSWERED);
        states.add(State.REMOVED);
        model.addAttribute("states", states);
        Iterable<Question> questions = questionService.sortQuestion(topic.getQuestions());
        model.addAttribute("questions", questions);

        return "Moderator";
    }

    @PostMapping("/moderator/{topicId}/{questionId}")
    public String changeState(@PathVariable Long topicId,
                              @PathVariable Long questionId,
                              @RequestParam String state)
    {
        Question q = questionService.getQuestion(questionId);
        Set<State> set = new HashSet<>();
        set.add(State.valueOf(state));
        q.setState(set);
        questionRepo.save(q);
        return "redirect:/moderator/" + topicId;
    }
}
