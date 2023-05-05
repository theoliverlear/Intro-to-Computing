import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class TestPasswordCracker {
    int testPasswordLength;
    int testCharacterSetSize;
    double testAttemptsPerSecond;
    double testTimeToCrack;
    @Test
    public void testCrackPasswordInput() {
        //Test variables should equal 92 seconds
        testPasswordLength = 1;
        testCharacterSetSize = 92;
        testAttemptsPerSecond = 1;
        assertThat(92.0, equalTo(testTimeToCrack =
                (Math.pow(testCharacterSetSize, testPasswordLength)
                        / testAttemptsPerSecond)));
        //Test variables should equal 2,000 seconds
        testPasswordLength = 2;
        testCharacterSetSize = 100;
        testAttemptsPerSecond = 5;
        assertThat(2000.0, equalTo(testTimeToCrack =
                (Math.pow(testCharacterSetSize, testPasswordLength)
                        / testAttemptsPerSecond)));
        //Test variables should equal 6,568,408,355,712,890,625,000,000,000,000
        //                                                              seconds
        testPasswordLength = 16;
        testCharacterSetSize = 150;
        testAttemptsPerSecond = 10000;
        assertThat(6568408355712890625000000000000.0, equalTo(testTimeToCrack
                = (Math.pow(testCharacterSetSize, testPasswordLength)
                / testAttemptsPerSecond)));
    }
}
