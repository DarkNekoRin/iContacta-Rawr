package com.ibk.rawr.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibk.rawr.entity.DataEntry;
import com.ibk.rawr.repository.DataEntyRepository;
@Service
public class DataEntryServiceImpl implements DataEntryService{

	@Autowired
	private DataEntyRepository dataEntyRepository;
	
	@Override
	public void save(DataEntry dataEntry) {
		dataEntyRepository.save(dataEntry);
		
	}

	@Override
	public void saveIterable(Iterable<DataEntry> iteralbleDataEntry) {
		dataEntyRepository.save(iteralbleDataEntry);
	}

	@Override
	public void ejecutarEtl(String idSolicitud) {
		dataEntyRepository.ejecutarEtl(idSolicitud);		
	}

	@Override
	public File generarCTL(File pathTXT) {
		String ctl="OPTIONS (SKIP=1)\n" + 
				"Load DATA \n" + 
				"infile '"+pathTXT.getName()+"'\n" + 
				"TRUNCATE \n" + 
				"PRESERVE BLANKS\n" + 
				"INTO TABLE DGOV_DATAENTRY_TMP\n" + 
				"fields terminated by \"|\"\n" + 
				"TRAILING NULLCOLS\n" + 
				"(\n" + 
				"TIPDOC  ,   \n" + 
				"CODDOC ,  \n" + 
				"FLG_DIRECCION ,   \n" + 
				"FLG_EMAIL  ,  \n" + 
				"FLG_TELEFONO ,  \n" + 
				"USU_SOLICITUD  ,\n" + 
				"ID_SOLICITUD \n" + 
				")";
		File fileCtl=new File(pathTXT.getParent()+File.separator+pathTXT.getName().replace(".txt", ".CTL"));
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileCtl));
			writer.write(ctl);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileCtl;
	}
}
