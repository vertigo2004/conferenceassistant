package ifit.cluster.cassistant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class Statistics {

    @GetMapping("/stat/conf")
    @RolesAllowed({"ROLE_MODERATOR", "ROLE_ADMIN"})
    public String privateConf() {
        return "redirect:/conference/1";
    }

    @GetMapping("/stat/admin")
    @RolesAllowed("ROLE_ADMIN")
    public String privateHome() {
        return "privatePage";
    }
}
