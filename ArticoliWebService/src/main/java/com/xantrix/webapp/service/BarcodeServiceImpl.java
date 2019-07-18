package com.xantrix.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xantrix.webapp.entity.Barcode;
import com.xantrix.webapp.repository.BarcodeRepository;

@Service
@Transactional(readOnly = true)
public class BarcodeServiceImpl implements BarcodeService {

	@Autowired
	BarcodeRepository barcodeRepository;
	
	@Override
	public Barcode SelByBarcode(String barcode) {
		return barcodeRepository.findByBarcode(barcode);		
	}

}
