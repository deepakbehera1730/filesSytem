package com.pdf.excel;





import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.pdf.entity.Users;

public class ExcelImport {
	public List<Users> ExcelImport() {
		List<Users> emp = new ArrayList<>();
		int id = 0;
		String name = "";
		String email = "";
		
		String filePath = "C:\\Users\\hp\\Documents\\User.xlsx";
		long start = System.currentTimeMillis();
		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fileinput);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						id = (int) nextCell.getNumericCellValue();
						System.out.println(id);
						break;
					case 1:
						name = nextCell.getStringCellValue();
						System.out.println(name);
						break;
					case 2:
						email = nextCell.getStringCellValue();
						System.out.println(email);
						break;
				
					
					}
					emp.add(new Users(id, name, email));

				}
			}
			workbook.close();
			long end = System.currentTimeMillis();
			System.out.printf("import done", (end - start));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

}
