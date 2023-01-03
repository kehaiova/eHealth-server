package com.example.ehealthserver.repository;

import com.example.ehealthserver.entity.VReferrals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VReferralsRepository extends JpaRepository<VReferrals, Long> {

    @Query(value = "SELECT referral from VReferrals referral where referral.issueDate>=:startDate and referral.issueDate<=:endDate and referral.uinDoctor=:uinDoctor")
    List<VReferrals> findAllBySome(Date startDate, Date endDate, String uinDoctor);
}
