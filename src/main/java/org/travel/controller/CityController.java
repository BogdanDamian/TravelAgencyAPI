package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.travel.dto.CityDto;
import org.travel.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService citySrv;

    @GetMapping
    public ResponseEntity<List<CityDto>> getAll(@RequestParam(required = false, defaultValue = "0") Integer pageNr,
                                                @RequestParam(required = false, defaultValue = "25") Integer pageSize) {
        return new ResponseEntity<>(citySrv.getAll(pageNr, pageSize), HttpStatus.OK);
    }
}
