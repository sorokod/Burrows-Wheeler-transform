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
        assertDecode("abaaba", "abba$aa");
        assertDecode("abaaba", "abba\u0000aa");
    }

    @Test
    public void decode_tomorrow() {
        assertDecode("Tomorrow_and_tomorrow_and_tomorrow", "w$wwdd__nnoooaattTmmmrrrrrrooo__ooo");
        assertDecode("Tomorrow_and_tomorrow_and_tomorrow", "w\u0000wwdd__nnoooaattTmmmrrrrrrooo__ooo");
    }

    @Test
    public void decode_morning() {
        assertDecode("in_the_jingle_jangle_morning_Ill_come_following_you", "u_gleeeengj_mlhl_nnnnt$nwj__lggIolo_iiiiarfcmylo_oo_");
        assertDecode("in_the_jingle_jangle_morning_Ill_come_following_you", "u_gleeeengj_mlhl_nnnnt\u0000nwj__lggIolo_iiiiarfcmylo_oo_");
    }

    private void assertDecode(String expected, String input) {
        assertEquals(expected, coder.decode(input));
    }
}
