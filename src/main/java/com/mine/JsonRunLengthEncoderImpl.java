package com.mine;

/**
 * Created by nidhish on 5/6/15.
 */
public class JsonRunLengthEncoderImpl implements RunLengthEncoder {

    @Override public String encode(String input) {

        StringBuffer stringBuffer = new StringBuffer();

        int count = 0;

        char currentChar = input.charAt(0);

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != currentChar) {
                stringBuffer.append(count).append(currentChar);
                currentChar = input.charAt(i);
                count = 0;
            }

            count++;

        }

        if (count > 0) {
            stringBuffer.append(count).append(currentChar);
        }

        return stringBuffer.toString();
    }

    //    private String converToOutput( int count, char currentChar) {
    //	stringBuffer.append(count).append(currentChar);
    //    }
}
