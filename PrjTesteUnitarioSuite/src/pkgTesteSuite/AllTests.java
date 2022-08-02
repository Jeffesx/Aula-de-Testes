package pkgTesteSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OperacoesTESTE.class, TemperaturaTeste.class })
public class AllTests {

}
