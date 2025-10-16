package barr;

public aspect PerformanceStatsAspect {

    public long MoneyTransferService.__txCount = 0;
    public double MoneyTransferService.__totalAmount = 0.0;
    public long MoneyTransferService.__lastDurationMs = 0;

    pointcut transferExec(MoneyTransferService s, Account a1, Account a2, double amt) :
        execution(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && this(s) && args(a1, a2, amt);

    void around(MoneyTransferService s, Account a1, Account a2, double amt) : transferExec(s, a1, a2, amt) {
        long t0 = System.nanoTime();
        try {
            proceed(s, a1, a2, amt);
        } finally {
            long dtMs = (System.nanoTime() - t0) / 1_000_000L;
            s.__lastDurationMs = dtMs;
            s.__txCount++;
            s.__totalAmount += amt;
            s.info(String.format("[STATS] tx=%d amt=%.2f took=%d ms", s.__txCount, amt, dtMs)); 
        }
    }
}
