package com.idziak.cards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements MailSenderService {

    @Autowired
    private MailSender mailSender;

    public void sendAccountConfirmationRequest(){
        throw new UnsupportedOperationException("Implement");
    }
}
