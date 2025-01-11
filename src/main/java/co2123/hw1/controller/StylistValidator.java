package co2123.hw1.controller;

import co2123.hw1.domain.Stylist;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StylistValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Stylist.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Stylist stylist = (Stylist) target;

        // Validate name is not empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
                "The stylist needs a name!");

        // Validate skills is not empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skills", "",
                "Skills must not be empty!");

        // Validate expertise is either "Undercut", "Mullet", or "Perm"
        if (stylist.getExpertise() == null || !stylist.getExpertise().matches("Undercut|Mullet|Perm")) {
            errors.rejectValue("expertise", "invalid", "Expertise must be 'Undercut', 'Mullet', or 'Perm'.");
        }

        // Validate price is between 30 and 400
        if (stylist.getPrice() < 30 || stylist.getPrice() > 400) {
            errors.rejectValue("price", "range", "Price must be between 30 and 400.");
        }
    }
}
