package com.codepressed.urlShortener.util;

import java.util.Base64;

/**
 * @author Codepressed
 */
public class BaseConverter {
    /**
     * Automatic generation of a Base 64 Url
     */
    public String encodeBase64 (String urlToEncode){
       return Base64.getUrlEncoder().encodeToString(urlToEncode
                .getBytes());
    }

    public String decodeBase64 (String urlToDecode){
        byte[] decodedBytes = Base64.getUrlDecoder().decode(urlToDecode);
        String decodedUrl = new String(decodedBytes);
        return decodedUrl;
    }

}
