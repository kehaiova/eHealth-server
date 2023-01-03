package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Referrals;

import java.util.List;

public interface ReferralsService {

    List<Referrals> findReferralsById (Long id);

}
