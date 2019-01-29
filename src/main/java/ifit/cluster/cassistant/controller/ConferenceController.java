package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import ifit.cluster.cassistant.service.ConferenceService;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/conf")
@Controller
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private TopicService topicService;

    @GetMapping("/{id}")
    public String conference(@PathVariable Long id, Model model){
        Conference conference = conferenceService.getById(id);
        Iterable<Topic> topics = topicService.sortTopics(topicService.getAll());
        model.addAttribute("conference", conference);
        model.addAttribute("topics", topics);
        return "сonference";
    }

    @GetMapping("/all")
    public String confList(Model model){
        Iterable<Conference> conferences = conferenceService.getAll();
        model.addAttribute("conferences", conferences);
        return "confList";
    }
}
