package pl.fraanek.weddinginvitationsqr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marcin Frankiewicz
 *         Date: 26.02.13
 *         Time: 14:54
 */
@Controller
public class QRController {

    @RequestMapping("/qr.html")
    public String generateQR() {
        return "qr";
    }
}
