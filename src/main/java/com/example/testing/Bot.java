package com.example.testing;



import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot{

    private final BotService botService;

    public Bot() {
        this.botService = new BotService();
    }


    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        if(msg.getText().equals("/arrivals")) {
            showAllArrivals(id);
        } else if(msg.getText().equals("/departures")) {
            showAllDepartures(id);
        } else {
        copyMessage(id, msg.getMessageId());
        }
        
        
        }

       
    
        

    @Override
    public String getBotToken() {
       return "7915455602:AAHUBnzJoS9qYSX4PdJoLCz4dzHsTJNYik8";
    }

    @Override
    public String getBotUsername() {
        return "LansiSatamaBot";
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
            .chatId(who.toString())                     // kenelle viesti on lähdössä
            .text(what).build();                        // viesti
        
            try {
                execute(sm);                            //viestin lähetys
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);          //tulostetaan virheet
            }
    }

    public void copyMessage(Long who, Integer msgId) {
        CopyMessage cm = CopyMessage.builder()
            .fromChatId(who.toString())
            .chatId(who.toString())
            .messageId(msgId)
            .build();

        try {
            execute(cm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void showAllArrivals(Long who) {        
        String messageText = botService.getArrivials();

        SendMessage sm = SendMessage.builder()
            .chatId(who.toString())
            .text(messageText)
            .build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void showAllDepartures(Long who) {        
        String messageText = botService.getDepartures();

        SendMessage sm = SendMessage.builder()
            .chatId(who.toString())
            .text(messageText)
            .build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

   


