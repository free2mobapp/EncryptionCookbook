package uk.co.ksb.EncryptionCookbook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncEmployer {
    @JsonProperty("payload1")
    private String payload;

    @JsonProperty("iv1")
    private String iv;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String key) {
        this.iv = iv;
    }

    public EncEmployer(String payload, String iv) {
        this.payload = payload;
        this.iv = iv;
    }

    public EncEmployer() {    }
}
