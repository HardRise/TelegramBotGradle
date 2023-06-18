package org.morozov.service;

import lombok.extern.log4j.Log4j;
import org.morozov.controller.TelegramConfigurationController;
import org.morozov.model.MessageSender;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.morozov.RabbitMQConstants.*;

@Service
@Log4j
public class MessageHandlerService {
    private TelegramConfigurationController telegramConfig;
    private UpdateService updateService;
    private MessageSender messageSender;

    public MessageHandlerService(UpdateService updateService, MessageSender messageSender) {
        this.updateService = updateService;
        this.messageSender = messageSender;
    }

    public void initBot(TelegramConfigurationController telegramConfig) {
        this.telegramConfig = telegramConfig;
    }

    public void processMessage(Update update) {
        if (update == null) {
            log.error("Message is null");
        }
        if (update.hasMessage()) {
            divisionByType(update);
        } else {
            log.error("Unsupported type");
        }
    }

    private void divisionByType(Update update) {
        var message = update.getMessage();
        if (message.hasText()) {
            processingTextMessage(update);
        } else if (message.hasPhoto()) {
            processingPhotoMessage(update);
        } else if (message.hasDocument()) {
            processingDocumentMessage(update);
        } else if (message.hasAudio()) {
            processingAudioMessage(update);
        } else {
            log.error("Unsupported type");
        }
    }

    private void processingAudioMessage(Update update) {
        updateService.produce(AUDIO_MESSAGE_UPDATE, update);
        telegramConfig.sendAnswer(messageSender.sendMessage(update, "Audio received"));
    }

    private void processingDocumentMessage(Update update) {
        updateService.produce(DOCUMENT_MESSAGE_UPDATE, update);
        telegramConfig.sendAnswer(messageSender.sendMessage(update, "Document received"));
    }

    private void processingPhotoMessage(Update update) {
        updateService.produce(PHOTO_MESSAGE_UPDATE, update);
        telegramConfig.sendAnswer(messageSender.sendMessage(update, "Photo received"));
    }

    private void processingTextMessage(Update update) {
        updateService.produce(AUDIO_MESSAGE_UPDATE, update);
        telegramConfig.sendAnswer(messageSender.sendMessage(update, "Message received"));
    }
}
