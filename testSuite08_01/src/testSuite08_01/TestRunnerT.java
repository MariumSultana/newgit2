package testSuite08_01;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerT {
public static void main(String[] args) {
	Result r = JUnitCore.runClasses(TestSuitesT.class);
	for(Failure f : r.getFailures()){
		System.out.println(f.toString());
	}
	System.out.println(r.wasSuccessful());
}
}
