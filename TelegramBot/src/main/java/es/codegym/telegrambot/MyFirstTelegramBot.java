package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "donGuillobot";//"agregue el nombre del bot entre comillas a continuación";
    public static final String TOKEN = "6726864810:AAECRXa97axdSY0i9dJlJsNRiv-dm6yrnzM";//"agregue el token del bot entre comillas a continuación"; -> https://core.telegram.org/bots/api

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    /*Esta es la respuesta a cada interacción a nuestro BOT*/
    public void onUpdateEventReceived(Update update) {
        System.out.printf(update.toString());
        System.out.printf("Hay un mensaje nuevo y es el siguiente %s", update.getMessage().getText());

        // TODO: escribiremos la funcionalidad principal del bot aquí
        sendTextMessageAsync("Hola cómo vas, bienvenido a este nuevo mundo!");

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}