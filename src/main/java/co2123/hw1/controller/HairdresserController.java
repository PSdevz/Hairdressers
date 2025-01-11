package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Hairdresser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;



@Controller
public class HairdresserController {

    // Show the list of hairdressers


    @GetMapping("/hairdressers")
    public String showHairdressersList(Model model) {
        model.addAttribute("hairdressers", Hw1Application.hairdressers);
        return "hairdressers/list";
    }
    // Show form to add a new hairdresser
    @GetMapping("/newHairdresser")
    public String showHairdresserForm(Model model) {
        model.addAttribute("hairdresser", new Hairdresser());
        return "hairdressers/form";
    }

    // Add a new hairdresser to the list
    @PostMapping("/addHairdresser")
    public String addHairdresser(@Valid @ModelAttribute Hairdresser hairdresser, BindingResult result) {
        if (result.hasErrors()) {
            return "hairdressers/form";
        }
        Hw1Application.hairdressers.add(hairdresser);
        return "redirect:/hairdressers";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new HairdresserValidator());
    }
}