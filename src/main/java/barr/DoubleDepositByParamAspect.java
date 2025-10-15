package barr;

public aspect DoubleDepositByParamAspect {

    pointcut depositInTransfer(Account to, double amt) :
    withincode(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && call(public void Account.deposit(double))
            && target(to) && args(amt);
    
    
    Object around(Account to, double amt) : depositInTransfer(to, amt) {
        return proceed(to, amt * 2.0);
    }
}
