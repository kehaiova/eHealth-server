package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Referrals;
import com.example.ehealthserver.repository.ReferralsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReferralsServiceImpl implements ReferralsService {

    @Autowired
    private ReferralsRepository referralsRepository;

    @Override
    public List<Referrals> findReferralsById(Long id) {
        return referralsRepository.findAllById(Collections.singleton(id));
    }


}
