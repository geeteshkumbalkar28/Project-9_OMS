package com.oms.controller;

import com.oms.Entity.EmailVerification;
import com.oms.Entity.Users;
import com.oms.dto.UserDto;
import com.oms.exceptions.InvalidOtpException;
import com.oms.exceptions.OtpExpiredException;
import com.oms.payloads.JwtAuthResponse;
import com.oms.repositories.EmailVerificationRepository;
import com.oms.repositories.UsersRepository;
import com.oms.security.JwtTokenHelper;
import com.oms.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class ForgotPasswordController {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private EmailService es;

    @Autowired
    private EmailVerificationRepository emailVerificationRepository;


    // generate token
    @PostMapping("/forget-password")
    public ResponseEntity<JwtAuthResponse> generateToken(@RequestParam String email) throws Exception {

        try {
            Users findByEmail = this.usersRepository.findByEmail(email);
            String token = this.jwtTokenHelper.generateToken(findByEmail);
            return ResponseEntity.ok(new JwtAuthResponse(token, "success"));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new JwtAuthResponse("null", "Invalid credentials"));
        }

    }

    // send otp
    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody Users users) {
        try {
            System.out.println(users.getEmail());

            Random random = new Random();

            String otp = RandomStringUtils.randomNumeric(4);
            System.out.println(otp);
            LocalDateTime localDateTime = LocalDateTime.now();

            String subject = "OTP from LMS";
            String emailTemplate = "<h1>OTP: " + otp + "</h1>";

            String to = users.getEmail();
            boolean flag = this.es.sendEmail(emailTemplate, subject, to);
            if (flag) {
                this.es.saveEmail(users.getEmail(), otp, localDateTime);
                return "OTP has been sent, please verify OTP.";
            } else {
                return "Please try again..!!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while processing your request. Please try again later.";
        }

    }


    // verify otp
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String otp, @RequestParam String email) {

        EmailVerification emailVerification = emailVerificationRepository.findByEmail(email);
        if (emailVerification == null) {
            throw new InvalidOtpException("Invalid OTP");
        } else {
            if (emailVerification.getOtp().equals(otp)) {
                LocalDateTime creationTime = emailVerification.getCreationTime();
                LocalDateTime currentTime = LocalDateTime.now();
                Duration duration = Duration.between(creationTime, currentTime);

                if (duration.toMinutes() <= 3) {
                    emailVerification.setStatus("Verified");
                    emailVerificationRepository.save(emailVerification);

                    return "Verified";
                } else {
                    throw new OtpExpiredException("OTP has expired");
                }
            } else {
                throw new InvalidOtpException("Invalid OTP");
            }

        }

    }

    // change password
    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword) throws Exception {

        EmailVerification emailVerification = emailVerificationRepository.findByEmail(email);

        if (emailVerification != null && emailVerification.getStatus().equals("Verified")) {
            Users users = this.usersRepository.findByEmail(emailVerification.getEmail());
            // OTP is verified
            if (password != null && confirmPassword != null && password.equals(confirmPassword)) {

                users.setPassword(this.encoder.encode(password));
                this.usersRepository.save(users);
                return new ResponseEntity<>(" password changed successfully", HttpStatus.OK);

            } else {
                return new ResponseEntity<>("failed: password not matched ", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (emailVerification != null && emailVerification.getStatus().equals("Not verified")) {

            return new ResponseEntity<>("OTP verification pending", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("OTP verification is pending or email is null", HttpStatus.BAD_REQUEST);
        }
    }


}
