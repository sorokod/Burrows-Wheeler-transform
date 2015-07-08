package bwt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecoderTest {
    private Decoder coder;

    @Before
    public void before() {
        coder = new Decoder();
    }

    @Test
    public void decode_abaaba() {
        assertDecode("abaaba$", "abba$aa", '$');
        assertDecode("abaaba\u0000", "abba\u0000aa");
        assertDecode("abaaba\u0000", "abba\u0000aa", '\u0000');
    }

    @Test
    public void decode_tomorrow() {
        assertDecode("Tomorrow_and_tomorrow_and_tomorrow$", "w$wwdd__nnoooaattTmmmrrrrrrooo__ooo", '$');
        assertDecode("Tomorrow_and_tomorrow_and_tomorrow\u0000", "w\u0000wwdd__nnoooaattTmmmrrrrrrooo__ooo", '\u0000');
    }

    @Test
    public void decode_morning() {
        assertDecode("in_the_jingle_jangle_morning_Ill_come_following_you$", "u_gleeeengj_mlhl_nnnnt$nwj__lggIolo_iiiiarfcmylo_oo_", '$');
        assertDecode("in_the_jingle_jangle_morning_Ill_come_following_you\u0000", "u_gleeeengj_mlhl_nnnnt\u0000nwj__lggIolo_iiiiarfcmylo_oo_", '\u0000');
    }

    private void assertDecode(String expected, String input) {
        assertEquals(expected, coder.decode(input));
    }


    private void assertDecode(String expected, String input, char terminator) {
        assertEquals(expected, coder.decode(input, terminator));
    }
}
