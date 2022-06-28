package uk.co.ksb.EncryptionCookbook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EEmployer {
    @JsonProperty("payload")
    private String payload;

    @JsonProperty("iv")
    private String iv;

    public String getIv() {
        return iv;
    }

    public String getPayload() {
        return payload;
    }
}
