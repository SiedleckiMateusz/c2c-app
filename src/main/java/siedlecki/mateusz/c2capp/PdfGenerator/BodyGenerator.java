package siedlecki.mateusz.c2capp.PdfGenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import siedlecki.mateusz.c2capp.entity.wz.ProductInWzEntity;
import siedlecki.mateusz.c2capp.entity.wz.WzEntity;

import java.util.Arrays;
import java.util.List;

public class BodyGenerator {

    public static void generate(WzEntity wz, Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(new float[]{1,7,2,2,3});
        table.setWidthPercentage(100);
        tableHeader(table);
        tableBody(table,wz.getProductsInWz());


        document.add(table);

    }

    private static void tableHeader(PdfPTable table){
        List<String> headers = Arrays.asList("Lp.", "Nazwa produktu", "Ilość", "J.M.", "Uwagi");
        headers.forEach(header->table.addCell(headerCell(header)));
    }

    private static void tableBody(PdfPTable table,List<ProductInWzEntity> list){
//        for (int i = 0; i<40;i++){
//            List<String> data = Arrays.asList("Reklamówka na rolce 25x45 a'160 BOM01", "1200", "rol.", "");
//            table.addCell(new PdfPCell(phrase(String.valueOf(i+1))));
//            data.forEach(str->table.addCell(new PdfPCell(phrase(str))));
//        }


        int i = 1;
        for (ProductInWzEntity prduct : list) {
            addCellToTable(table,String.valueOf(i));
            i++;
            addCellToTable(table,prduct.getProduct().getName());
            addCellToTable(table,prduct.getQuantity().toString());
            addCellToTable(table,prduct.getUnit().getName());
            addCellToTable(table,prduct.getInfo());
        }
    }

    private static void addCellToTable(PdfPTable table, String text){
        if (text != null){
            table.addCell(new PdfPCell(phrase(text)));
        }else {
            table.addCell(new PdfPCell(phrase(" ")));
        }
    }

    private static PdfPCell headerCell(String text){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPhrase(phrase(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        return cell;
    }

    private static Phrase phrase(String text){
        return new Phrase(text, FontFactory.getFont(FontFactory.HELVETICA,"Cp1250"));
    }

    private static Phrase boldPhrase(String text){
        return new Phrase(text, FontFactory.getFont(FontFactory.HELVETICA_BOLD,"Cp1250"));
    }
}
