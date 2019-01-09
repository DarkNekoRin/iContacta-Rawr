package com.ibk.rawr.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ibk.rawr.entity.DataEntry;

public interface DataEntyRepository extends JpaRepository<DataEntry, Long> {
	@Transactional
    @Procedure(procedureName = "SP_DGOV_DATA_ENTRY")
    void ejecutarEtl(@Param("P_ID_SOLICITUD") String idSolicitud);
}
