package cares.cwds.salesforce.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiWriteExcel {
	
	
			private PoiWriteExcel() {
				// this is empty
			}
			private static final Logger logger = Logger.getLogger(PoiReadExcel.class.getName());
			
			public static void main(String[] args) {
				
				try (
						FileInputStream file = new FileInputStream(new File("src/main/java/Artifacts/TestData/SD/ScreeningData.xlsx"));
						 XSSFWorkbook workbook = new XSSFWorkbook(file)) {
						XSSFSheet sheet = workbook.getSheet("ScreeningData");
						int rowNum = sheet.getLastRowNum()+1;
						int cellNum = sheet.getRow(0).getLastCellNum();
						
						Map<String, Integer> colByName = new HashMap<>();
						if(sheet.getRow(0).cellIterator().hasNext()) {
							for (int i = 0; i < cellNum; i++) {
								colByName.put(new DataFormatter().formatCellValue(sheet.getRow(0).getCell(i)).toString(), i);
							}
						}
						Cell cell = sheet.getRow(1).getCell(0);
						cell.setCellValue("Ajay1234");
						
//						for (int j = 0; j <cellNum; j++) {
//							cell = sheet.getRow(rowNum).getCell(j);
//							if(colByName.get("SCREEENING_ID") == j) {
//								cell.setCellValue("Ajay");
//							}
//							else if(colByName.get("SC_TSP")== j) {
//								cell.setCellValue(LocalDateTime.now());
//							}
//						}
						file.close();
						
						FileOutputStream output = new FileOutputStream(new File("src/main/java/Artifacts/TestData/SD/ScreeningData.xlsx"));
						workbook.write(output);
						output.close();
						
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
}
