package pl.fraanek.weddinginvitationsqr.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fraanek.weddinginvitationsqr.QRConfiguration;
import pl.fraanek.weddinginvitationsqr.model.QRModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/qr")
public class QRController {
    @Autowired
    private QRConfiguration configuration;

    public QRConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(QRConfiguration configuration) {
        this.configuration = configuration;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String qr() {
        return "qr";
    }

    @ModelAttribute("qrModel")
    public QRModel qrModel(@RequestParam(value = "size", required = false, defaultValue = "0") int size) {
        QRModel qrModel = new QRModel();
        qrModel.setSize(size);
        loadFromFile(qrModel);
        return qrModel;
    }

    @ModelAttribute("qrConfiguration")
    public QRConfiguration qrConfiguration() {
        return configuration;
    }

    private void loadFromFile(QRModel qrModel) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(configuration.getInputFile().getInputStream()));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] line = StringUtils.split(strLine, ";");
                String url = line[2] + configuration.getQrSuffix();
                if(qrModel.getSize() > 0) {
                    url += "?s=" + qrModel.getSize();
                }
                qrModel.addUrl(line[2], url, line[0]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
