package siedlecki.mateusz.c2capp.controller;

import com.itextpdf.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import siedlecki.mateusz.c2capp.PdfGenerator.PdfGeneratorForWZ;
import siedlecki.mateusz.c2capp.controller.mapper.wz.WzMapper;
import siedlecki.mateusz.c2capp.controller.model.wz.ShowWz;
import siedlecki.mateusz.c2capp.entity.wz.WzEntity;
import siedlecki.mateusz.c2capp.service.wz.WzService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping({"/wz","/wz.html"})
public class WzController {

    private final WzService wzService;
    private final WzMapper wzMapper;

    public WzController(WzService wzService, WzMapper wzMapper) {
        this.wzService = wzService;
        this.wzMapper = wzMapper;
    }

    @GetMapping
    public String showAllWz(Model model){
        model.addAttribute("wzs",wzService.findAll());

        return "wz/index";
    }

    @GetMapping("/{id}")
    public String showWzById(@PathVariable String id, Model model){
        Optional<WzEntity> byId = Optional.empty();

        try{
            byId = wzService.findById(Long.parseLong(id));
        }catch (NumberFormatException e){
            log.info("Id nie jest liczbą");
        }

        ShowWz wz = wzMapper.entityToShow(byId.orElse(null));

        model.addAttribute("wz",wz);

        return "wz/details";
    }

    @GetMapping("/pdf/{stringId}")
    public void showPdfWz(HttpServletResponse response, @PathVariable String stringId) throws IOException {

        try {
            Long id = Long.parseLong(stringId);


            Optional<WzEntity> wzOptional = wzService.findById(id);

            if (wzOptional.isPresent()){
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                try {
                    PdfGeneratorForWZ.generate(baos,wzOptional.get());
                } catch (DocumentException e) {
                    response.getWriter().write("Nie udało się utworzyć dokumentu");
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }

                log.info("Generate WZ file to pdf");

                response.setContentType("application/pdf");

                response.setContentLength(baos.size());

                OutputStream outputStream = response.getOutputStream();
                baos.writeTo(outputStream);
                outputStream.flush();
                outputStream.close();
            }else {
                response.getWriter().write("Nie ma WZ o podanym id");
            }


        }catch (NumberFormatException e){
            response.getWriter().write("Podane id nie jest liczbą");
        }




    }



}
