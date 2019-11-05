package br.com.wstriad.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parking")
public class CarController {

    @RequestMapping(value = "/entrada", method = RequestMethod.POST)
    public String createVoucher() {
        return "Entrada";
    }

    @RequestMapping(value = "/saida", method = RequestMethod.GET)
    public String payVoucher() {
        return "Saida";
    }

    @RequestMapping(value = "/faturamento", method = RequestMethod.GET)
    public String dailyBilling() {
        return "Faturamento";
    }

}
