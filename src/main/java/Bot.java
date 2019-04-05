import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public String getBotToken() {
        return "817030314:AAEe9q0qBy_2HioLa6DGZSRundvaXhv5u9Y";
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message.getText().equals("/130gr")){
            sendMsg(message.getChatId(),"Какое количество полос?");
        }
        else if (message.getText().equals("/myown")){
            sendMsg(message.getChatId(),"Откуда мне знать? Твоя же бумага...");
        }
        else {
            float kor = Float.parseFloat(message.getText());
            kor*=10;
            kor = Math.round(kor/18);
            kor /= 10;
            sendMsg(message.getChatId(),"Размер корешка "+ kor + "мм.");
        }
    }







    private void sendMsg(Long chatId, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }






    public String getBotUsername() {
        return "Расчёт корешка";
    }

}
