package co2123.hw1;

import co2123.hw1.domain.Hairdresser;
import co2123.hw1.domain.Stylist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Hw1Application {

    public static List<Hairdresser> hairdressers = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);

        Hairdresser hairdresser1 = new Hairdresser();
        hairdresser1.setId(1);
        hairdresser1.setSpeciality("Coloring");
        hairdresser1.setCity("Leicester");

        Stylist stylist1 = new Stylist();
        stylist1.setName("Mark");
        stylist1.setExpertise("All type of cuttings");
        stylist1.setSkills("Highlighting");
        stylist1.setPrice(300);
        hairdresser1.getStylists().add(stylist1);


        Stylist stylist2 = new Stylist();
        stylist2.setName("Jack");
        stylist2.setExpertise("Undercut");
        stylist2.setSkills("Smoothing");
        stylist2.setPrice(200);
        hairdresser1.getStylists().add(stylist2);

        Hw1Application.hairdressers.add(hairdresser1);


    }

}
