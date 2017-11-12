package de.nordakademie.iaa.studentadmin.utilities;

import de.nordakademie.iaa.studentadmin.model.Student;
import org.apache.poi.hssf.usermodel.*;

import java.util.ArrayList;

/**
 * Class to create excel sheets.
 *
 * @author Niclas Loeding
 */
public class ExcelCreator {

    /**
     * The created workbook.
     */
    private HSSFWorkbook wb = new HSSFWorkbook();

    /**
     * Create a attendance list.
     *
     * @param personList  The list of persons to be added.
     * @param centuryName The name of the century.
     * @return The created workbook.
     */
    public HSSFWorkbook createAttendanceList(ArrayList personList, String centuryName) {

        String sheetName = "Anwesenheitsliste";
        HSSFSheet sheet = wb.createSheet(sheetName);

        // Setting the width of the columns
        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 2580);
        for (int index = 1; index < 10; index++) {
            sheet.setColumnWidth(index + 3, 700);
        }

        // Style for the header cells
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        // Set fixed values for header cells
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
        for (int weekIndex = 1; weekIndex < 10; weekIndex++) {
            cell = row.createCell(weekIndex + 3);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(new HSSFRichTextString("" + weekIndex));
        }

        // Fill list
        fillList(sheetName, personList);

        return wb;
    }

    /**
     * Create a result list.
     *
     * @param personList   The list of persons to be added.
     * @param fieldOfStudy The field of study of the maniple.
     * @param year         The year of the maniple.
     * @return The created workbook.
     */
    public HSSFWorkbook createResultList(ArrayList personList, String fieldOfStudy, String year) {
        String sheetName = "Ergebnisliste";
        HSSFSheet sheet = wb.createSheet(sheetName);

        // Setting the width
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        for (int index = 1; index < 4; index++) {
            sheet.setColumnWidth(index + 2, 2580);
        }

        // Style for the header cells
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        // Set fixed values
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
        cell.setCellValue(new HSSFRichTextString(year));
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

        // Fill list
        fillList(sheetName, personList);

        return wb;
    }

    /**
     * Fill the list section of the workbook.
     *
     * @param sheetName  The name of the sheet that is currently edited.
     * @param personList The list of persons to be added.
     */
    private void fillList(String sheetName, ArrayList personList) {
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

    /**
     * Create a company list.
     *
     * @param studentList The list of persons to be added.
     * @param shortName   The name of the company.
     * @return The created workbook.
     */
    public HSSFWorkbook createCompanyList(ArrayList<Student> studentList,
                                          String shortName, String contactPerson) {
        String sheetName = "Firmenliste";
        HSSFSheet sheet = wb.createSheet(sheetName);

        // Setting the width
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 2580);
        sheet.setColumnWidth(4, 2580);
        sheet.setColumnWidth(5, 2580);


        // Style for the header cells
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        // Set fixed values
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
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Ansprechpartner:"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("" + contactPerson));
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

        // Fill the list
        for (int index = 0; index < studentList.size(); index++) {
            row = sheet.createRow(index + 3);
            cell = row.createCell(0);
            cell.setCellValue(new HSSFRichTextString("" + (index + 1)));
            cell = row.createCell(1);
            Student studentTemp = studentList.get(index);
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
