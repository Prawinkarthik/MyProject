package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSF_File_Reader {

	static String value;

	public static String fileReaderSingleData(String name, int rowNo, int cellNo) throws IOException {
			File f = new File("C:\\Users\\k\\eclipse-workspace\\IPT_Datadriven\\Data_Driven\\IPT_DataDriven.xlsx");

		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);

		Sheet s = w.getSheet(name);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);

		CellType cel = c.getCellType();
		System.out.println("*****Single Data*****");
		if (cel.equals(CellType.STRING)) {
			value = c.getStringCellValue();

		} else if (cel.equals(CellType.NUMERIC)) {
			double numericValue = c.getNumericCellValue();
			int n = (int) numericValue;// narrowing
			value = String.valueOf(n);
			

		}

		w.close();
		return value;
	}

	public static void fileReaderAllData() throws IOException {
		File f = new File("C:\\Users\\k\\eclipse-workspace\\IPT_Datadriven\\Data_Driven\\IPT_DataDriven.xlsx");

		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		System.out.println("*****All Data*****");
		Sheet s = w.getSheet("Cars");
		int numberOfRows = s.getPhysicalNumberOfRows();
		for (int i = 0; i < numberOfRows; i++) {
			Row r = s.getRow(i);
			int numberOfCells = r.getPhysicalNumberOfCells();
			for (int j = 0; j < numberOfCells; j++) {
				Cell c = r.getCell(j);

				CellType cel = c.getCellType();

				if (cel.equals(CellType.STRING)) {
					String stringValue = c.getStringCellValue();

					System.out.print(stringValue);
				} else if (cel.equals(CellType.NUMERIC)) {
					double numericValue = c.getNumericCellValue();
					int n = (int) numericValue;

					System.out.print("|" + n);
				}
				System.out.print("\t" + "|");
			}
			System.out.println();

		}

	}

	public static void main(String[] args) throws IOException {
		//fileReaderSingleData(value, 0, 0)
		fileReaderAllData();

	}

}
