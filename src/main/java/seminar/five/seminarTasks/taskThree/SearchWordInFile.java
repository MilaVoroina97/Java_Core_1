package seminar.five.seminarTasks.taskThree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SearchWordInFile {

    public static void main(String[] args) throws IOException {
        searchWordInFile("the-file-name.txt","The");
    }

    public static void searchWordInFile(String path, String wordToFind) throws IOException, FileNotFoundException {

        File file = new File(path);
        List<String> saveAllLinesForRewriting = new ArrayList<String>();
        String savedLine;
        int count = 0;
        if(!file.exists())
            throw new FileNotFoundException("File not found");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((savedLine = reader.readLine()) != null){
                saveAllLinesForRewriting.add(savedLine);
            }
            for(String word : saveAllLinesForRewriting){
                if(word.equals(wordToFind))
                    count++;
            }
            if (count != 0) { // Check for count not equal to zero
                System.out.println("The given word: " + wordToFind + " is present for " + count
                        + " times in the file");
            } else {
                System.out.println("The given word is not present in the file");
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
