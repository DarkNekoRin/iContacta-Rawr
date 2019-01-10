package com.ibk.rawr.service;

import java.util.List;

import com.ibk.rawr.entity.MaestraDataEntry;

public interface MaestraDataEntryService {
    public List<MaestraDataEntry> listar();
    public List<MaestraDataEntry> listarTo10PorIdSolicitud(String idSolicitud);
    public List<MaestraDataEntry> listarPorIdSolicitud(String idSolicitud);
    
}
