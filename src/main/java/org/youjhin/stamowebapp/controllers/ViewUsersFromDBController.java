package org.youjhin.stamowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.youjhin.stamowebapp.services.interfaces.UsersService;

@Controller
public class ViewUsersFromDBController {

    private final UsersService usersService;

    //@Autowired
    public ViewUsersFromDBController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/allUsers")
    public String getTable(Model model) {
        model.addAttribute("users", usersService.getAllUsersFromBase());
        return "allUsers";
    }

}
