package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.VReferrals;

import java.util.Date;
import java.util.List;

public interface VReferralsService {

    List<VReferrals> findAllBySome(Date startDate, Date endDate, String uinDoctor);

}
