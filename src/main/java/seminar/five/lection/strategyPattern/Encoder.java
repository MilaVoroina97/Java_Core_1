package seminar.five.lection.strategyPattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Encoder {

    private EncodingStrategy encodingStrategy;

    public void printEncoded(byte[] data){

        if(data.length == 0)
            throw new IllegalArgumentException("No data to encode");
        String encodedData = encodingStrategy.encode(data);
        System.out.println(encodedData);
    }
}
