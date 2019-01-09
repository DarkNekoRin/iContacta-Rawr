package com.ibk.rawr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibk.rawr.entity.MaestraDataEntry;

public interface MaestraDataEntryRepository extends JpaRepository<MaestraDataEntry, Long> {
	public List<MaestraDataEntry> findTop10ByIdSolicitudOrderById(String idSolicitud);
}
