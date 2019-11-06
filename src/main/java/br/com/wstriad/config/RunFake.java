package br.com.wstriad.config;

import br.com.wstriad.domain.RegraPreco;
import br.com.wstriad.repository.RegraPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RunFake implements CommandLineRunner {

    @Autowired
    RegraPrecoRepository precoRepository;

    @Override
    public void run(String... args) throws Exception {

        List<RegraPreco> list  = Arrays.asList(
                new RegraPreco("Segunda - Sexta", "08:00 as 12:00", 2.00),
                new RegraPreco("Segunda - Sexta", "12:01 as 18:00", 3.00),
                new RegraPreco("Sábado e domingo", "08:00 as 18:00", 2.50));

        precoRepository.saveAll(list);

    }
}
