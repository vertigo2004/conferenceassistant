package ifit.cluster.cassistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class StatisticController {

    @GetMapping("/stat")
    @RolesAllowed("ROLE_MODERATOR")
    public String statistic(){
        return "statistic";
    }
}
