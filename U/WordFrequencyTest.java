import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alice Chan
 * Date: 11/15/2014
 * Description:
 * 		Self-checking testbench for Word class. The
 *      methods are more or less named by test+Word's methodName()
 */

public class WordFrequencyTest {
    private Word word = new Word("");

    @Test
    public void testExample() {
        //Assert.fail("Not yet implemented.");
    }

    @Test
    public void testInputValidation() {
        System.out.println(">>TEST to see if the input is validated to prevent empty or null strings.\n");

        word.setWordStr(null);
        Assert.assertFalse("Input null string validate Fail!", word.inputValidate());

        word.setWordStr("");
        Assert.assertFalse("Input empty string validate Fail!", word.inputValidate());

        word.setWordStr("Abc");
        Assert.assertTrue("Input non-empty string validate Fail!", word.inputValidate());
    }

    @Test
    public void testGetWordString() {
        System.out.println("\n>>TEST getWordStr method.\n");

        String expected = "abc";
        word.setWordStr("abc");
        String actual = word.getWordStr();
        Assert.assertEquals("Get word fail!", expected, actual);

    }

    @Test
    public void testSetWordString() {
        System.out.println("\n>>TEST setWordStr method.\n");

        word.setWordStr("I am very happy today");
        String expected = "I am very happy today";
        String actual = word.getWordStr();
        Assert.assertEquals("First set word fail!", expected, actual);

        word.setWordStr("this is a great story");
        expected = "this is a great story";
        actual = word.getWordStr();
        Assert.assertEquals("First set word fail!", expected, actual);
    }

    // test the occurences of words in a string
    // 1. set the word (setWordStr()) 2. get the word count result
    // (getWordCount()) 3. check the expected and the actual results
    @Test
    public void testCountOccurrencesOfWord() {
        Map<String, Integer> actualMap = new HashMap<>();

        System.out.println("\n>>TEST countOccurrencesOfWordsWithin method.\n");

        // first, "the man in the moon"
        word.setWordStr("the man in the moon");
        actualMap = word.getWordCount();
        word.printWordCount();

        Integer expected = 2;
        Assert.assertEquals("word 1a fail!", expected, actualMap.get("the"));
        expected = 1;
        Assert.assertEquals("word 1b fail!", expected, actualMap.get("man"));
        expected = 1;
        Assert.assertEquals("word 1c fail!", expected, actualMap.get("in"));
        expected = 1;
        Assert.assertEquals("word 1d fail!", expected, actualMap.get("moon"));

        // then, "the man on the moon" is passed
        word.setWordStr("the man on the moon");
        word.getWordCount();
        word.printWordCount();

        expected = 4;
        Assert.assertEquals("word 2a fail!", expected, actualMap.get("the"));
        expected = 2;
        Assert.assertEquals("word 2b fail!", expected, actualMap.get("man"));
        expected = 1;
        Assert.assertEquals("word 2c fail!", expected, actualMap.get("in"));
        expected = 1;
        Assert.assertEquals("word 2d fail!", expected, actualMap.get("on"));
        expected = 2;
        Assert.assertEquals("word 2e fail!", expected, actualMap.get("moon"));

        // then, "the man is under the moon" is passed
        word.setWordStr("the man is under the moon");
        word.getWordCount();
        word.printWordCount();
        expected = 6;
        Assert.assertEquals("word 3a fail!", expected, actualMap.get("the"));
        expected = 3;
        Assert.assertEquals("word 3b fail!", expected, actualMap.get("man"));
        expected = 1;
        Assert.assertEquals("word 3c fail!", expected, actualMap.get("is"));
        expected = 1;
        Assert.assertEquals("word 3d fail!", expected, actualMap.get("under"));
        Assert.assertEquals("word 3e fail!", expected, actualMap.get("in"));
        expected = 1;
        Assert.assertEquals("word 3f fail!", expected, actualMap.get("on"));
        expected = 3;
        Assert.assertEquals("word 3g fail!", expected, actualMap.get("moon"));

        // then, "the man on the moon" is passed
        // test if Uppercase to be recognized as the same word
        word.setWordStr("the MAN ON the moon");
        word.getWordCount();
        word.printWordCount();
        expected = 8;
        Assert.assertEquals("word 4a fail!", expected, actualMap.get("the"));
        expected = 4;
        Assert.assertEquals("word 4b fail!", expected, actualMap.get("man"));
        expected = 1;
        Assert.assertEquals("word 4c fail!", expected, actualMap.get("is"));
        expected = 1;
        Assert.assertEquals("word 4d fail!", expected, actualMap.get("under"));
        Assert.assertEquals("word 4e fail!", expected, actualMap.get("in"));
        expected = 2;
        Assert.assertEquals("word 4f fail!", expected, actualMap.get("on"));
        expected = 4;
        Assert.assertEquals("word 4g fail!", expected, actualMap.get("moon"));

    }
}
