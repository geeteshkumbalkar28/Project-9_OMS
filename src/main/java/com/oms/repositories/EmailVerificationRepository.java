package com.oms.repositories;

import com.oms.Entity.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationRepository  extends JpaRepository<EmailVerification,Integer> {


    EmailVerification findByEmail(String email);


}
