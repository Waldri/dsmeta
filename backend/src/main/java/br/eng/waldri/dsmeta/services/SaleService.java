package br.eng.waldri.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eng.waldri.dsmeta.entities.Sale;
import br.eng.waldri.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSale() {
		return repository.findAll();
	}
}
