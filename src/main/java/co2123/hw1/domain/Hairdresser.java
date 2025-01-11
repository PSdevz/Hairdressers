package co2123.hw1.domain;

import java.util.ArrayList;
import java.util.List;
public class Hairdresser {
    private int id;
    private String speciality;
    private String city;
    private List<Stylist> stylists = new ArrayList<>();


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String getSpeciality() {
        return speciality;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }


    public void setStylists(List<Stylist> stylists) {
        this.stylists = stylists;
    }

    public List<Stylist> getStylists() {
        return stylists;
    }
}
