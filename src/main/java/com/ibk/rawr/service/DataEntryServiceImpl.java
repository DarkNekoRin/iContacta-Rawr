package com.ibk.rawr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibk.rawr.entity.DataEntry;
import com.ibk.rawr.repository.DataEntyRepository;
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
