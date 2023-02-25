package example;

import org.junit.jupiter.api.*;


public class MainTest {


    @BeforeEach
    public void logTestStart(TestInfo testInfo) {
        System.out.println("********************************************************************************");
        System.out.println("<<< Test method: " + testInfo.getTestMethod().orElseThrow() + " was started >>>");
        System.out.println("********************************************************************************");

    }

    @AfterEach
    public void logTestFinish(TestInfo testInfo) {
        System.out.println("********************************************************************************");
        System.out.println("<<< Test method: " + testInfo.getTestMethod().orElseThrow() + " was finished >>>");
        System.out.println("********************************************************************************");

    }

    @Test
    @Tag("smoke")
    public void example1Test() {
        Assertions.assertEquals(1 + 1, 2);
    }

    @Test
    @Tag("regress")
    public void example2Test() {
        Assertions.assertEquals(1 + 1, 3);
    }

    @Test
    @Tag("smoke")
    public void example3Test() {
        if (System.getProperty("test_figure_prop1") != null && (!System.getProperty("test_figure_prop1").isEmpty())) {
            int a = Integer.parseInt(System.getProperty("test_figure_prop1"));
            int b = Math.abs(a);
            System.out.println("Value a = " + a);
            System.out.println("Value b = " + b) ;
            Assertions.assertEquals(Math.abs(a), b);
        } else  throw new IllegalArgumentException("Need to add Sys prop <test_figure_prop1>");
    }
}