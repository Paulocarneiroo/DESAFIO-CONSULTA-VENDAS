package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    /*
    @Query("SELECT obj.id, obj.date, obj.amount, obj.seller.name " +
            "FROM Sale obj " +
            "INNER JOIN Seller seller ON seller.id = obj.seller_id" +
            "WHERE UPPER(obj.name) " +
            "LIKE UPPER(CONCAT('%', :name '%'))")
    Page<Sale> getReportByDate(String name, Pageable pageable);

     */
    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(sale.id, sale.date, sale.amount, sale.seller.name)" +
            "FROM Sale sale" +
            "WHERE sale.seller.id = sale.seller_id")
    List<SaleMinDTO> search1(LocalDate minDate, LocalDate maxDate, String name);
}
