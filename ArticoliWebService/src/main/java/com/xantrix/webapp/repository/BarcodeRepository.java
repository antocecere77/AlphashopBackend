package com.xantrix.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xantrix.webapp.entity.Barcode;

public interface BarcodeRepository extends JpaRepository<Barcode, String> {
	
	Barcode findByBarcode(String barcode);

}
