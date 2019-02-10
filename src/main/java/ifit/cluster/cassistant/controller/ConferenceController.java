package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/conference/{id}")
    public String conference(@PathVariable Long id, Model model){
        Conference conference = conferenceService.getById(id);
        model.addAttribute("conference", conference);
        model.addAttribute("topics", conference.getTopics());
        return "conference";
    }

    @GetMapping("/conferences")
    public String conferences(Model model) {
        Iterable<Conference> conferences = conferenceService.getAll();
        model.addAttribute("conferences", conferences);
        return "conferences";
    }

}
