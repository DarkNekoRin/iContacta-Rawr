package com.hellokoding.auth.service;

import com.hellokoding.auth.model.DataEntry;

public interface DataEntryService {
    void save(DataEntry dataEntry);
    void saveIterable(Iterable<DataEntry> iteralbleDataEntry);
}
