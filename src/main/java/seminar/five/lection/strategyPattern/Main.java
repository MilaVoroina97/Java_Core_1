package seminar.five.lection.strategyPattern;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        byte[] text = "Some data :)".getBytes();
        Encoder base64Encoder = new Encoder(data -> Base64.getEncoder().encodeToString(data));
        Encoder hexEncoder = new Encoder(data -> new BigInteger(1, data).toString(16));
        Encoder utfEncoder = new Encoder(Arrays::toString);
        base64Encoder.printEncoded(text);
        hexEncoder.printEncoded(text);
        utfEncoder.printEncoded(text);
    }

    interface NotificationStrategy {

        void notifyCustomer(User user);

    }

    class Notifier {

        private NotificationStrategy notificationStrategy;

        public Notifier(NotificationStrategy notificationStrategy) {

            this.notificationStrategy = notificationStrategy;

        }
        public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
            this.notificationStrategy = notificationStrategy;
        }

        public void sentNotificationToUser(User user){
             if(user == null)
                 throw new IllegalArgumentException("The user is empty");
             notificationStrategy.notifyCustomer(user);
        }
    }

    class Application {

        private EmailService emailService;
        private SMSService smsService;

        public Application(EmailService emailService, SMSService smsService) {
            this.emailService = emailService;
            this.smsService = smsService;
        }

        public void run(User user) {
            emailService.sendEmail(user);
            Notifier notifier = new Notifier(smsService::sendSMS);
            notifier.sentNotificationToUser(user);
        }
    }

    interface SMSService{

        void sendSMS(User user);
    }

    interface EmailService{

        void sendEmail(User user);
    }

    class User {
        private final String email;
        private final String phoneNumber;

        User(String email, String phoneNumber) {
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
