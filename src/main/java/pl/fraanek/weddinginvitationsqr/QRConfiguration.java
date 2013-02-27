package pl.fraanek.weddinginvitationsqr;

import org.springframework.core.io.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Marcin
 * Date: 26.02.13
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */
public class QRConfiguration {
    private Resource inputFile;
    private String qrSuffix;

    public Resource getInputFile() {
        return inputFile;
    }

    public void setInputFile(Resource inputFile) {
        this.inputFile = inputFile;
    }

    public String getQrSuffix() {
        return qrSuffix;
    }

    public void setQrSuffix(String qrSuffix) {
        this.qrSuffix = qrSuffix;
    }
}
