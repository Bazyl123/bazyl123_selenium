import junit.framework.Assert;
import org.junit.*;

/**
 * Created by Administrator on 2015-02-09.
 */
public class SampleTest {
    @Before
    public void printStuffBefore(){
        System.out.println("@BEFORE");
    }

    @BeforeClass
    public static void printStuffBeforeClass(){
        System.out.println("@BEFORE_CLASS");
    }

    @After
    public void printStuffAfter(){
        System.out.println("@AFTER");
    }

    @AfterClass
    public static void printStuffAfterClass(){
        System.out.println("@AFTER_CLASS");
    }


    @Test
    public void printStuff1() {
        System.out.println("TEST1");

    }

    @Test
    public void printStuff2() {
        System.out.println("TEST2");

    }

    @Test
    public void printStuff3() {
        System.out.println("TEST3");
    }
}