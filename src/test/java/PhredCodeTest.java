import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhredCodeTest {

    @Test
    void toQuality() {
    }

    @Test
    void toProbability() {
    }

    @Test
    void encode() {
    }

    @Test
    void encodeMany() {
    }

    @Test
    void decode() {
    }

    @Test
    void decodeMany() {
    }

    @Test
    void decodeManyDecodes33() {
        String data = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}";
        PhredCode decoder = new PhredCode(33);
        int[] qualities = decoder.decodeMany(data);
        for (int i = 0; i < data.length(); i++) {
            assertEquals(i, qualities[i]);
        }
    }
}