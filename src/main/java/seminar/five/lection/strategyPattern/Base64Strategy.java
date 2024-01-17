package seminar.five.lection.strategyPattern;

import java.util.Base64;

public class Base64Strategy implements EncodingStrategy{
    @Override
    public String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
