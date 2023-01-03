package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.VReferrals;
import com.example.ehealthserver.repository.VReferralsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VReferralsServiceImpl implements VReferralsService {

    @Autowired
    private VReferralsRepository vReferralsRepository;

    @Override
    public List<VReferrals> findAllBySome(Date startDate, Date endDate, String uinDoctor) {
        return vReferralsRepository.findAllBySome(startDate, endDate, uinDoctor);
    }
}
