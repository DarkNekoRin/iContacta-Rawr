package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.MaestraDataEntry;

public interface MaestraDataEntryService {
    public List<MaestraDataEntry> listar();
    public List<MaestraDataEntry> listarPorIdSolicitud(String idSolicitud);
    
}
