package barr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TieredBonusAspectTest {
    @Test
    void tieredBonusCreditedToSource() {
        Account a = new Account("A", 1, 10000);
        Account b = new Account("B", 2, 0);
        MoneyTransferService svc = new MoneyTransferService();
        svc.moneyTransfer(a, b, 6000.0);

        assertEquals(4600.0, a.getBalance(), 0.0001);
        assertEquals(6000.0, b.getBalance(), 0.0001);
    }

    @Test
    void tieredBonusFivePercent() {
        Account a = new Account("A", 1, 10000);
        Account b = new Account("B", 2, 0);
        MoneyTransferService svc = new MoneyTransferService();
        svc.moneyTransfer(a, b, 3000.0);
        assertEquals(10000.0 - 3000.0 + 150.0, a.getBalance(), 0.0001);
        assertEquals(3000.0, b.getBalance(), 0.0001);
    }
}
