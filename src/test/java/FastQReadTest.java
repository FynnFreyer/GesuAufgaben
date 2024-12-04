import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastQReadTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void decodePhred33() {
        String data = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}";
        int[] qualities = FastQRead.decodePhred33(data);
        for (int i = 0; i < data.length(); i++) {
            assertEquals(i, qualities[i]);
        }
    }
}