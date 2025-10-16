package barr;

public aspect TenPercentAspect {

    pointcut depositInTransfer(Account to, double amt) :
    withincode(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && call(public void Account.deposit(double))
            && target(to) && args(amt);
    
    
        Object around(Account to, double amt) : depositInTransfer(to, amt) {
        double boosted = amt * 1.10d;
        return proceed(to, boosted);
    }
}
