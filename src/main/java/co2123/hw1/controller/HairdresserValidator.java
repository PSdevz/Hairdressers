package co2123.hw1.controller;

import co2123.hw1.domain.Hairdresser;
import co2123.hw1.Hw1Application;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;


public class HairdresserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Hairdresser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Hairdresser hairdresser = (Hairdresser) target;

        // Validate id is unique
        for (Hairdresser existing : Hw1Application.hairdressers) {
            if (existing.getId() == hairdresser.getId()) {
                errors.rejectValue("id", "unique", "ID must be unique.");
                break;
            }
        }

        // Validate speciality is not empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "speciality", "",
                "Speciality must not be empty.");

        // Validate city is not empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "",
                "Your city needs a name!");
    }
}
