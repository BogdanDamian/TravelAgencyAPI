package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private CountryService countrySrv;
}
