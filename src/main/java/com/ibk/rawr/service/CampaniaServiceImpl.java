package com.ibk.rawr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibk.rawr.entity.Campania;
import com.ibk.rawr.repository.CampaniaRepository;
@Service
public class CampaniaServiceImpl implements CampaniaService{

	@Autowired
	private CampaniaRepository campaniaRepository;

	@Override
	public List<Campania> listar() {		
		return campaniaRepository.findAll();
	}


    
}
