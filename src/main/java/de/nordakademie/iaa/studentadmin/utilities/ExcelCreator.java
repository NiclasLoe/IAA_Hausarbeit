package de.nordakademie.iaa.studentadmin.utilities;

import de.nordakademie.iaa.studentadmin.model.Student;
import org.apache.poi.hssf.usermodel.*;

import java.io.InputStream;
import java.util.ArrayList;

public class ExcelCreator {

    private HSSFWorkbook wb = new HSSFWorkbook();

    public HSSFWorkbook createAttendanceList(ArrayList personList, String centuryName) throws Exception {

        String sheetName = "Anwesenheitsliste";
        HSSFSheet sheet = wb.createSheet(sheetName);

        /**
         * Setting the width of the first three columns.
         */
        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 2580);
        sheet.setColumnWidth(4, 700);
        sheet.setColumnWidth(5, 700);
        sheet.setColumnWidth(6, 700);
        sheet.setColumnWidth(7, 700);
        sheet.setColumnWidth(8, 700);
        sheet.setColumnWidth(9, 700);
        sheet.setColumnWidth(10, 700);
        sheet.setColumnWidth(11, 700);
        sheet.setColumnWidth(12, 700);

        /**
         * Style for the header cells.
         */
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Anwesenheitsliste"));

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Zenturie:"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString(centuryName));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Woche"));

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Index"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Nachname"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Vorname"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Matr.-Nr."));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("1"));

        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("2"));

        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("3"));

        cell = row.createCell(7);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("4"));

        cell = row.createCell(8);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("5"));

        cell = row.createCell(9);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("6"));

        cell = row.createCell(10);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("7"));

        cell = row.createCell(11);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("8"));

        cell = row.createCell(12);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("9"));

        fillList(sheetName, personList);

        return wb;
    }

    public HSSFWorkbook createResultList(ArrayList personList, String fieldOfStudy, Integer year) throws Exception {
        String sheetName = "Ergebnisliste";
        HSSFSheet sheet = wb.createSheet(sheetName);

        /**
         * Setting the width of the first three columns.
         */
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 2580);
        sheet.setColumnWidth(4, 2580);
        sheet.setColumnWidth(5, 2580);

        /**
         * Style for the header cells.
         */
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Ergebnisliste"));

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Jahrgang:"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("" + year));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Studiengang:"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("" + fieldOfStudy));

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Index"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Nachname"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Vorname"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Matr.-Nr."));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Ergebnis"));

        fillList(sheetName, personList);

        return wb;
    }

    private void fillList(String sheetName, ArrayList personList){
        HSSFSheet sheet = wb.getSheet(sheetName);
        for (int index = 0; index < personList.size(); index++) {
            HSSFRow row = sheet.createRow(index + 3);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(new HSSFRichTextString("" + (index + 1)));
            cell = row.createCell(1);
            Student studentTemp = (Student) personList.get(index);
            HSSFRichTextString lastName = new HSSFRichTextString(studentTemp.getLastName());
            cell.setCellValue(lastName);
            cell = row.createCell(2);
            HSSFRichTextString firstName = new HSSFRichTextString(studentTemp.getFirstName());
            cell.setCellValue(firstName);
            cell = row.createCell(3);
            HSSFRichTextString studentId = new HSSFRichTextString(studentTemp.getStudentId().toString());
            cell.setCellValue(studentId);
        }
    }

    public HSSFWorkbook createCompanyList(ArrayList<Student> studentList, String shortName) {
        String sheetName = "Firmenliste";
        HSSFSheet sheet = wb.createSheet(sheetName);

        /**
         * Setting the width of the first three columns.
         */
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 2580);
        sheet.setColumnWidth(4, 2580);
        sheet.setColumnWidth(5, 2580);

        /**
         * Style for the header cells.
         */
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Firmenliste"));

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Firma:"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("" + shortName));

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Index"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Nachname"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Vorname"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Matr.-Nr."));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Studiengang"));

        for (int index = 0; index < studentList.size(); index++) {
            row = sheet.createRow(index + 3);
            cell = row.createCell(0);
            cell.setCellValue(new HSSFRichTextString("" + (index + 1)));
            cell = row.createCell(1);
            Student studentTemp = (Student) studentList.get(index);
            HSSFRichTextString lastName = new HSSFRichTextString(studentTemp.getLastName());
            cell.setCellValue(lastName);
            cell = row.createCell(2);
            HSSFRichTextString firstName = new HSSFRichTextString(studentTemp.getFirstName());
            cell.setCellValue(firstName);
            cell = row.createCell(3);
            HSSFRichTextString studentId = new HSSFRichTextString(studentTemp.getStudentId().toString());
            cell.setCellValue(studentId);
            cell = row.createCell(4);
            HSSFRichTextString fieldOfStudy = new HSSFRichTextString(studentTemp.getCentury().getFieldOfStudy().toString());
            cell.setCellValue(fieldOfStudy);
        }

        return wb;



    }
}
