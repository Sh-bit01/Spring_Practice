package com.example.demo.Service;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Map;

import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    private static final Map<String, OTPData> otpStorage = new ConcurrentHashMap<>();

    public static String gen() {
        SecureRandom random = new SecureRandom();
        int rando = 100000 + random.nextInt(900000);
        return String.format("%06d", rando);
    }

    public String sendOTP(String email) {
        String otp = gen();
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(5);
        otpStorage.put(email, new OTPData(otp, expiry)); // Store OTP in memory

        return otp;
    }


    public boolean valOTP(String email, String otp) {
        OTPData storedOTP = otpStorage.get(email);

        if (storedOTP != null && storedOTP.getOtpCode().equals(otp) && storedOTP.getExpiryTime().isAfter(LocalDateTime.now())) {
            otpStorage.remove(email); // Remove OTP after successful validation
            return true;
        }
        return false;
    }

    @Getter
    private static class OTPData {
        private final String otpCode;
        private final LocalDateTime expiryTime;

        public OTPData(String otpCode, LocalDateTime expiryTime) {
            this.otpCode = otpCode;
            this.expiryTime = expiryTime;
        }

    }
}
