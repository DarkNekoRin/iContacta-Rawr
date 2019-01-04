package com.hellokoding.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.MaestraDataEntry;
import com.hellokoding.auth.repository.MaestraDataEntryRepository;
@Service
public class MaestraDataEntryServiceImpl implements MaestraDataEntryService{

	@Autowired
	private MaestraDataEntryRepository maestraDataEntryRepository;

	@Override
	public List<MaestraDataEntry> listar() {
		return maestraDataEntryRepository.findAll();
	}

	@Override
	public List<MaestraDataEntry> listarPorIdSolicitud(String idSolicitud) {
		return maestraDataEntryRepository.findByIdSolicitud(idSolicitud);
	}
	

    
}
