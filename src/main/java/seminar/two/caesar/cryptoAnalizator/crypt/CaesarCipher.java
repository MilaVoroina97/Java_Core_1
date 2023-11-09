package seminar.two.caesar.cryptoAnalizator.crypt;

public class CaesarCipher {

    private final CaesarAlphabet alphabet;


    public CaesarCipher(CaesarAlphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String originalText, int key){

        return process(originalText,key);
    }

    public String decrypt(String originalText, int key){

        return process(originalText,-key);
    }


    /**
     * Метод шифрования текста с помощью шифра Цезаря
     * @param orginalText  оригинальный текст для дальнейшего преобразования в шифр
     * @param key   число сдвигов по алфавиту
     * @return  возвращает зашифрованный текст относительно указанного числа сдвигов
     */

    private String process(String orginalText, int key){

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < orginalText.length(); i++){
            Character originalCharacter = toLowerCase(orginalText.charAt(i));
            int originalCharIndex = alphabet.getCharIndex(originalCharacter);
            int newIndex = (alphabet.getAlphabetSize() + (originalCharIndex + key)) % alphabet.getAlphabetSize();

            stringBuilder.append(alphabet.getCharByIndex(newIndex));
        }

        return stringBuilder.toString();
    }

    private Character toLowerCase(Character character){
        return (character + "").toLowerCase().charAt(0);
    }
}
