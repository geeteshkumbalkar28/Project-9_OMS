package com.oms.controller.user;

import com.oms.Entity.EmailVerification;
import com.oms.Entity.Users;
import com.oms.dto.UserDto;
import com.oms.exceptions.EmailTemplateNotFoundException;
import com.oms.exceptions.InvalidOtpException;
import com.oms.exceptions.LoadingEmailTemplateException;
import com.oms.exceptions.OtpExpiredException;
import com.oms.repositories.EmailVerificationRepository;
import com.oms.service.EmailService;
import com.oms.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService es;

    @Autowired
    private EmailVerificationRepository emailVerificationRepository;

    EmailVerification emailVerification = new EmailVerification();

    // send otp
    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody UserDto users) {
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

            e.printStackTrace(); // or log.error("Exception occurred: ", e);
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


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto, HttpSession session) throws Exception {

        EmailVerification emailVerification = emailVerificationRepository.findByEmail(userDto.getEmail());

        if (emailVerification != null && emailVerification.getStatus().equals("Verified")) {
            // OTP is verified
            if (userDto.getPassword() != null) {
                userDto.setPassword(this.encoder.encode(userDto.getPassword()));
            }


            UserDto registeredUser = this.userService.createUser(userDto);

            if (registeredUser != null) {
                return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (emailVerification != null && emailVerification.getStatus().equals("Not verified")) {
            // OTP verification pending
            return new ResponseEntity<>("OTP verification pending", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("OTP verification is pending or email not found", HttpStatus.BAD_REQUEST);
        }
    }

    private String loadEmailTemplate(String templateFileName) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/templates/" + templateFileName);
            if (inputStream != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                    return reader.lines().collect(Collectors.joining(System.lineSeparator()));
                }
            } else {
                throw new EmailTemplateNotFoundException("Template file not found: " + templateFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new LoadingEmailTemplateException("Error in loading email template");
        }
    }
}
