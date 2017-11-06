package de.nordakademie.iaa.studentadmin.utilities;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Class to prepare data for export.
 *
 * @author Niclas Loeding
 */
public class FileInputUtil {
    /**
     * Method to create file input stream.
     *
     * @param wb The workbook to be converted.
     * @return The created ByteArrayInputStream.
     * @throws Exception Exception possibly thrown by ByteArrayOutputStream.
     */
    public InputStream createFileInputStream(HSSFWorkbook wb) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        wb.write(baos);
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
