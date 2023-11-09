package seminar.two.caesar.cryptoAnalizator;

import seminar.two.caesar.cryptoAnalizator.consoleui.ConsoleDialogue;
import seminar.two.caesar.cryptoAnalizator.consoleui.Dialogue;

public class Application extends Object{

    public static void main(String[] args) {
        Dialogue dialogue = new ConsoleDialogue();
        dialogue.start();
    }
}
