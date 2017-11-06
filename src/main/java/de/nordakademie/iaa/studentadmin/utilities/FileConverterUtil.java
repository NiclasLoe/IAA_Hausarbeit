package de.nordakademie.iaa.studentadmin.utilities;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileConverterUtil {
    public byte[] contentInByte(File fileToCreate) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileToCreate);
        byte fileContent[] = new byte[(int) fileToCreate.length()];
        fileInputStream.read(fileContent);
        fileInputStream.close();
        return fileContent;

    }

    public String byteToString(byte[] file, String dataFormat) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        StringBuilder fileString = new StringBuilder();
        String dataType = "data:" + dataFormat + ";base64,";
        fileString.append(dataType);
        fileString.append(base64Encoder.encode(file));
        return fileString.toString();
    }
}
