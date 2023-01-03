package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.VReferrals;
import com.example.ehealthserver.service.VReferralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/references/referrals")
public class VReferralsController {

    @Autowired
    private final VReferralsService vReferralsService;

    public VReferralsController(VReferralsService vReferralsService) {
        this.vReferralsService = vReferralsService;
    }

    @GetMapping("/getByUinDoctor/{startDate}/{endDate}/{uinDoctor}")
    public List<VReferrals> getByUinDoctor(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                           @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                                           @PathVariable String uinDoctor) {
        return vReferralsService.findAllBySome(startDate, endDate, uinDoctor);
    }
}
