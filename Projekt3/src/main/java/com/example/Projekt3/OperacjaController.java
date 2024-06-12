package com.example.Projekt3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OperacjaController {
    @GetMapping("/operacja")
    public String operacjaFormularz(Model model) {
        model.addAttribute("operacja", new Operacja());
        return "operacja";
    }

    @PostMapping("/operacja")
    public String operacjaSubmit(@ModelAttribute Operacja operacja, Model model) {
        switch (operacja.getOperacja()) {
            case "dodawanie":
                operacja.setWynik(operacja.getLiczba1() + operacja.getLiczba2());
                break;
            case "odejmowanie":
                operacja.setWynik(operacja.getLiczba1() - operacja.getLiczba2());
                break;
            case "mnożenie":
                operacja.setWynik(operacja.getLiczba1() * operacja.getLiczba2());
                break;
            case "dzielenie":
                if (operacja.getLiczba2() != 0) {
                    operacja.setWynik((double) operacja.getLiczba1() / operacja.getLiczba2());
                } else {
                    operacja.setWynik(Double.NaN);  // Dzielenie przez zero
                }
                break;
        }
        model.addAttribute("operacja", operacja);
        return "operacjaWynik";
    }
}
