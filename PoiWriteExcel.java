package cares.cwds.salesforce.common.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PoiWriteExcel {

	    public static String filePath = "src/main/java/Artifacts/TestData/SD/ScreeningData.xlsx";
	    public static String writeSheetName = "ScreeningData";

	    public static void main(String[] args) throws IOException {
	        String[] fields = {"SCREENING_ID", "SC_TSP"};
	        String[] fieldNames = {"SCREENING_ID", "SC_TSP", "RETRIEVE_SCDATA", "RD_TSP"};
	        String screeningId = "Deve98765";
	        PoiWriteExcel ex = new PoiWriteExcel();

	        ex.writeExcelData(filePath, writeSheetName, fields, screeningId);
	        ex.getWriteScreeningId(filePath, writeSheetName, fieldNames, screeningId);
	    }

	    public void writeExcelData(String filePath, String sheetName, String[] fieldName, String fieldValue) {
	        Map<String, Integer> colByName = new HashMap<>();

	        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
	            Sheet sheet = workbook.getSheet(sheetName);

	            for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
	                colByName.put(new DataFormatter().formatCellValue(sheet.getRow(0).getCell(i)), i);
	            }
	            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

	            for (Entry<String, Integer> entry : colByName.entrySet()) {
	                if (fieldName[0].equals(entry.getKey())) {
	                    newRow.createCell(entry.getValue()).setCellValue(fieldValue);
	                } else if (fieldName[1].equals(entry.getKey())) {
	                    newRow.createCell(entry.getValue()).setCellValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));
	                }
	            }
	            try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
	                workbook.write(outputStream);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void getWriteScreeningId(String filePath, String sheetName, String[] fieldNames, String screeningId) {
	        Map<String, Integer> colByName = new HashMap<>();

	        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
	            Sheet sheet = workbook.getSheet(sheetName);

	            Row headerRow = sheet.getRow(0);

	            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	                String columnName = new DataFormatter().formatCellValue(headerRow.getCell(i));
	                colByName.put(columnName, i);
	            }

	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row currentRow = sheet.getRow(i);
	                if (currentRow != null) {
	                    String scDataValue = new DataFormatter()
	                            .formatCellValue(currentRow.getCell(colByName.get(fieldNames[2])));

	                    if (scDataValue.isEmpty()) {
	                        String getWriteScreeningId = new DataFormatter().formatCellValue(currentRow.getCell(colByName.get(fieldNames[0])));
	                       if (currentRow.getCell(colByName.get(fieldNames[2])) == null) {
	                            currentRow.createCell(colByName.get(fieldNames[2])).setCellValue("USED");
	                        } else {
	                            currentRow.getCell(colByName.get(fieldNames[2])).setCellValue("USED");
	                        }

	                        if (currentRow.getCell(colByName.get(fieldNames[3])) == null) {
	                            currentRow.createCell(colByName.get(fieldNames[3])).setCellValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));
	                        } else {
	                            currentRow.getCell(colByName.get(fieldNames[3])).setCellValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));
	                        }
	                    }
	                }
	            }

	            try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
	                workbook.write(outputStream);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

