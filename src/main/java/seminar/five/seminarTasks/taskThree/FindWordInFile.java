package seminar.five.seminarTasks.taskThree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FindWordInFile {

    public static void main(String[] args) throws IOException {
        byte[] byteArray = {65, 66, 67, 68};
        System.out.println(searchWord("The",Paths.get("the-file-name.txt")));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        InputStreamReader reader = new InputStreamReader(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int data;
        while ((data = reader.read()) != -1) {
            char ch = (char) data;
            outputStream.write(ch);
        }
        char[] charArray = outputStream.toString().toCharArray();

    }

    private static final int MAX_SIZE = 4 * 1024; // 4K - make this * 1024 to 4MB in a real system.

    private static String searchWord(String searchFor, Path path) throws IOException {
        final byte[] toSearch = searchFor.getBytes(StandardCharsets.UTF_8);
        StringBuilder report = new StringBuilder();
        int matches = 0;
        int lineCount = 0;
        int padding = 1; // need to scan 1 character ahead in case it is a word boundary
        boolean inWord = false;
        boolean scanToLineEnd = false;
        try(FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)){

            final long fileLength = channel.size();
            int pos = 0;
            while (pos < fileLength){
                long remaining = fileLength - pos;
                int tryMap = MAX_SIZE + toSearch.length + padding;
                int toMap = (int)Math.min(tryMap,remaining);
                int limit = tryMap == toMap ? MAX_SIZE : (toMap - toSearch.length);// different limits depending on whether we are the last mapped segment
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,pos,toMap);
                System.out.println("Mapped from " + pos + " for " + toMap);
                pos += (tryMap == toMap) ? MAX_SIZE : toMap;
                for(int i = 0; i < limit; i++){

                    final byte b = buffer.get(i);
                    if(scanToLineEnd){
                        if (b == '\n'){
                            scanToLineEnd = false;
                            inWord = false;
                            lineCount++;
                        }

                    }else if (b == '\n'){
                        lineCount++;
                        inWord = false;
                    }else if(b == '\r'|| b == ' '){
                        inWord = false;
                    }else if(!inWord){

                        if(wordMatch(buffer, i, toMap, toSearch)){
                            matches++;
                            i += toSearch.length - 1;
                            if(!report.isEmpty()){
                                report.append(", ");
                            }
                            report.append(lineCount);
                            scanToLineEnd = true;
                        }else
                            inWord = true;
                    }
                }
            }
        }

        return  "Times found at--" + matches + "\nWord found at--" + report;
    }

    public static boolean wordMatch(MappedByteBuffer buffer, int pos, int toMap, byte[] toSearch){
        for(int i = 0; i < toSearch.length; i++){
            if(toSearch[i] != buffer.get(pos + i))
                return false;
        }
        byte next = (pos + toSearch.length) == toMap ? (byte) ' ' : buffer.get(pos + toSearch.length);
        return next == ' ' || next == '\n' || next == '\r';
    }

}
