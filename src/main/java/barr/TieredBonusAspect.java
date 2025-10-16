package barr;

public aspect TieredBonusAspect {
    pointcut transferExec(MoneyTransferService s, Account from, Account to, double amt) :
    execution(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && this(s) && args(from, to, amt);


    after(MoneyTransferService s, Account from, Account to, double amt) : transferExec(s, from, to, amt) {
        double bonus = 0.0;
        if (amt > 5000.0) {
            bonus = amt * 0.10;
        } else if (amt >= 1000.0) {
            bonus = amt * 0.05;
        }

        if (bonus > 0.0) {
            from.deposit(bonus);
        }
    }   
}
