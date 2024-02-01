package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.awt.*;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

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

        // TODO: escribiremos la funcionalidad principal del bot aquí
        if ( getMessageText().equals("/start") ){
            setUserGlory(0);//Primero vamos a dar puntos por ingresar
            System.out.println("yeah paso 1");
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera, +20 de fama","step_1_btn"));//Vamos a traer variables de otra clase - CREANDO UN BOTÓN: Título del botón e identificador del botón
        }

        //Que pasa si se da click en un botón...
        if( getCallbackQueryButtonKey().equals("step_1_btn") ){
            setUserGlory(getUserGlory()+20);
            System.out.println("yeah paso 2 -> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20 de fama", "step_2_btn",
                            "¡Tomar un pescado! +20 de fama", "step_2_btn",
                            "¡Tomar una lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        //Que pasa si se da click en otro botón...
        if( getCallbackQueryButtonKey().equals("step_2_btn") ){
            setUserGlory(getUserGlory()+20);
            System.out.println("yeah paso 3-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear el robot aspiradora +30 de fama", "step_3_btn"));
        }

        //Que pasa si se da click en un botón...
        if( getCallbackQueryButtonKey().equals("step_3_btn") ){
            setUserGlory(getUserGlory()+30);
            System.out.println("yeah paso 4-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspitador por comida +30 de fama", "step_4_btn",
                            "Dar un paseo encima del robot +30 de fama", "step_4_btn",
                            "Huir del robot aspiradora +30 de fama", "step_4_btn"));
        }

        //Que pasa si se da click en otro botón...
        if( getCallbackQueryButtonKey().equals("step_4_btn") ){
            setUserGlory(getUserGlory()+30);
            System.out.println("yeah paso 5-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Ponerse la GoPro y encenderla +40 de fama", "step_5_btn"));
        }

        //Que pasa si se da click en otro botón...
        if( getCallbackQueryButtonKey().equals("step_5_btn") ){
            setUserGlory(getUserGlory()+40);
            System.out.println("yeah paso 6-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Correr por los tejados +40 de fama", "step_6_btn",
                            "Atacar a otros gatos +40 de fama", "step_6_btn",
                            "Atacar a unos perrors +40 de fama", "step_6_btn"));
        }

        //Que pasa si se da click en otro botón...
        if( getCallbackQueryButtonKey().equals("step_6_btn") ){
            setUserGlory(getUserGlory()+30);
            System.out.println("yeah paso 7-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la contraseña de la computadora +50 de fama", "step_7_btn"));
        }

        //Que pasa si se da click en otro botón...
        if( getCallbackQueryButtonKey().equals("step_7_btn") ){
            setUserGlory(getUserGlory()+50);
            System.out.println("yeah paso 8-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Convertirse en gato hacker finalmente", "step_8_btn"));
        }

        //Que pasa si se da click en otro botón...
        if( getCallbackQueryButtonKey().equals("step_8_btn") ){
            setUserGlory(getUserGlory());
            System.out.println("yeah paso 9-> "+getUserGlory()+" puntos");
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT, Map.of());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}