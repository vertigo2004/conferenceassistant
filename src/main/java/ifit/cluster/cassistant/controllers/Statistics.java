package ifit.cluster.cassistant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class Statistics {

    @GetMapping("/stat/admin")
    @RolesAllowed("ROLE_MODERATOR")
    public String privateHome() {
        return "privatePage";
    }
}
