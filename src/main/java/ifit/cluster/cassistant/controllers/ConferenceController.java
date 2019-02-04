package ifit.cluster.cassistant.controllers;

import ifit.cluster.cassistant.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/{id}")
    public String getConference(@PathVariable Long id, Model model) {

        model.addAttribute(conferenceService.getConference(id));

        return "conference";
    }
}
