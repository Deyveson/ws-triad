package br.com.wstriad.service.impl;

import br.com.wstriad.service.AluguelService;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service(value = "AluguelService")
public class AluguelServiceimpl implements AluguelService {

    @Override
    public String createVouche(String palca, String horario, String modelo){
        return "Placa:" + palca + " Horario:" + horario + " Modelo:" + modelo;
    }

}
