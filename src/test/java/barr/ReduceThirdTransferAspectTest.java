package barr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReduceThirdTransferAspectTest {
    @Test
    void halvesWithdrawEveryThirdTransfer_only() {
        Account a = new Account("A", 1, 2000);
        Account b = new Account("B", 2, 0);

        MoneyTransferService svc = new MoneyTransferService();

        for (int i = 0; i < 3; i++) {
            svc.moneyTransfer(a, b, 100.0);
        }

        // 1: -100. 2: -100. 3: -50
        assertEquals(1750.00, a.getBalance(), 0.0001);
        assertEquals(300.00, b.getBalance(), 0.0001);
    }
}
