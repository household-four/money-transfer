package barr;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class PerformanceStatsAspectTest {

    @Test
    void statsAreUpdatedAcrossTransfers() throws Exception {
        Account a1 = new Account("A1", 1, 1_000.0);
        Account a2 = new Account("A2", 2, 1_000.0);
        MoneyTransferService svc = new MoneyTransferService();

        svc.moneyTransfer(a1, a2, 100.0);
        svc.moneyTransfer(a1, a2, 50.0);

        Field txCountF = MoneyTransferService.class.getField("__txCount");
        Field totalAmtF = MoneyTransferService.class.getField("__totalAmount");
        Field lastDurF = MoneyTransferService.class.getField("__lastDurationMs");

        long txCount = (long) txCountF.get(svc);
        double totalAmt = (double) totalAmtF.get(svc);
        long lastMs = (long) lastDurF.get(svc);

        assertTrue(fieldExists(txCountF, totalAmtF, lastDurF),
                "One or more inter-type members do not exist");
        assertEquals(2L, txCount, "tx count should increment per transfer");
        assertEquals(150.0, totalAmt, 1e-9, "total amount should accumulate");

        assertTrue(lastMs >= 0, "lastDurationMs should be non-negative");
    }

    private boolean fieldExists(Object... objs) {
        for (Object o : objs)
            if (o == null)
                return false;
        return true;
    }
}
