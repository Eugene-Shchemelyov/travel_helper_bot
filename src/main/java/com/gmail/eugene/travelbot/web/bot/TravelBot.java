package com.gmail.eugene.travelbot.web.bot;

import com.gmail.eugene.travelbot.service.CityService;
import com.gmail.eugene.travelbot.web.exception.WebException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TravelBot extends TelegramLongPollingBot {
    private final Logger logger = LoggerFactory.getLogger(TravelBot.class);
    private final CityService cityService;

    @Autowired
    public TravelBot(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        String info = cityService.getInfo(text);
        SendMessage sendMessage = new SendMessage()
                .setChatId(chatId)
                .setText(info);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error(e.getMessage(), e);
            throw new WebException(String.format(
                    "Problems on sending a message: \"%s\" to bot with id: %d.", info, chatId), e);
        }
    }

    @Override
    public String getBotUsername() {
        return "HelpToTravelBot";
    }

    @Override
    public String getBotToken() {
        return "869309161:AAFCT9_cSfAViS6UvokHA6y4gbvJ-J2l9Y8";
    }
}
