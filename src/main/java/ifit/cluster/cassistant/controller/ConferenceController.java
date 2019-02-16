package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConferenceController {

    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conferences")
    public String conferences(Model model) {
        Iterable<Conference> conferences = conferenceService.getAll();
        model.addAttribute("conferences", conferences);
        return "conferences";
    }

    @GetMapping("/conference/{id}")
    public String conference(@PathVariable Long id, Model model){
        Conference conference = conferenceService.getById(id);
        model.addAttribute("conference", conference);
        model.addAttribute("topics", conference.getTopics());
        return "conference";
    }

    @GetMapping("/conference/add")
    public String addConference(Model model){
        model.addAttribute("conference", new Conference());
        return "conference_form";
    }

    @PostMapping("/conference/save")
    public String saveConference(@ModelAttribute Conference conference){
        conferenceService.saveConference(conference);
        return "redirect:/conferences";
    }

    @PostMapping("/conference/delete")
    public String deleteConference(@RequestParam Long id){
        conferenceService.deleteConference(id);
        return "redirect:/conferences";
    }

}
