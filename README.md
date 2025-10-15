# About
Author: Christen Barringer

I am trying to use Maven profiles to test individual AspectJ aspects. 

This is an example of the command I am using. This example should test the AroundAdviceAspect: 

```
mvn -P around-advice -Dtest=AroundAdviceAspectTest test
```

However, I get one of two results each time I run this:
1. The test runs but fails (unable to see the 'logTrans' method in the class)
2. The test does not run (compiler error)


```sh
# Situation 1
[ERROR] Failed to execute goal org.codehaus.mojo:aspectj-maven-plugin:1.15.0:test-compile (default) on project moneytransfer: AJC compiler errors:
[ERROR] error unrecognized single argument: "-17"
[ERROR] error no sources specified
```

```sh
# Situation 2
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.031 s <<< FAILURE! -- in barr.AroundAdviceAspectTest
[ERROR] barr.AroundAdviceAspectTest.aroundAdviceAspectTest -- Time elapsed: 0.014 s <<< FAILURE!
org.opentest4j.AssertionFailedError: Expected additionalmethod 'logTrans' not found in MoneyTransferService ==> expected: not <null> 
```

The following files may not be modified (according to the assignment instructions):
`Account.java`, `MoneyTransferService.java`, `AroundAdviceAspect.java`, and `MoneyTransferServiceAspect.java`.
