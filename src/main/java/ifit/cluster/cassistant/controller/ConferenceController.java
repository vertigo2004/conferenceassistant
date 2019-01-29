package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import ifit.cluster.cassistant.service.ConferenceService;
import ifit.cluster.cassistant.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

//    @GetMapping("/")
//    public String conference(Model model){
//        Conference conference = conferenceService.getById(1L);
//        model.addAttribute("conference", conference);
//
//        return "Conference";
//    }

    @GetMapping("/conf/{id}")
    public String conference(@PathVariable Long id, Model model){
        Conference conference = conferenceService.getById(id);
        model.addAttribute("conference", conference);

        return "conference";
    }

    @GetMapping("/conf")
    public String conferences(Model model) {
        Iterable<Conference> conferences = conferenceService.getAll();
        model.addAttribute("conferences", conferences);

        return "conferences";

    }

}
