
package barr; 

public aspect DoubleDepositByBalanceAspect {

    pointcut depositCall(Account to, double amt) :
    withincode(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && call(public void Account.deposit(double))
            && target(to) && args(amt);
    
    
    after(Account to, double amt) : depositCall(to, amt) {
        to.deposit(amt);
    }
}