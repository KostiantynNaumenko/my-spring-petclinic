package guru.springframework.mysfgpetclinic.controllers;

import guru.springframework.mysfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RequestMapping("/visits")
    public String getVisits(Model model) {

        model.addAttribute("visits", visitService.findAll());

        return "visits/index";
    }
}
