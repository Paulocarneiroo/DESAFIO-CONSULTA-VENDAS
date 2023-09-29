package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.projections.SaleMinProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner {

	private SaleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate minDate = LocalDate.parse("2022-05-01");
		LocalDate maxDate = LocalDate.parse("2022-05-31");
		List<SaleMinDTO> list = repository.search1(minDate, maxDate, "odin");

		System.out.println("\n***RESULTADO JPQL:");
		for (SaleMinDTO obj : list){
			System.out.println(obj);
		}
		System.out.printf("\n\n");
	}
}
