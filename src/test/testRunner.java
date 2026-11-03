package test;
import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class testRunner {

	// TODO Auto-generated method stub
	@Test
	public void SoapTest() throws XmlException, IOException, SoapUIException
{
		//Grab the project
		WsdlProject project= new WsdlProject ("C:\\Users\\mciri\\Downloads\\Employee.xml");
		//Grab the TestSuite in the project
		WsdlTestSuite testsuite=project.getTestSuiteByName("Testing");
		//Grab the TestCases in the TestSuite
		for(int i=0;i<testsuite.getTestCaseCount();i++)
		{
		WsdlTestCase testCase=testsuite.getTestCaseAt(i);
		//Run the TestCase
		TestRunner runner=testCase.run(new PropertiesMap(),false);
		Assert.assertEquals(Status.FINISHED, runner.getStatus());
		}

	}

}
