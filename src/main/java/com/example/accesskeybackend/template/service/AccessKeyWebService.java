package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.IllegalArgumentException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.net.*;
import java.util.Arrays;

@Service
@AllArgsConstructor
@Log4j2
public class AccessKeyWebService {
    public boolean checkIpv6Support(String siteUrl) {
        try {
            siteUrl = extractDomain(siteUrl);
            InetAddress[] inetAddresses = InetAddress.getAllByName(siteUrl);
            return Arrays.stream(inetAddresses)
                    .anyMatch(inetAddress -> inetAddress instanceof Inet6Address);
        } catch (MalformedURLException | UnknownHostException t1) {
            throw new IllegalArgumentException("The URL is not valid");
        }
    }

    private String extractDomain(String siteUrl) throws MalformedURLException {
        if (UrlValidator.getInstance().isValid(siteUrl)) {
            URL url = new URL(siteUrl);
            siteUrl = url.getHost();
        }
        return siteUrl;
    }
}
