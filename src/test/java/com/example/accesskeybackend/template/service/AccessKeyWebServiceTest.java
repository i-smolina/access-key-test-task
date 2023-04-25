package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.IllegalArgumentException;
import com.example.accesskeybackend.web.service.AccessKeyWebService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccessKeyWebServiceTest {
    AccessKeyWebService accessKeyWebService = new AccessKeyWebService();

    @Test
    @DisplayName("support IPv6")
    void checkIpv6SupportYes() {
        List<String> supportIPv6 = List.of(
                "google.com",
                "www.google.com",
                "https://www.google.com");
        supportIPv6.forEach(siteUrl ->
                assertTrue(accessKeyWebService.checkIpv6Support(siteUrl)));
    }

    @Test
    @DisplayName("don't support IPv6")
    void checkIpv6SupportNo() {
        List<String> supportIPv6 = List.of(
                "szgmu.ru",
                "www.szgmu.ru",
                "https://www.szgmu.ru");
        supportIPv6.forEach(siteUrl ->
                assertFalse(accessKeyWebService.checkIpv6Support(siteUrl)));
    }

    @Test
    @DisplayName("invalid argument")
    void checkIpv6SupportInvalid() {
        List<String> supportIPv6 = List.of(
                "google",
                "www.googlecom",
                "https:www.google.com");
        supportIPv6.forEach(siteUrl ->
                assertThrows(IllegalArgumentException.class,
                        () ->  accessKeyWebService.checkIpv6Support(siteUrl)));
    }
}