import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Stoixeia {
	
	
	public List<String> stoixeiaCheck() {
		Main main = new Main();
		Scanner scanner = new Scanner (System.in, "UTF-8"); 
		List<String> errorList = new ArrayList<>();
		List<String> secondElements = new ArrayList<>();
		int emptyLineCount = 0;
		
		{
			errorList.add("0");
			System.out.println("\nPaste the Credentials of the Volunteer:\n(Press Enter THREE TIMES Afterwards.)");
	        
	        // Read lines and store each line in the matrix list until an empty line is encountered
	        while (true) {
	            String line = scanner.nextLine().trim();
	            if (line.isEmpty()) {
	                emptyLineCount++;

	                // Break if two consecutive empty lines are encountered
	                if (emptyLineCount == 2) {
	                    break;
	                }
	            } else {
	                emptyLineCount = 0; // Reset the count if a non-empty line is encountered
	            // Split each line into two parts (name and value) using the colon (:) as a delimiter
	            String[] parts = line.split(":\\s+"); // parts είναι σε πόσα κομμάτια έχουν χωριστεί οι γραμμες
	            if (parts.length == 2) {
	            	String value = parts[1].trim();
	               secondElements.add(value);
	            	} 
	            		else if(parts.length == 1) {
	            		secondElements.add("");
	            	}
	            		else {
	            			System.out.println("\nThe format you entered is WRONG.");
	            			return errorList;
	            		}
	            	}
	        }	        	
				System.out.println("\nThe insertion of the credentials has been completed.");
				
				 String filePath = "Stoixeia_Euelonton_Doton.xlsx";

			        // Check if the file exists
			        File file = new File(filePath);
			        Workbook workbook;
				
				if(!file.exists()) {
					
				 workbook = new XSSFWorkbook();
		            Sheet sheet = workbook.createSheet(""+ main.month);

		            // Create a row and add some cells
		            Row headerRow = sheet.createRow(0);
		            headerRow.createCell(0).setCellValue("Email");
		            headerRow.createCell(1).setCellValue("Όνομα");
		            headerRow.createCell(2).setCellValue("Επίθετο");
		            headerRow.createCell(3).setCellValue("Τηλέφωνο");
		            headerRow.createCell(4).setCellValue("Διεύθυνση");
		            headerRow.createCell(5).setCellValue("Περιοχή");
		            headerRow.createCell(6).setCellValue("Ταχυδρομικός Κώδικας");
		            headerRow.createCell(7).setCellValue("Μήνυμα");
		            headerRow.createCell(8).setCellValue("Ημερομηνία");
		            
		            for (int num_of_Rows=1;num_of_Rows < 10000;num_of_Rows++) 
		            {
		            	
		            	Row dataRow = sheet.createRow(num_of_Rows);
		            		if(!hasDataInRowWithoutChanging(dataRow)) {
		            			for(int num_of_Cells=0;num_of_Cells<=7;num_of_Cells++) 
		                		{
		            				String element = "";
		            				element = secondElements.get(num_of_Cells);
		            				dataRow.createCell(num_of_Cells).setCellValue(""+element);
		            				
		                		}
		            			dataRow.createCell(8).setCellValue(""+ main.date);
		            			break;
		            			}
		            		
		            			
		            		}
		            
		            
				
		            
		            // Write the workbook to a file
		            try (FileOutputStream fileOut = new FileOutputStream("Stoixeia_Euelonton_Doton.xlsx")) {
		                workbook.write(fileOut);
		                System.out.println("\nThe Excel has been Created Successfully!");
		                System.out.println("\nFile Path: " + new File("Stoixeia_Euelonton_Doton.xlsx").getAbsolutePath());
		                
		            }
		         catch (IOException e) {
		            e.printStackTrace();
		        }
		        
				return secondElements;

				}
				else {//if we have to write over the existing file
										
					try (FileInputStream fileInputStream = new FileInputStream(file)) {
		                workbook = WorkbookFactory.create(fileInputStream, "UTF-8");
		                
		                
						Sheet sheet = workbook.getSheet(""+ main.month);
						if(sheet != null) {//elegxo an exv idio mhna
							for (int num_of_Rows=1;num_of_Rows < 10000;num_of_Rows++) 
			            {
			            	
			            	Row dataRowCheck2_1 = sheet.getRow(num_of_Rows);
			            		if(!hasDataInRowWithoutChanging(dataRowCheck2_1)) {//elegxo an DEN exo grapsei idi se kapoia grammh gia na mhn grapso apo pano ths
			            			Row dataRow = sheet.createRow(num_of_Rows);
			            			for(int num_of_Cells=0;num_of_Cells<=7;num_of_Cells++) 
			                		{
			            				String element = "";
			            				element = secondElements.get(num_of_Cells);
			            				dataRow.createCell(num_of_Cells).setCellValue(""+element);
			                		}
			            			dataRow.createCell(8).setCellValue(""+ main.date);
			            			break;
			            			}
			            		
			            		}
							
						try (FileOutputStream fileOut = new FileOutputStream(file)) {
			                workbook.write(fileOut);
			                System.out.println("\nThe Excel has been Updated Successfully!");
			                
			            }
						catch (IOException e) {
							e.printStackTrace();
							}
						
						workbook.close();
						}
						else {//if the month is different then we go to the next sheet
							
							Sheet sheet1 = workbook.createSheet(""+ main.month);

				            // Create a row and add some cells
				            Row headerRow = sheet1.createRow(0);
				            headerRow.createCell(0).setCellValue("Email");
				            headerRow.createCell(1).setCellValue("Όνομα");
				            headerRow.createCell(2).setCellValue("Επίθετο");
				            headerRow.createCell(3).setCellValue("Τηλέφωνο");
				            headerRow.createCell(4).setCellValue("Διεύθυνση");
				            headerRow.createCell(5).setCellValue("Περιοχή");
				            headerRow.createCell(6).setCellValue("Ταχυδρομικός Κώδικας");
				            headerRow.createCell(7).setCellValue("Μήνυμα");
				            headerRow.createCell(8).setCellValue("Ημερομηνία");
							
							for (int num_of_Rows=1;num_of_Rows < 10000;num_of_Rows++) 
								{
			            	
			            	Row dataRowCheck2_2 = sheet1.getRow(num_of_Rows);
			            	
			            		if(!hasDataInRowWithoutChanging(dataRowCheck2_2)) {//elegxo an DEN exo grapsei idi se kapoia grammh gia na mhn grapso apo pano ths
			            			
			            			Row dataRow = sheet1.createRow(num_of_Rows);
			            			
			            			for(int num_of_Cells=0;num_of_Cells<=7;num_of_Cells++) 
			                		{
			            				String element = "";
			            				element = secondElements.get(num_of_Cells);
			            				dataRow.createCell(num_of_Cells).setCellValue(""+element);
			                		}
			            			dataRow.createCell(8).setCellValue(""+ main.date);
			            			break;
			            			}
			            		
			            			
			            		}
							
						try (FileOutputStream fileOut = new FileOutputStream(file)) {
			                workbook.write(fileOut);
			                System.out.println("\nThe Excel has been Updated Successfully!");
			                
			            }
						catch (IOException e) {
							e.printStackTrace();
							}
						
						workbook.close();}
						
					}
					
					catch (IOException e) {
			            e.printStackTrace();
			        }
					
					
					 return secondElements;
				}
				
		}
		
	}
	

	
	private static boolean hasDataInRowWithoutChanging(Row dataRow) {
		if(dataRow!= null) {
        for (int cellNum = dataRow.getFirstCellNum(); cellNum < dataRow.getLastCellNum(); cellNum++) {
            Cell cell = dataRow.getCell(cellNum);
        	
        	if (cell != null || cell.getCellType() != CellType.BLANK || !cell.toString().trim().isEmpty()) {
                return true; // The row has at least one non-empty cell
            }
        }
        return false; // All cells in the row are empty
		}
		else return false;
	}
	
	
}
