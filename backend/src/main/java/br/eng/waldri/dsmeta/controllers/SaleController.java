package br.eng.waldri.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.eng.waldri.dsmeta.entities.Sale;
import br.eng.waldri.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public Page<Sale> findSale(
			@RequestParam(value="minDate", defaultValue = "")
			String minDate, 
			@RequestParam(value="maxDate", defaultValue = "")
			String maxDate, 
			Pageable pageable){
		return service.findSale(minDate, maxDate, pageable);
	}
}
