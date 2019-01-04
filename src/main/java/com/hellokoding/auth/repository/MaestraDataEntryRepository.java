package com.hellokoding.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.MaestraDataEntry;

public interface MaestraDataEntryRepository extends JpaRepository<MaestraDataEntry, Long> {
	public List<MaestraDataEntry> findByIdSolicitud(String idSolicitud);
}
