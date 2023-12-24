package seminar.five.seminarTasks.taskThree;

import java.io.*;

public class SearchWordInFile {

    public static void main(String[] args) throws IOException {
        searchWordInFile("the-file-name.txt", "The");
    }

    public static void searchWordInFile(String path, String wordToFind) throws IOException, FileNotFoundException {

        File file = new File(path);
        String[] words = null;
        String savedLine;
        String lineNumber = "";
        int count = 0, countBuffer = 0, countLine = 0;
        if (!file.exists())
            throw new FileNotFoundException("File not found");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((savedLine = reader.readLine())!= null){
                countLine++;
                words = savedLine.split(" ");
                for(String word : words){
                    if(word.equals(wordToFind)){
                        count++;
                        countBuffer++;
                    }
                }if(countBuffer > 0){
                    countBuffer = 0;
                    lineNumber += countLine + ",";

                }
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Times found at--"+count);
        System.out.println("Word found at--"+lineNumber);
    }
}