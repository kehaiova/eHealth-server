package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.Referrals;
import com.example.ehealthserver.repository.ReferralsRepository;
import com.example.ehealthserver.service.ReferralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/referrals", produces = "application/json")
public class ReferralsController {

    @Autowired
    private final ReferralsService referralsService;

    @Autowired
    private final ReferralsRepository referralsRepository;

    public ReferralsController(ReferralsService referralsService, ReferralsRepository referralsRepository) {
        this.referralsService = referralsService;
        this.referralsRepository = referralsRepository;
    }

    @PostMapping("/saveAndFlush")
    public ResponseEntity<Referrals> saveAndFlush(@RequestBody @Validated Referrals referrals) {
        return new ResponseEntity<>(referralsRepository.save(referrals), HttpStatus.CREATED);
    }

    @GetMapping("/findReferralsById/{id}")
    public List<Referrals> findReferralsById(@PathVariable Long id) {
        return referralsService.findReferralsById(id);
    }



}
