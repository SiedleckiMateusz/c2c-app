package siedlecki.mateusz.c2capp.PdfGenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import siedlecki.mateusz.c2capp.entity.employee.EmployeeEntity;
import siedlecki.mateusz.c2capp.entity.wz.WzEntity;

public class FooterGenerator {


    public static void generate(WzEntity wz, Document document) throws DocumentException {

        document.add(infoTable(wz));

        document.add(emptyLine());

        PdfPTable table = new PdfPTable(new float[]{4,2,4});
        table.setWidthPercentage(100);

        EmployeeEntity employee = wz.getEmployee();
        table.addCell(signatureTable("Wystawił(a):",
                employee.getFirstName()+" "+employee.getLastName()));
        table.addCell(emptyCell());
        table.addCell(signatureTable("Odebrał(a):",""));

        document.add(table);

    }

    private static Paragraph emptyLine(){
        return new Paragraph(new Phrase(" "));
    }


    private static Phrase phrase(String text){
        return new Phrase(text, FontFactory.getFont(FontFactory.HELVETICA,"Cp1250"));
    }

    private static PdfPTable signatureTable(String title,String person){
        PdfPTable table = new PdfPTable(1);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setWidthPercentage(100);

        table.addCell(descriptionCell(title));


        table.addCell(dataCell(person+"\n\n\n\n",Element.ALIGN_CENTER));

        return table;

    }

    private static PdfPCell descriptionCell(String title){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderWidth(0);
        cell.setPhrase(new Phrase(title
                        , FontFactory.getFont(FontFactory.HELVETICA_BOLD,"Cp1250")));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        return cell;
    }

    private static PdfPTable infoTable(WzEntity wz){
        PdfPTable infoTable = new PdfPTable(new float[]{3,7});
        infoTable.setWidthPercentage(100);

        PdfPCell titleInfo = new PdfPCell();
        titleInfo.setBorder(Rectangle.NO_BORDER);
        titleInfo.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleInfo.addElement(
                new Phrase("Uwagi do dokumentu", FontFactory.getFont(FontFactory.HELVETICA_BOLD,"Cp1250"))
        );

        PdfPCell descInfo = new PdfPCell();
        descInfo.setBorder(Rectangle.NO_BORDER);
        descInfo.setHorizontalAlignment(Element.ALIGN_LEFT);
        descInfo.addElement(phrase(wz.getInfo()));

        infoTable.addCell(titleInfo);
        infoTable.addCell(descInfo);

        return infoTable;
    }

    private static PdfPCell dataCell(String text,int element){
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(phrase(text));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(element);

        return cell;
    }

    private static PdfPCell emptyCell(){
        PdfPCell emptyCell = new PdfPCell();
        emptyCell.setPhrase(new Phrase(" "));
        emptyCell.setBorder(Rectangle.NO_BORDER);

        return emptyCell;
    }
}
