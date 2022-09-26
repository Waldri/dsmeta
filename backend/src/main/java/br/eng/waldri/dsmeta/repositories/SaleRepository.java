package br.eng.waldri.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eng.waldri.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
