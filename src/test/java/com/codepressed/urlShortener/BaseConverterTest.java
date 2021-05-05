package com.codepressed.urlShortener;


import com.codepressed.urlShortener.utils.BaseConverter;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class BaseConverterTest {
    BaseConverter baseConverter = new BaseConverter();

    @Test
    public void encodeTest(){
        assertEquals("Encode on Base 64 doesn't work", "aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ==", baseConverter.encodeBase64("https://www.google.com"));
    }

    @Test
    public void decodeTest(){
        assertEquals("Decode on Base 64 doesn't work", "https://www.google.com", baseConverter.decodeBase64("aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ=="));
    }
}
