package com.ibk.rawr.service;

import com.ibk.rawr.entity.DataEntry;

public interface DataEntryService {
    void save(DataEntry dataEntry);
    void saveIterable(Iterable<DataEntry> iteralbleDataEntry);
    void ejecutarEtl(String idSolicitud);
}
