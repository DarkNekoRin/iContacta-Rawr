package com.ibk.rawr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibk.rawr.entity.MaestraDataEntry;
import com.ibk.rawr.repository.MaestraDataEntryRepository;
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
		return maestraDataEntryRepository.findByIdSolicitudOrderById(idSolicitud);
	}

	@Override
	public List<MaestraDataEntry> listarTo10PorIdSolicitud(String idSolicitud) {
		return  maestraDataEntryRepository.findTop10ByIdSolicitudOrderById(idSolicitud);
	}
	

    
}
