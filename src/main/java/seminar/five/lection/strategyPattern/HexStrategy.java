package seminar.five.lection.strategyPattern;

import java.math.BigInteger;

public class HexStrategy implements EncodingStrategy{
    @Override
    public String encode(byte[] data) {
        return new BigInteger(1, data).toString(16);
    }
}
