package siedlecki.mateusz.c2capp.PdfGenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;
import siedlecki.mateusz.c2capp.entity.wz.Wz;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public class HeaderGenerator {

    public static void generate(Wz wz,Document document) throws IOException, URISyntaxException, DocumentException {

        PdfPTable headerTable = new PdfPTable(new float[]{9,2,9});
        headerTable.setWidthPercentage(100);

        headerTable.addCell(logoCell());
        headerTable.addCell(emptyCell());
        headerTable.addCell(dateAndPlaceCell(wz));


        headerTable.addCell(dealerCell());
        headerTable.addCell(emptyCell());
        headerTable.addCell(clientCell(wz));

        document.add(headerTable);

        document.add(emptyLine());
        document.add(title(wz));
        document.add(emptyLine());
    }

    private static Paragraph emptyLine(){
        return new Paragraph(new Phrase(" "));
    }

    private static PdfPCell emptyCell(){
        PdfPCell emptyCell = new PdfPCell();
        emptyCell.setPhrase(new Phrase(" "));
        emptyCell.setBorder(Rectangle.NO_BORDER);

        return emptyCell;
    }

    private static Phrase phrase(String text){
        return new Phrase(text,FontFactory.getFont(FontFactory.HELVETICA,"Cp1250"));
    }

    private static PdfPCell headerCell(String text){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderWidth(0);
        cell.setBorderWidthTop(1);
        cell.setPhrase(phrase(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        return cell;
    }

    private static PdfPCell dataCell(String text,int element){
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(phrase(text));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthBottom(0.25f);
        cell.setHorizontalAlignment(element);

        return cell;
    }

    private static PdfPCell logoCell() throws URISyntaxException, IOException, BadElementException {
        Path path = Paths.get(ClassLoader.getSystemResource("logo.png").toURI());
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scalePercent(10);

        PdfPCell logoCell = new PdfPCell();
        logoCell.addElement(img);
        logoCell.setBorder(Rectangle.NO_BORDER);

        return logoCell;
    }

    private static PdfPCell dateAndPlaceCell(Wz wz){
        PdfPCell dateAndPlaceCell = new PdfPCell();

        PdfPTable dateAndPlaceTable = new PdfPTable(1);
        dateAndPlaceTable.setHorizontalAlignment(Element.ALIGN_CENTER);
        dateAndPlaceTable.setWidthPercentage(100);

        dateAndPlaceTable.addCell(headerCell("Miejsce wystawienia"));

        dateAndPlaceTable.addCell(dataCell("Lublin",Element.ALIGN_CENTER));

        dateAndPlaceTable.addCell(headerCell("Data wystawienia"));

        dateAndPlaceTable.addCell(
                dataCell(wz.getCreated().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),Element.ALIGN_CENTER));

        dateAndPlaceCell.addElement(dateAndPlaceTable);
        dateAndPlaceCell.setBorder(Rectangle.NO_BORDER);

        return dateAndPlaceCell;
    }


    private static PdfPCell dealerCell(){
        return headerAndDataCell("Sprzedawca"
                ,"C2C Sp. z o.o.\n" +
                        "Zawieprzycka 8i\n" +
                        "20-228 Lublin\n" +
                        "Tel. +48 81 444 73 83, +48 81 748 57 70\n" +
                        "NIP: 9462637937");
    }

    private static PdfPCell clientCell(Wz wz){
        return headerAndDataCell("Odbiorca",generateTextClient(wz.getClient()));
    }

    private static String generateTextClient(ClientEntity client){
        StringBuilder stringClient = new StringBuilder();
        stringClient.append(client.getRealName()).append("\n");

        String address = client.getAddress();
        if (hasText(address)){
            stringClient.append(address);
        }
        stringClient.append("\n");

        String nip = client.getNip();
        if (hasText(nip)){
            stringClient.append("NIP: ").append(nip);
        }
        stringClient.append("\n");
        stringClient.append("\n");

        return stringClient.toString();

    }

    private static boolean hasText(String text){
        return text != null && !text.isEmpty();
    }

    private static PdfPCell headerAndDataCell(String header, String data){
        PdfPCell cell = new PdfPCell();

        PdfPTable table = new PdfPTable(1);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setWidthPercentage(100);

        table.addCell(headerCell(header));

        table.addCell(dataCell(data,Element.ALIGN_LEFT));

        cell.addElement(table);
        cell.setBorder(Rectangle.NO_BORDER);

        return cell;
    }

    private static Paragraph title(Wz wz){
        Paragraph p = new Paragraph();
        Phrase phrase = new Phrase("WYDANIE ZEWNĘTRZNE nr "+wz.getId()+"/04/2020",FontFactory.getFont(FontFactory.HELVETICA_BOLD,"Cp1250",16));
        p.add(phrase);
        p.setAlignment(Element.ALIGN_CENTER);

        return p;
    }
}
