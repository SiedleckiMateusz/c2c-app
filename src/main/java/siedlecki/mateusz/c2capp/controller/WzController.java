package siedlecki.mateusz.c2capp.controller;

import com.itextpdf.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siedlecki.mateusz.c2capp.PdfGenerator.PdfGeneratorForWZ;
import siedlecki.mateusz.c2capp.entity.wz.Wz;
import siedlecki.mateusz.c2capp.service.wz.WzService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping({"/wz","/wz.html"})
public class WzController {

    private final WzService wzService;

    public WzController(WzService wzService) {
        this.wzService = wzService;
    }

    @GetMapping("/{id}")
    public void showPdfWz(HttpServletResponse response, @PathVariable Long id) throws IOException {

        log.info("Generate WZ file to pdf");

        Wz wz = wzService.findById(id).orElse(null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfGeneratorForWZ.generate(baos,wz);
        } catch (DocumentException e) {
            System.out.println("Nie udało się utworzyć dokumentu");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        response.setContentType("application/pdf");

        response.setContentLength(baos.size());

        OutputStream outputStream = response.getOutputStream();
        baos.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();

    }



}
