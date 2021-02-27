import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestRZ {

    @Test
    void test_RZ_1_info_messages_ex1() throws IOException {
        Assert.assertEquals(0, RZ_1_info_messages.ex1());
    }

    @Test
    void test_RZ_1_info_messages_ex2() {
        Assert.assertEquals(0, RZ_1_info_messages.ex2());
    }

}
