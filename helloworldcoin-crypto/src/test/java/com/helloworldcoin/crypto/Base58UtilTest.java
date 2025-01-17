package com.helloworldcoin.crypto;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class Base58UtilTest {


    @Test
    public void encodeTest()
    {
        assertEquals("JxF12TrwUP45BMd", Base58Util.encode("Hello World".getBytes(StandardCharsets.UTF_8)));

        BigInteger bi = BigInteger.valueOf(3471844090L);
        assertEquals("16Ho7Hs", Base58Util.encode(bi.toByteArray()));

        assertEquals("1", Base58Util.encode(new byte[1]));
        assertEquals("1111111", Base58Util.encode(new byte[7]));

        assertEquals("", Base58Util.encode(new byte[0]));
    }

    @Test
    public void decodeTest()
    {
        assertArrayEquals(new byte[1], Base58Util.decode("1"));
        assertArrayEquals(new byte[4], Base58Util.decode("1111"));

        assertArrayEquals("Hello World".getBytes(StandardCharsets.UTF_8), Base58Util.decode("JxF12TrwUP45BMd"));
        assertEquals(0, Base58Util.decode("").length);
    }


    @Test
    public void base58Test()
    {
        Random random = new Random();
        for (int j = 1; j < 1000; j++) {
            byte[] test = new byte[j];
            random.nextBytes(test);
            assert Arrays.equals(test, Base58Util.decode(Base58Util.encode(test)));

            //Contains only 123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz
            assert Pattern.matches("^[123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz]*$", Base58Util.encode(test));
        }
    }

}
