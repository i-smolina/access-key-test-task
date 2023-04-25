package com.example.accesskeybackend.web.controller;

import com.example.accesskeybackend.web.service.AccessKeyWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class AccessKeyWebController {
    private final AccessKeyWebService accessKeyWebService;

    @GetMapping("checkIpv6Support")
    public boolean checkIpv6Support(@RequestParam String siteUrl) {
       return accessKeyWebService.checkIpv6Support(siteUrl);
    }
}
