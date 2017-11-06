package de.nordakademie.iaa.studentadmin.utilities;

import de.nordakademie.iaa.studentadmin.model.Document;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FileInputUtil {
    public InputStream createFileInputStream(HSSFWorkbook wb) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        wb.write(baos);
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
