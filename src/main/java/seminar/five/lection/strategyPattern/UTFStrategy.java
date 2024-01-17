package seminar.five.lection.strategyPattern;

import java.util.Arrays;

public class UTFStrategy implements EncodingStrategy{
    @Override
    public String encode(byte[] data) {
        return Arrays.toString(data);
    }
}
