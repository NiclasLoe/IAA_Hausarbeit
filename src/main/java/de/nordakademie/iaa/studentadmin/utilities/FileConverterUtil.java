package de.nordakademie.iaa.studentadmin.utilities;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class to convert file data.
 *
 * @author Niclas Loeding
 */
public class FileConverterUtil {
    /**
     * Method to convert file to byte array.
     *
     * @param fileToCreate The file to be converted.
     * @return Content as byte array.
     * @throws IOException Exception thrown by fileInputStream.
     */
    public byte[] contentInByte(File fileToCreate) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileToCreate);
        byte fileContent[] = new byte[(int) fileToCreate.length()];
        fileInputStream.read(fileContent);
        fileInputStream.close();
        return fileContent;

    }

    /**
     * Method to transform byte array to string.
     *
     * @param file       File data to be converted.
     * @param dataFormat The destination data format.
     * @return File data as string.
     */
    public String byteToString(byte[] file, String dataFormat) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        StringBuilder fileString = new StringBuilder();
        String dataType = "data:" + dataFormat + ";base64,";
        fileString.append(dataType);
        fileString.append(base64Encoder.encode(file));
        return fileString.toString();
    }
}
