package bwt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncoderTest {

    private Encoder coder;

    @Before
    public void before() {
        coder = new Encoder();
    }

    @Test
    public void encode_pixie() {
        assertEncode("TEXYDST.E.IXIXIXXSSMPPS.B..E.\u0000.EUSFXDIIOIIIT", "SIX.MIXED.PIXIES.SIFT.SIXTY.PIXIE.DUST.BOXES");
    }

    @Test
    public void encode_abaaba() {
        assertEncode("abba$aa", "abaaba$", '$');
        assertEncode("abba\u0000aa", "abaaba\u0000");
        assertEncode("abba\u0000aa", "abaaba\u0000", '\u0000');
    }

    @Test
    public void encode_tomorrow() {
        assertEncode("w$wwdd__nnoooaattTmmmrrrrrrooo__ooo", "Tomorrow_and_tomorrow_and_tomorrow$", '$');
        assertEncode("w\u0000wwdd__nnoooaattTmmmrrrrrrooo__ooo", "Tomorrow_and_tomorrow_and_tomorrow\u0000", '\u0000');
    }

    @Test
    public void encode_morning() {
        assertEncode("u_gleeeengj_mlhl_nnnnt$nwj__lggIolo_iiiiarfcmylo_oo_", "in_the_jingle_jangle_morning_Ill_come_following_you$", '$');
        assertEncode("u_gleeeengj_mlhl_nnnnt\u0000nwj__lggIolo_iiiiarfcmylo_oo_", "in_the_jingle_jangle_morning_Ill_come_following_you\u0000", '\u0000');
    }


    private void assertEncode(String expected, String input) {
        assertEquals(expected, coder.encode(input));
    }

    private void assertEncode(String expected, String input, char terminator) {
        assertEquals(expected, coder.encode(input, terminator));
    }

}
