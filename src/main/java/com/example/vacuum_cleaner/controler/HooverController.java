package com.example.vacuum_cleaner.controler;;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.vacuum_cleaner.dto.*;
import com.example.vacuum_cleaner.service.HooverService;


@RestController
@RequestMapping("/hoover")
public class HooverController {

    @Autowired
    private HooverService hooverService;

    @PostMapping("/clean")
    public HooverResponse cleanRoom(@RequestBody HooverRequest request) {
        return hooverService.execute(request);
    }
}
