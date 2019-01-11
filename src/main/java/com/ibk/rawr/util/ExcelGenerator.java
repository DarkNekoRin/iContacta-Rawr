package com.ibk.rawr.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibk.rawr.entity.MaestraDataEntry;

public class ExcelGenerator {
	public static ByteArrayInputStream maestraDataEntrysToExcel(List<MaestraDataEntry> maestraData) throws IOException {
		String[] COLUMNs = {"TIPDOC","CODDOC","APE_PATERNO","APE_MATERNO",
				"PRIMER_NOMBRE","SEGUNDO_NOMBRE","NUMCELULAR1","NUMCELULAR2","NUMCELULAR3",
				"NUMTELRES1","EMAIL_01","EMAIL_02","EMAIL_03","DIRECCION",
				"DISTRITO","PROVINCIA","DEPARTAMENTO","UBIGEO","FLG_VENTA_TELF",
				"FLG_PROMO_TELF","FLG_VENTA_EMA","FLG_PROMO_EMA",
				"FLG_LPDP"};

		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
 
			Sheet sheet = workbook.createSheet("MaestraDataEntry");
			sheet.setDefaultColumnWidth(40);
	 
			
	        // create style for header cells
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        Font font = workbook.createFont();
	        font.setFontName("Arial");
	        headerCellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        font.setBold(true);
	        font.setColor(HSSFColor.WHITE.index);
	        headerCellStyle.setFont(font);
			
			
			
			
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
			int rowIdx = 1;
			for (MaestraDataEntry maestraDataEntry : maestraData) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(maestraDataEntry.getTipoDocumento());
				row.createCell(1).setCellValue(maestraDataEntry.getDocumento());
				row.createCell(2).setCellValue(maestraDataEntry.getApePaterno());
				row.createCell(3).setCellValue(maestraDataEntry.getApeMaterno());
				row.createCell(4).setCellValue(maestraDataEntry.getPrimerNombre());
				row.createCell(5).setCellValue(maestraDataEntry.getSegundoNombre());
				row.createCell(6).setCellValue(maestraDataEntry.getNumCelular1());
				row.createCell(7).setCellValue(maestraDataEntry.getNumCelular2());
				row.createCell(8).setCellValue(maestraDataEntry.getNumCelular3());
				row.createCell(9).setCellValue(maestraDataEntry.getNumTelefono());
				row.createCell(10).setCellValue(maestraDataEntry.getEmail1());
				row.createCell(11).setCellValue(maestraDataEntry.getEmail2());
				row.createCell(12).setCellValue(maestraDataEntry.getEmail3());
				row.createCell(13).setCellValue(maestraDataEntry.getDireccion());
				row.createCell(14).setCellValue(maestraDataEntry.getDistrito());
				row.createCell(15).setCellValue(maestraDataEntry.getProvincia());
				row.createCell(16).setCellValue(maestraDataEntry.getDepartamento());
				row.createCell(17).setCellValue(maestraDataEntry.getUbigeo());
				row.createCell(18).setCellValue(maestraDataEntry.getFlgVentaTelefono());
				row.createCell(19).setCellValue(maestraDataEntry.getFlgPromoVentaTelefono());
				row.createCell(20).setCellValue(maestraDataEntry.getFlgVentaEmail());
				row.createCell(21).setCellValue(maestraDataEntry.getFlgPromoEmail());
				
//				row.createCell(18).setCellValue((maestraDataEntry.getFlgVentaTelefono()==null)?"":(maestraDataEntry.getFlgVentaTelefono()?"SI":"NO"));
	//			row.createCell(19).setCellValue((maestraDataEntry.getFlgPromoVentaTelefono()==null)?"":(maestraDataEntry.getFlgPromoVentaTelefono()?"SI":"NO")); 
			//	row.createCell(20).setCellValue((maestraDataEntry.getFlgVentaEmail()==null)?"":(maestraDataEntry.getFlgVentaEmail()?"SI":"NO"));
			//	row.createCell(21).setCellValue((maestraDataEntry.getFlgPromoEmail()==null)?"":(maestraDataEntry.getFlgPromoEmail()?"SI":"NO"));
				
				
				row.createCell(22).setCellValue(maestraDataEntry.getFlgLpd());
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}
