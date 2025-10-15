package barr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;

public class AroundAdviceAspectTest {

    @Test
    void aroundAdviceAspectTest() throws Exception {
        Method maybeLogMethod = null;
        for (Method m : MoneyTransferService.class.getMethods()) {
            if (m.getName().equals("logTrans")) {
                maybeLogMethod = m;
                break;
            }
        }
        assertNotNull(maybeLogMethod, "Expected additionalmethod 'logTrans' not found in MoneyTransferService");
    }
}
