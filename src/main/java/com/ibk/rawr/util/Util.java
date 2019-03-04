package com.ibk.rawr.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Util {
	public static String cambiarFormatoFechaString(String formatoIni, String formatoFinal, String fecha) {
		SimpleDateFormat fromUser = new SimpleDateFormat(formatoIni);
		SimpleDateFormat myFormat = new SimpleDateFormat(formatoFinal);
		String fechaFin = null;
		try {

			fechaFin = myFormat.format(fromUser.parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaFin;
	}

	public static String fechaToString(Date fecha, String formato) {
		SimpleDateFormat fromUser = new SimpleDateFormat(formato);
		String fechaFin = null;
		try {
			fechaFin = fromUser.format(fecha);
		} catch (Exception e) {
			return null;
		}

		return fechaFin;
	}
	public static int ejecutarBat(List<String> listComan) {
//		listComan=new ArrayList<>();
//		listComan.add("D:\\temp\\IBK_CRM_CARGA_JSON_VENTAS.bat");
//		listComan.add("ventasB3475720190304172724.CTL");
//		listComan.add("ventasB3475720190304172724.log");
//		listComan.add("D:\\temp\\ventasB3475720190304172724.txt");
		int result=-1;
		ProcessBuilder processBuilder = new ProcessBuilder(listComan);						
	        try {

	            Process process = processBuilder.start();

	            StringBuilder output = new StringBuilder();

	            BufferedReader reader = new BufferedReader(
	                    new InputStreamReader(process.getInputStream()));

	            String line;
	            while ((line = reader.readLine()) != null) {
	                output.append(line + "\n");
	            }

	            int exitVal = process.waitFor();
	            if (exitVal == 0) {
	                System.out.println(output);
//	                System.exit(0);
	            } else {
	                //abnormal...
	            }
	            result=exitVal;
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return result;
	}
}
