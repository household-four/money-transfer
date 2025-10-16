# About
Author: Christen Barringer

Uses Maven profiles to test individual AspectJ aspects. 

# Aspects and Tests
| Assignment Item | Aspect | Test | Command | 
| ----- | ----- | ----- | --- |
| None | AroundAdviceAspect | AroundAdviceAspectTest | `mvn -P around-advice -Dtest=AroundAdviceAspectTest test` |
| None | MoneyTransferServiceAspect | MoneyTransferServiceAspectTest | `mvn -P money-transfer-service -Dtest=MoneyTransferServiceAspectTest test` |
| 1 | DoubleDepositByParamAspect | DoubleDepositByParamAspectTest | `mvn -P double-param -Dtest=DoubleDepositByParamAspectTest test` |
| 2 | DoubleDepositByBalanceAspect | DoubleDepositByBalanceAspectTest | `mvn -P double-balance -Dtest=DoubleDepositByBalanceAspectTest test` |
| 3 | TenPercentAspect | TenPercentAspectTest | `mvn -P ten-percent -Dtest=TenPercentAspectTest test` |
| 4 | ServiceFeeAspect | ServiceFeeAspectTest | `mvn -P service-fee -Dtest=ServiceFeeAspectTest test` | 
| 5 | PrintOnBalanceSetAspect | PrintOnBalanceSetAspectTest | `mvn -P balance-set -Dtest=PrintOnBalanceSetAspectTest test` |
| 6 |  |  |  |
| 7 |  |  |  |
| 8 |  |  |  |
| 9 |  |  |  |

# Credits
Credit to Tingshuo Miao for helping me fix my Maven profiles build issues.
