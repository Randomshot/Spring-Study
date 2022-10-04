package org.example.service.impl;

import org.example.config.ApplicationConfig;
import org.example.dto.Guestbook;
import org.example.service.GuestbookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookServiceImplTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookService guestbookService = ac.getBean(GuestbookService.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("kang kyungmi22");
        guestbook.setContent("hihi");
        guestbook.setRegdate(new Date());
        Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
        System.out.println(result);

    }
}
