package br.eng.waldri.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.eng.waldri.dsmeta.entities.Sale;
import br.eng.waldri.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSale(String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
	}
}
