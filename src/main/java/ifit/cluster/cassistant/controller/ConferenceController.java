package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/conference/")
@Controller
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("{id}")
    public String getConference(@PathVariable Long id, Model model){
        model.addAttribute("conference", conferenceService.getById(id));

        return "conference";
    }

    @GetMapping("all")
    public String getAllConferences(Model model) {
        model.addAttribute("conferences", conferenceService.findAll());
        return "conferences";

    }

}
