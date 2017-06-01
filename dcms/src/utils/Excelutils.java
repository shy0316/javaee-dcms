package utils;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import com.nxdcms.entity.Subcompetition;

public class Excelutils {
	public static void export(List<Subcompetition> list,Workbook wb){
		int rowIndex=0;
		org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet();
		java.util.Iterator<Subcompetition> it = list.iterator();
		org.apache.poi.ss.usermodel.Row row;
		while (it.hasNext()) {
			row=sheet.createRow(rowIndex++);
			Cell cell=row.createCell(0);
			Subcompetition subcompetition = it.next();
			//System.out.println(subcompetition.getId());
			cell.setCellValue(subcompetition.getCollege());
			
			cell=row.createCell(1);
			cell.setCellValue(subcompetition.getSubcompid());
		}
	}
}
