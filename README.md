# About
Author: Christen Barringer

This project uses Maven profiles to test individual AspectJ aspects. It uses load-time weaving to ensure only the relevant aspects are compiled and woven into the program.

Aspect code is within src/main/java/barr and test code is within src/test/java/barr. Profile information is within the `profiles` tag of pom.xml and in src/test/resources/aop.

# Aspects and Tests

The following aspects were created to modify the behavior of the MoneyTransferService. Use the command in the Command column to run the test for the aspect. 

| Assignment Item | Aspect | Test | Command | 
| ----- | ----- | ----- | --- |
| None | AroundAdviceAspect | AroundAdviceAspectTest | `mvn -P around-advice -Dtest=AroundAdviceAspectTest test` |
| None | MoneyTransferServiceAspect | MoneyTransferServiceAspectTest | `mvn -P money-transfer-service -Dtest=MoneyTransferServiceAspectTest test` |
| 1 | DoubleDepositByParamAspect | DoubleDepositByParamAspectTest | `mvn -P double-param -Dtest=DoubleDepositByParamAspectTest test` |
| 2 | DoubleDepositByBalanceAspect | DoubleDepositByBalanceAspectTest | `mvn -P double-balance -Dtest=DoubleDepositByBalanceAspectTest test` |
| 3 | TenPercentAspect | TenPercentAspectTest | `mvn -P ten-percent -Dtest=TenPercentAspectTest test` |
| 4 | ServiceFeeAspect | ServiceFeeAspectTest | `mvn -P service-fee -Dtest=ServiceFeeAspectTest test` | 
| 5 | PrintOnBalanceSetAspect | PrintOnBalanceSetAspectTest | `mvn -P balance-set -Dtest=PrintOnBalanceSetAspectTest test` |
| 6 | PrintEveryMethodAspect | PrintEveryMethodAspectTest | `mvn -P print-method -Dtest=PrintEveryMethodAspectTest test` |
| 7 | TieredBonusAspect | TieredBonusAspectTest | `mvn -P tiered-bonus -Dtest=TieredBonusAspectTest test` |
| 8 | ReduceThirdTransferAspect | ReduceThirdTransferAspectTest | `mvn -P third-transfer -Dtest=ReduceThirdTransferAspectTest test` |
| 9 | StealFromRecipientAspect | StealFromRecipientAspectTest | `mvn -P steal -Dtest=StealFromRecipientAspectTest test` |
| 9 | DrainAccountAspect | DrainAccountAspectTest | `mvn -P drain-account -Dtest=DrainAccountAspectTest test` |
| 9 | PerformanceStatsAspect | PerformanceStatsAspectTest | `mvn -P stats -Dtest=PerformanceStatsAspectTest test` |

## Custom Aspects (step 9)
- StealFromRecipientAspect reverses the transaction after it goes through. 
- DrainAccountAspect takes everything from the recipient, leaving them with $1.
- PerformanceStatsAspect tracks and prints statistics for each transfer by using inter-type fields.

# Credits
Credit to Tingshuo Miao for helping me fix my Maven profiles build issues.
