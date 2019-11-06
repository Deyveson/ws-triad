package br.com.wstriad.service.impl;

import br.com.wstriad.domain.RegraPreco;
import br.com.wstriad.domain.Veiculo;
import br.com.wstriad.domain.Voucher;
import br.com.wstriad.repository.RegraPrecoRepository;
import br.com.wstriad.repository.VeiculoRespository;
import br.com.wstriad.repository.VoucherRepository;
import br.com.wstriad.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service(value = "AluguelService")
public class AluguelServiceimpl implements AluguelService {

	@Autowired
	RegraPrecoRepository precoRepository;

	@Autowired
	VeiculoRespository veiculoRespository;

	@Autowired
	VoucherRepository voucherRepository;

	@Override
	public Voucher createVouche(String placa, String modelo, String cor) {

		Veiculo veiculo = new Veiculo();
		
		Voucher voucher = new Voucher();
		Date dataAtual = new Date();

		voucher.setEntrada(dataAtual);
		voucher.setVeiculo(veiculo);
		voucherRepository.save(voucher);
		
		veiculo = saveVeiculo(placa, modelo, cor, voucher);

		return voucher;
	}

	public Veiculo saveVeiculo(String placa, String modelo, String cor, Voucher voucher) {

		Veiculo veiculo = new Veiculo();

		veiculo.setPlaca(placa);
		veiculo.setModelo(modelo);
		veiculo.setCor(cor);
		veiculo.setVoucher(voucher);
		

		veiculoRespository.save(veiculo);

		return veiculo;
	};

	@Override
	public Voucher payVoucher(Long vouche) {

		Voucher voucher;
		Date dataAtual = new Date();
		List<RegraPreco> regraPrecos;
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		voucher = voucherRepository.findById(vouche).orElseThrow(() -> 
		new EntityNotFoundException("CHORA"));
		
		regraPrecos = precoRepository.findAll();
		
		voucher.setSaida(dataAtual);
		
		regraPrecos.forEach(regraPreco -> {
			
			System.out.println("Dia: " + regraPreco.getDias() + "/ Valor:" + regraPreco.getValor());
			System.out.println("Dia Atual: " + gc.get(Calendar.DAY_OF_WEEK));
			
		});
		
		return voucher;
	};
}
