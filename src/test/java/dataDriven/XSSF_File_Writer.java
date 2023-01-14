package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSF_File_Writer {

	public static void fileWriter() throws IOException {

		File f = new File("C:\\Users\\k\\OneDrive\\Desktop\\IPT_DataDriven.xlsx");
		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.createSheet("Animals");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("Wild");
		w.getSheet("Animal").getRow(0).createCell(2);
		c.setCellValue("Domestic");
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		w.close();
	}
	
	
	public static void main(String args[]) throws IOException {
		fileWriter();
		
		System.out.println("Write Operation Completed...!");
		System.out.println("Check the file...");
	}
}
