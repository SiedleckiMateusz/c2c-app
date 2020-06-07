package siedlecki.mateusz.c2capp.PdfGenerator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.wz.WzEntity;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

@Getter
@Setter
@AllArgsConstructor
public class PdfGeneratorForWZ {

    public static Document generate(OutputStream outputStream, WzEntity wz) throws IOException, DocumentException, URISyntaxException {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        PdfWriter.getInstance(document,outputStream);

        document.open();
        document.setMargins(20,20,20,20);

        //add all elements

        HeaderGenerator.generate(wz,document);

        BodyGenerator.generate(wz,document);

        FooterGenerator.generate(wz,document);

        document.close();

        return document;
    }


}
