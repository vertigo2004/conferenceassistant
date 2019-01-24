package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConferenceController {
    @Autowired
    private ConferenceRepo conferenceRepo;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String conference(Model model){
        Conference conference = conferenceRepo.getById(1L);
        model.addAttribute("conference", conference);

        return "Conference";
    }
}
