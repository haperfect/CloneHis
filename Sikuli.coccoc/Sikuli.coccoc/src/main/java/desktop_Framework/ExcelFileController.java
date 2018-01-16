package desktop_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * ExcelFileController class used to manage actions with Excel file like open ,
 * close , write , read excel
 * 
 * @author hanv
 * @date 023-Octorber-2014
 */
public class ExcelFileController  {

	public HSSFSheet ExcelWSheet;

	public HSSFWorkbook ExcelWBook;

	public HSSFCell Cell;

	public HSSFRow Row; 
	
	

	/**
	 * Get Excel File at known path
	 * 
	 * @author hanv
	 * @date 023-Octorber-2014
	 * @param excelFilePath
	 *            that is Path of Excel File
	 * @return a HSSFWorkbook, a object represents Excel file
	 * @throws Exception
	 *             if File is not found
	 */
	public HSSFWorkbook getExcelFile(String excelFilePath) throws Exception {
		try {
			// Open excel file
			FileInputStream excelfile = new FileInputStream(new File(
					excelFilePath));

			// Access data required test
			ExcelWBook = new HSSFWorkbook(excelfile);
			return ExcelWBook;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ExcelWBook;
		}

	}

	/**
	 * Get A Sheet from Excel File , locating Sheet by Name
	 * 
	 * @author hanv
	 * @date 023-Octorber-2014
	 * @param ExcelBook
	 *            , represent Excel file
	 * @param nameSheet
	 *            ,name of sheet in that excel file
	 * @return HSSFSheet, a sheet in that Excel file
	 */
	public HSSFSheet getSheetFromExcelFile(HSSFWorkbook ExcelBook,
			String nameSheet) {

		try {
			HSSFSheet sheet = ExcelBook.getSheet(nameSheet);
			return sheet;
		} catch (Exception ex) {
			System.out
					.print("Nam of Sheet is not Correct,..Please input again !");
			return null;
		}

	}

	/**
	 * Get a Row from Sheet
	 * 
	 * @author hanv
	 * @date 023-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @param indexRow
	 *            ,index of Row in that sheet
	 * @return HSSFRow, a Row in that sheet
	 */
	public HSSFRow getRowFromSheet(HSSFSheet sheet, int indexRow) {
		int numberRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		HSSFRow Row = null;

		if (indexRow <= numberRows) {
			Row = sheet.getRow(indexRow);
			return Row;
		} else {

			try {
				throw (new Exception(
						" index of Row is not correct! Please input index of row is not bigger than "
								+ getNumberRowsFromSheet(sheet)));
			} catch (Exception e) {
				e.printStackTrace();
			}

			return Row;
		}
	}

	/**
	 * Get A Cell From Sheet , locating by index of Row
	 * 
	 * @author hanv
	 * @date 023-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @param indexRow
	 *            ,index of Row in that sheet
	 * @param indexColumn
	 *            , index of Column from that sheet
	 * @return HSSFCell, a Cell in that sheet
	 */
	public HSSFCell getCellFromSheet(HSSFSheet sheet, int indexRow,
			int indexColumn) {
		HSSFCell Cell = null;
		HSSFRow Row = getRowFromSheet(sheet, indexRow);
		Cell = Row.getCell(indexColumn);
		return Cell;

	}

	/**
	 * Get A Column , locating by index of Cell in a Row
	 * 
	 * @author hanv
	 * @date 23-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @param indexColumn
	 *            , index of Column from that sheet
	 * @return List<HSSFCell>, a total of Cells which have same index of column
	 *         in that sheet
	 */
	public List<HSSFCell> getColumnFromSheet(HSSFSheet sheet, int indexColumn) {
		int rows = getNumberRowsFromSheet(sheet);
		List<HSSFCell> list = new ArrayList<HSSFCell>();

		HSSFCell cell;

		for (int i = 0; i < rows; i++) {
			cell = getCellFromSheet(sheet, i, indexColumn);
			list.add(i, cell);
		}
		return list;
	}

	/**
	 * Get total of row in sheet
	 * 
	 * @author hanv
	 * @date 23-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @return int, total of rows in that sheet
	 */
	public int getNumberRowsFromSheet(HSSFSheet sheet) {
		int numberRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return numberRows;
	}

	/**
	 * Get total of Cells in a Row
	 * 
	 * @author hanv
	 * @date 23-Octorber-2014
	 * @param row
	 *            in Excel file
	 * @return int, total of cells in a row
	 */
	public int getNumberCellsFromARow(HSSFRow row) {
		int numberCells = row.getLastCellNum() - row.getFirstCellNum();
		return numberCells;
	}

	/**
	 * Write a value to a Cell in Sheet
	 * 
	 * @author hanv
	 * @date 23-Octorber-2014
	 * @param excelFilepath
	 *            path of Excel file
	 * @param sheet
	 *            in Excel file
	 * @param row
	 *            in Excel file
	 * @param indexRow
	 *            index of row in Sheet
	 * @param indexColumn
	 *            index of column in sheet
	 * @param result
	 *            which need to insert into cell
	 * @param nameSheet
	 *            , name of sheet in Excel file
	 * @return void
	 */
	public void writeToCell(String excelFilepath, HSSFSheet sheet,
			String nameSheet, int indexRow, int indexColumn, String result) {
		@SuppressWarnings("unused")
		HSSFRow row = sheet.getRow(indexRow);

		HSSFCell cell = sheet.getRow(indexRow).createCell(indexColumn);
		convertCelltoString(cell);
		cell.setCellValue(result);
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(excelFilepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			sheet.getWorkbook().write(fs);
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Convert Cell to String format
	 * 
	 * @author hanv
	 * @date 23-Octorber-2014
	 * @param cell
	 *            in Excel file
	 * @return void
	 */
	@SuppressWarnings("static-access")
	public void convertCelltoString(HSSFCell cell) {
		cell.setCellType(Cell.CELL_TYPE_STRING);
	}

	/**
	 * Convert Cell to Numeric format
	 * 
	 * @author hanv
	 * @date 23-Octorber-2014
	 * @param cell
	 *            in Excel file
	 * @return void
	 */
	@SuppressWarnings("static-access")
	public void convertCelltoNumerric(HSSFCell cell) {
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	}

}
