package ifit.cluster.cassistant.controllers;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.services.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conference")
public class ConferenceController {

    private static Logger log = LoggerFactory.getLogger(ConferenceController.class);

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/{id}")
    public String getConference(@PathVariable Long id, Model model) {

        Conference conference = conferenceService.getConference(id).orElseThrow( () -> {
            log.error("Conference id = {} is not found", id);
            return new RuntimeException("Conference is not found");
        });

//        Conference conference = conferenceService.getConference(id).get();
        model.addAttribute(conference);

        return "conference";
    }
}
