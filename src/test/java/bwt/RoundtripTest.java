package bwt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundtripTest {

    private Decoder decoder;
    private Encoder encoder;

    @Before
    public void before() {
        decoder = new Decoder();
        encoder = new Encoder();
    }

        @Test
    public void decode_pixie() {
        assertEncodeDecode("SIX.MIXED.PIXIES.SIFT.SIXTY.PIXIE.DUST.BOXES$");
    }

    @Test
    public void decode_abaaba() {
        assertEncodeDecode("abaaba$");
        assertEncodeDecode("abaaba\u0000");
    }

    @Test
    public void encodeDecode_tomorrow() {
        assertEncodeDecode("Tomorrow_and_tomorrow_and_tomorrow$");
        assertEncodeDecode("Tomorrow_and_tomorrow_and_tomorrow\u0000");
    }

    @Test
    public void decode_morning() {
        assertEncodeDecode("in_the_jingle_jangle_morning_Ill_come_following_you$");
        assertEncodeDecode("in_the_jingle_jangle_morning_Ill_come_following_you\u0000");
    }


    private void assertEncodeDecode(String str) {
        assertEquals(str.substring(0, str.length()-1), decoder.decode(encoder.encode(str)));
    }


}
