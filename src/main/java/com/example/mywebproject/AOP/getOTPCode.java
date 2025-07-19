package com.example.mywebproject.AOP;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Aspect
public class getOTPCode {

    @Autowired
    private JavaMailSender mailSender;

    @Around("@annotation(com.example.mywebproject.anno.OTPCode)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        if(proceed != null && proceed.toString() == "Not found") return null;
        StringBuilder res = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i<6;i++){
            res.append(random.nextInt(10));
        }
        String theRes = res.toString();
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(joinPoint.getArgs()[0].toString()));
                mimeMessage.setFrom(new InternetAddress("2571469016@qq.com"));
                mimeMessage.setText("您的验证码是" + theRes);
            }
        };
        mailSender.send(preparator);
        return theRes;
    }
}
