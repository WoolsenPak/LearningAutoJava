package module4.HomeWork2UnitTests;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Runner {

    public static void main(String[] args) {
        TestNG testNg = new TestNG();
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setSuiteFiles(asList ("src/Java/resources/testNg.xml"));

        xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);
        xmlSuite.setThreadCount(2);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(xmlSuite);
        testNg.setXmlSuites(suites);

        System.out.println("Запустились тесты");

        testNg.run();

        System.out.println("Тесты окончены");
    }
}
