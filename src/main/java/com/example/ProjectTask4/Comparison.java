package com.example.ProjectTask4;

import org.springframework.stereotype.Service;

@Service
public class Comparison {
    // compare
    public String Compare(double firstvalue, double secondvalue, String firstname, String secondname, String attribute) {

        if (firstvalue > secondvalue) {
            return firstname + " has more " + attribute + " than " + secondname;
        } else if (firstvalue < secondvalue) {
            return secondname + " has more " + attribute + " than " + firstname;
        } else {
            return "Both phones are equal.";
        }
    }
}