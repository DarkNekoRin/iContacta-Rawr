package com.hellokoding.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.DataEntry;

public interface DataEntyRepository extends JpaRepository<DataEntry, Long> {
   
}
