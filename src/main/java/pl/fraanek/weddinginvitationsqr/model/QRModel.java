package pl.fraanek.weddinginvitationsqr.model;

import org.apache.commons.lang.builder.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcin
 * Date: 26.02.13
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public class QRModel {
    public class QRUrl {
        private String url;
        private String qrUrl;
        private String description;

        public QRUrl(String url, String qrUrl) {
            this.url = url;
            this.qrUrl = qrUrl;
        }

        public QRUrl(String url, String qrUrl, String description) {
            this.url = url;
            this.qrUrl = qrUrl;
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getQrUrl() {
            return qrUrl;
        }

        public void setQrUrl(String qrUrl) {
            this.qrUrl = qrUrl;
        }
    }
    private int size = 0;
    private List<QRUrl> urls = new ArrayList<QRUrl>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<QRUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<QRUrl> urls) {
        this.urls = urls;
    }

    public void addUrl(String url, String qrUrl) {
        urls.add(new QRUrl(url, qrUrl));
    }

    public void addUrl(String url, String qrUrl, String description) {
        urls.add(new QRUrl(url, qrUrl, description));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("size", size).
                append("urls", urls).
                toString();
    }
}
