package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Hairdresser;
import co2123.hw1.domain.Stylist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;


import java.util.ArrayList;
import java.util.List;

@Controller
public class StylistController {

    // Display list of stylists for a specific hairdresser
    @GetMapping("/stylists")
    public String showStylists(Model model, @RequestParam int hairdresser) {
        List<Stylist> stylists = new ArrayList<>();

        for (Hairdresser h : Hw1Application.hairdressers) {
            if (h.getId() == hairdresser) {
                stylists = h.getStylists();
            }
        }

        model.addAttribute("stylists", stylists);
        model.addAttribute("hairdresser", hairdresser);

        return "stylists/list";
    }

    // Display form to add a new stylist
    @GetMapping("/newStylist")
    public String newStylist(Model model, @RequestParam(required = false) String hairdresser) {
        if (hairdresser == null || hairdresser.trim().isEmpty()) {
            // Log the error or redirect to an error page if the hairdresser parameter is missing
            System.out.println("Hairdresser ID is missing or invalid.");
            return "redirect:/error"; // Redirect to an error page or show a proper message
        }

        try {
            // Convert the hairdresser ID to an integer
            Integer hairdresserId = Integer.parseInt(hairdresser);

            model.addAttribute("hairdresser", hairdresserId);
            model.addAttribute("stylist", new Stylist());
            return "stylists/form";
        } catch (NumberFormatException e) {
            // Handle invalid format and log the error
            System.out.println("Invalid hairdresser ID format: " + hairdresser);
            return "redirect:/error"; // Redirect to an error page if the ID format is wrong
        }
    }


    // Add a new stylist to the specified hairdresser
    @PostMapping("/addStylist")
    public String addStylist(@Valid @ModelAttribute Stylist stylist, BindingResult result, Model model, @RequestParam int hairdresser) {

        if (result.hasErrors()) {
            model.addAttribute("hairdresser", hairdresser);
            return "stylists/form";
        }

        Hairdresser h1 = null;

        for (Hairdresser h : Hw1Application.hairdressers) {
            if (h.getId() == hairdresser) {
                h1 = h;
                break;
            }
        }

        if (h1 != null) {
            h1.getStylists().add(stylist);
        }

        return "redirect:/hairdressers";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new StylistValidator());
    }
}