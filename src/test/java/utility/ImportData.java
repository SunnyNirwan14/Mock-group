package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ImportData 
{
	public static String importExcelData(int row,int cell) throws EncryptedDocumentException, IOException
	{
		String path="C:\\Users\\SUNNY\\Desktop\\Book1.xlsx";
		FileInputStream file=new FileInputStream(path);
		String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
