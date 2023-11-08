package seminar.two.caesar.cryptoAnalizator.crypt;

import seminar.two.caesar.cryptoAnalizator.crypt.exception.CaesarAlphabetException;

import java.util.*;

/**
 * Класс для работы с логикой операций над алфавитом
 */

public class CaesarAlphabet {

    // TODO продумать иерархию классов и интерфейсов для того, чтобы можно было выстраивать различную реализацию
    // символов для шифрования (например, добавить шифрование китайским символами и т.д.)
    private static final Character[] RU_ALPHABET = {'а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я'};

    private static final Character[] EN_ALPHABET = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private static final Character[] SYMBOL_ALPHABET = {'.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ',
    '/', '(', ')', '|', '&', '%', '<', '>', ';', '$', '^', '*', '+', '~',
            '@','-', '=', '#', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    // TODO продумать возможность изменить список на мап для более быстрого доступа к символам
    private final List<Character> alphabet;

    private final Map<Character, Integer> charIndexes;

    public CaesarAlphabet() {

        List<Character> temporaryAlphabet = new ArrayList<>();
        temporaryAlphabet.addAll(Arrays.asList(RU_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(EN_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(SYMBOL_ALPHABET));

        this.alphabet = List.copyOf(temporaryAlphabet); //List.copyOf возвращает immutable список

        this.charIndexes = new HashMap<>();


         /*
         * Заполняем словарь всеми символами и их индексами
         * */

        for(int i = 0; i < alphabet.size(); i++){

            charIndexes.put(alphabet.get(i),i);
        }
    }

    /**
     * Метод поиска символа алфавита по индексу
     * @param index  индекс искомой буквы алфавита
     * @throws CaesarAlphabetException  выбрасываем исключение, если искомый индекс выходит за рамки
     */

    public Character getCharByIndex(int index){

        if(index < 0 || index > alphabet.size()){
            throw new CaesarAlphabetException("Invalid index. Index: " + index + "Valid index should be from 0 to "
            + alphabet.size());
        }
        return alphabet.get(index);

    }

    /**
     * Метод поиска символа алфавита по индексу
     * @param character  буква для поиска ее индекса
     * @throws CaesarAlphabetException  выбрасываем исключение, если искомый индекс выходит за рамки
     */

    public int getCharIndex(Character character){

        if(!charIndexes.containsKey(character)){

            throw new CaesarAlphabetException("Such character doesn't exists. Character : " + character);
        }
        return charIndexes.get(character);
    }

    public int getAlphabetSize(){
        return this.alphabet.size();
    }

}
