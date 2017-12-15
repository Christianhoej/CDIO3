package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAktivbeholdning.class, TestSpiller.class, TestTaber.class, TestVinder.class })
public class AllTests {
	
}
