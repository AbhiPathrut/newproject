package com.sogeti.automation.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ExcelReader {
	
//  protected String filePath;
//  protected String sheetName;
//  protected String valueColumnName;
//  protected int valueColumn;
//  protected HashMap<String, String> map;
//
//  public ExcelReader(String sheetName) throws IOException {
//      this.filePath = System.getProperty("user.dir") + File.separator + PropertyReader.getFieldValue("testDataFilePath");
//      this.sheetName = sheetName;
//      this.valueColumnName = null;
//      this.setMap();
//  }
//
//  public ExcelReader(String sheetName, String valueColumnName) throws IOException {
//      this.filePath = System.getProperty("user.dir") + File.separator + PropertyReader.getFieldValue("testDataFilePath");
//      this.sheetName = sheetName;
//      this.valueColumnName = valueColumnName;
//      this.setMap();
//  }
//
//  public String getFilePath() {
//      return this.filePath;
//  }
//
//  public String getSheetName() {
//      return this.sheetName;
//  }
//
//  public String getValueColumnName() {
//      return this.valueColumnName;
//  }
//
//  public String getURL(String environmentName) throws IOException {
//      String url = null;
//      if (environmentName == null) {
//          return null;
//      } else {
//          FileInputStream file = new FileInputStream(this.filePath);
//
//          try (Workbook book = WorkbookFactory.create(file)) {
//              Sheet sheet = book.getSheet("EnvironmentInfo");
//              DataFormatter fmt = new DataFormatter();
//
//              for (int i = 1; i <= sheet.getLastRowNum(); ++i) {
//                  String rowEnvironmentName;
//                  String rowUrl;
//                  try {
//                      Row row = sheet.getRow(i);
//                      rowEnvironmentName = fmt.formatCellValue(row.getCell(0));
//                      rowUrl = fmt.formatCellValue(row.getCell(1));
//                  } catch (NullPointerException npe) {
//                      continue;
//                  }
//                  rowEnvironmentName = rowEnvironmentName.trim();
//                  rowUrl = rowUrl.trim();
//                  if (rowEnvironmentName.contentEquals(environmentName)) {
//                      url = rowUrl;
//                      break;
//                  }
//              }
//          }
//
//          file.close();
//
//          return url;
//      }
//  }
//
//  public String getUserName(String userType, String environmentName) throws IOException {
//      String userName = null;
//
//      if (userType != null && environmentName != null) {
//          FileInputStream file = new FileInputStream(this.filePath);
//
//          try (Workbook book = WorkbookFactory.create(file)) {
//              Sheet sheet = book.getSheet("userInfo");
//              DataFormatter fmt = new DataFormatter();
//
//              for (int i = 1; i <= sheet.getLastRowNum(); ++i) {
//                  String rowUserType;
//                  String rowEnvironmentName;
//                  String rowUserName;
//                  try {
//                      Row row = sheet.getRow(i);
//                      rowUserType = fmt.formatCellValue(row.getCell(0));
//                      rowEnvironmentName = fmt.formatCellValue(row.getCell(1));
//                      rowUserName = fmt.formatCellValue(row.getCell(2));
//                  } catch (NullPointerException npe) {
//                      continue;
//                  }
//
//                  rowUserType = rowUserType.trim();
//                  rowEnvironmentName = rowEnvironmentName.trim();
//                  rowUserName = rowUserName.trim();
//
//                  if (rowUserType.contentEquals(userType) && rowEnvironmentName.contentEquals(environmentName)) {
//                      userName = rowUserName;
//                      break;
//                  }
//              }
//          }
//
//          file.close();
//          return userName;
//      } else {
//          return null;
//      }
//  }
//
//  public String getPassword(String userType, String environmentName) throws IOException {
//      String password = null;
//
//      if (userType != null && environmentName != null) {
//          FileInputStream file = new FileInputStream(this.filePath);
//
//          try (Workbook book = WorkbookFactory.create(file)) {
//              Sheet sheet = book.getSheet("userInfo");
//              DataFormatter fmt = new DataFormatter();
//
//              for (int i = 1; i <= sheet.getLastRowNum(); ++i) {
//                  String rowUserType;
//                  String rowEnvironmentName;
//                  String rowPassword;
//
//                  try {
//                      Row row = sheet.getRow(i);
//                      rowUserType = fmt.formatCellValue(row.getCell(0));
//                      rowEnvironmentName = fmt.formatCellValue(row.getCell(1));
//                      rowPassword = fmt.formatCellValue(row.getCell(3));
//                  } catch (NullPointerException npe) {
//                      continue;
//                  }
//
//                  rowUserType = rowUserType.trim();
//                  rowEnvironmentName = rowEnvironmentName.trim();
//                  rowPassword = rowPassword.trim();
//
//                  if (rowUserType.contentEquals(userType) && rowEnvironmentName.contentEquals(environmentName)) {
//                      password = rowPassword;
//                      break;
//                  }
//              }
//          }
//
//          file.close();
//
//          return password;
//      } else {
//          return null;
//      }
//  }
//
//  public void setSheetName(String newSheetName, String valueColumnName) throws IOException {
//      this.sheetName = newSheetName;
//      this.valueColumnName = valueColumnName;
//      this.setMap();
//  }
//
//  public void setValueColumnName(String valueColumnName) throws IOException {
//      this.valueColumnName = valueColumnName;
//      this.setMap();
//  }
//
//  private void setMap() throws IOException {
//      this.map = new HashMap<>();
//      FileInputStream file = new FileInputStream(this.filePath);
//
//      try (Workbook book = WorkbookFactory.create(file)) {
//          Sheet sheet = book.getSheet(this.sheetName);
//          DataFormatter fmt = new DataFormatter();
//          Row row = sheet.getRow(sheet.getFirstRowNum());
//          int i;
//          if (this.valueColumnName != null) {
//              for (i = 1; i <= row.getFirstCellNum(); ++i) {
//                  if (row.getCell(i).toString().contentEquals(this.valueColumnName)) {
//                      this.valueColumn = i;
//                      break;
//                  }
//              }
//          } else {
//              this.valueColumn = 1;
//          }
//
//          for (i = 0; i <= sheet.getLastRowNum(); ++i) {
//              String v1;
//              String v2;
//              try {
//                  row = sheet.getRow(i);
//                  v1 = row.getCell(0).toString();
//                  v2 = fmt.formatCellValue(row.getCell(this.valueColumn));
//              } catch (NullPointerException npe) {
//                  continue;
//              }
//
//              v1 = v1.trim();
//              v2 = v2.trim();
//              this.map.put(v1, v2);
//          }
//      }
//
//      file.close();
//  }
//  
//  public static Object[][] readExcel(String sheetName) throws IOException {
//	 	File filePath = new File(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx");
//      FileInputStream inputStream = new FileInputStream(filePath);
//      Workbook workbook = WorkbookFactory.create(inputStream);
//      Sheet sheet = workbook.getSheet(sheetName);
//
//     int totalRows = sheet.getLastRowNum();
//     System.out.println(totalRows);
//     Row rowCells = sheet.getRow(0);
//     int totalCols = rowCells.getLastCellNum();
//     System.out.println(totalCols);
//     
//     DataFormatter format = new DataFormatter();
//     
//     String testData[][] = new String[totalRows][totalCols];
//      for (int i = 1; i <= totalRows; i++) {
//          //Row row = sheet.getRow(i);
//          for (int j = 0; j <totalCols;  j++) {
//              //Cell cell = row.getCell(j);
//              testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
//              System.out.println(testData[i - 1][j]);
//          }
//      }
//
//      return testData;
//  }
//
//  public String getValue(String name) {
//      return this.map.get(name);
//  }
//
//  public void clearAll() {
//      this.map.clear();
//  }

	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}

	private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}

	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
		return sheet;
	}

	private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
		return WorkbookFactory.create(new File(excelFilePath));
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}

	private int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellType() == CellType.STRING) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.NUMERIC) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	private Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}

	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
		Cell cell;
		if (row == null) {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
					.getCellType() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		} else {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cell.getCellType() == CellType.STRING) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}
			} else if (cell.getCellType() == CellType.NUMERIC) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				}
			} else if (cell.getCellType() == CellType.BLANK) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, "");
				}
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				}
			} else if (cell.getCellType() == CellType.ERROR) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				}
			}
		}
		return columnMapdata;
	}
}
