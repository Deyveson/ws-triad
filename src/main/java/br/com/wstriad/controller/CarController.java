package br.com.wstriad.controller;


import br.com.wstriad.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

@RestController
@RequestMapping(value = "/parking")
public class CarController {

    @Autowired
    private AluguelService service;

    @RequestMapping(value = "/entrada", method = RequestMethod.POST)
    public String createVoucher(@RequestParam(value = "placa", defaultValue = "", required = false) String palca,
                                @RequestParam(value = "horario", defaultValue = "", required = false) String horario,
                                @RequestParam(value = "modelo", defaultValue = "", required = false) String modelo){
        return service.createVouche(palca, horario, modelo);
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
