package ifit.cluster.cassistant.controller;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/conf/")
@Controller
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("{id}")
    public String conference(@PathVariable Long id, Model model){
        Conference conference = conferenceService.getById(id);
        model.addAttribute("conference", conference);

        return "conference";
    }

    @GetMapping("all")
    public String conferences(Model model) {
        model.addAttribute("conferences", conferenceService.finadALl());
        return "conferences";

    }

}
