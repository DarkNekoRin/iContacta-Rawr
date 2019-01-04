package com.hellokoding.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.DataEntry;
import com.hellokoding.auth.repository.DataEntyRepository;
@Service
public class DataEntryServiceImpl implements DataEntryService{

	@Autowired
	private DataEntyRepository dataEntyRepository;
	
	@Override
	public void save(DataEntry dataEntry) {
		dataEntyRepository.save(dataEntry);
		
	}

	@Override
	public void saveIterable(Iterable<DataEntry> iteralbleDataEntry) {
		dataEntyRepository.save(iteralbleDataEntry);
	}

	@Override
	public void ejecutarEtl(String idSolicitud) {
		dataEntyRepository.ejecutarEtl(idSolicitud);		
	}
}
