package seminar.two.caesar;


/* Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифрования и числовым ключом
* */
public class CaesarCipherSimple {

    public static String encrypt(String message, int shiftKey){
        StringBuilder encryptedMessage = new StringBuilder(); //создание пустой строки, которая будет содержать зашифрованное сообщение
        for(int i = 0; i < message.length(); i++){
            char currentChar = message.charAt(i); //перебираем каждый символ  в исходном сообщении
            if(Character.isLetter(currentChar)){ //на каждом этапе проверяем, является ли текущий символ буквой

                /* 1. Вычитаем значение символа ‘A’ из текущего символа, для того чтобы получить относительное
                значение символа в алфавите
                2. Затем добавляем ключ сдвига к относительному значению и берем остаток деления от 26, для
                того чтобы гарантировать нахождение нового символа в пределах алфавита
                3. Напоследок добавляем значение символа ‘A’ к полученному относительному значению символа
                * */

                char encryptedChar = (char) ((currentChar  + shiftKey- 'A') % 26 +'A');
                encryptedMessage.append(encryptedChar);

            }else{
                encryptedMessage.append(currentChar);
            }
        }
        return encryptedMessage.toString();
    }


    public static String decrypt(String message, int shiftKey){
        StringBuilder decryptedMessage = new StringBuilder();
        for(int i  = 0; i < message.length(); i++){
            char currentChar  = message.charAt(i);
            if(Character.isLetter(currentChar)){

                char decryptedChar = (char) ((currentChar - shiftKey - 'A' + 26) % 26 + 'A');
                /* Вычитаем ключ сдвига из текущего символа, для того чтобы получить обратное относительное
                значение символа в алфавите
                * */

                decryptedMessage.append(decryptedChar);

            }else{
                decryptedMessage.append(currentChar);
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {

        String message = "HELLO";
        int shiftKey = 3;

        String encryptedMessage = encrypt(message, shiftKey);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shiftKey);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

}
