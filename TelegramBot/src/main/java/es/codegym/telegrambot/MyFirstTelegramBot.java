package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.awt.*;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "donGuillobot";//"agregue el nombre del bot entre comillas a continuación";
    public static final String TOKEN = "6726864810:AAECRXa97axdSY0i9dJlJsNRiv-dm6yrnzM";//"agregue el token del bot entre comillas a continuación"; -> https://core.telegram.org/bots/api

    //To test over a browser or a request use this https://api.telegram.org/bot<API>/getMe
    //https://core.telegram.org/bots/api#making-requests
    //https://core.telegram.org/bots/api#getting-updates

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    /*Esta es la respuesta a cada interacción a nuestro BOT*/
    public void onUpdateEventReceived(Update update) {

        //https://howtodoinjava.com/java/date-time/java8-datetimeformatter-example/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        String miNombre = getBotUsername();
        //formateando el string _italic_     *negrita*
        String message = "Hola _"+getCurrentClientUserName()+"_ son las "+LocalTime.now().format(dtf)+", mi nombre es *"+miNombre+"*, gracias por escribir --> "+getMessageText();
        System.out.println(message);

        // TODO: escribiremos la funcionalidad principal del bot aquí
        if ( getMessageText().equals("/start") ){
            sendTextMessageAsync("BIENVENIDO FUTURO PROGRAMADOR "+message);
        }

        if ( getMessageText().toUpperCase().contains("HOLA") ){
            sendTextMessageAsync("¿Cuál es tÚ nombre? "+ message);
        }

        if ( getMessageText().toUpperCase().contains("I NOMBRE ES") ){
            sendTextMessageAsync("Es un placer yo soy *GATO*");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}