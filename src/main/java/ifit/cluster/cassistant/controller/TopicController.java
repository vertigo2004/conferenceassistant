package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.service.ConferenceService;
import ifit.cluster.cassistant.service.QuestionService;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
public class TopicController {

    private final QuestionService questionService;
    private final TopicService topicService;
    private final ConferenceService conferenceService;

    @Autowired
    public TopicController(QuestionService questionService, TopicService topicService, ConferenceService conferenceService) {
        this.questionService = questionService;
        this.topicService = topicService;
        this.conferenceService = conferenceService;
    }

    @GetMapping("/topic/{id}")
    public String topic(@PathVariable Long id, Model model){
        Topic topic = topicService.getById(id);
        model.addAttribute("topic", topic);
        List<Question> questions = questionService.sortQuestion(topic.getQuestions());
        model.addAttribute("questions", questions);
        model.addAttribute("states", State.values());
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

    @PostMapping("/topic/add")
    @RolesAllowed({"ROLE_MODER", "ROLE_ADMIN"})
    public String addTopic(@RequestParam Long conferenceId, Model model){
        model.addAttribute("topic", new Topic());
        model.addAttribute("conference",conferenceService.getById(conferenceId));
        return "topic_form";
    }

    @PostMapping("/topic/save")
    @RolesAllowed({"ROLE_MODER", "ROLE_ADMIN"})
    public String saveTopic(@RequestParam Long conferenceId, @ModelAttribute Topic topic){
        Conference conference = conferenceService.getById(conferenceId);
        topic.setConference(conference);
        topicService.saveTopic(topic);
        return "redirect:/conference/" + conference.getId();
    }

    @PostMapping("/topic/delete")
    @RolesAllowed({"ROLE_MODER", "ROLE_ADMIN"})
    public String deleteTopic(@RequestParam Long id){
        Long conferenceId = topicService.getById(id).getConference().getId();
        topicService.deleteTopic(id);
        return "redirect:/conference/" + conferenceId;
    }
}
