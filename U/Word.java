import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alice Chan
 * Date: 11/15/2014
 * Description:
 * 		This class counts no. of words in a string and
 *      is assumed to be not case-sensitive (i.e. man == MAN).
 *      A string can be set by calling the constructor or setWordStr
 *      method. getWordCount() gives the count result of
 *      the string from the hashmap. The count is cumulative
 *      for each string passed into the method.
 *      Example:
 *      1. "the man in the moon" - result:
 *         HashMap: {moon=1, the=2, in=1, man=1}
 *      2. "the man on the moon" - result:
 *         HashMap: {moon=2, on=1, the=4, in=1, man=2}
 */

public class Word implements WordFrequency {
    private String wordStr;
    private Map<String, Integer> wordMap = new HashMap<>();

    //**************************************************
    // *  @param stringToEvaluate
    // *  Function: constructor
    //**************************************************
    public Word(String stringToEvaluate) {
        wordStr = stringToEvaluate;
    }

    //**************************************************
    // *  @param void
    // *  @return Boolean
    // *  Function: validate input string to make sure
    // *    no empty or null strings are processed
    //**************************************************
    public Boolean inputValidate() {
        Boolean isOK = true;
        try {
            if ((wordStr == null) || wordStr.equals("")) {
                isOK = false;
                throw new IllegalArgumentException();
            }
        } catch (Exception ex) {
            System.out.println("Exception caught: Test input string cannot be null or empty.");
        }
        return isOK;
    }

    //**************************************************
    // *  @param stringToEvaluate
    // *  Function: setter (set the string to be
    // *    evaluated)
    //**************************************************
    public void setWordStr(String stringToEvaluate) {
        wordStr = stringToEvaluate;
    }

    //**************************************************
    // *  @param void
    // *  @return String
    // *  Function: getter (get the string)
    //**************************************************
    public String getWordStr() {
        return wordStr;
    }

    //**************************************************
    // *  @param void
    // *  Function: print the hashmap that contains
    // *    the words and their associated counts
    //**************************************************
    public void printWordCount() {
        System.out.println("Printing count HashMap: " + wordMap);
    }

    //**************************************************
    // *  @param void
    // *  @return Map<String, Integer>
    // *  Function: return hashmap (key: words
    // *    values: their occurrences)
    //**************************************************
    public Map<String, Integer> getWordCount() {
        return countOccurrencesOfWordsWithin(wordStr);
    }

    //**************************************************
    // *  @param stringToEvaluate
    // *  @return Map<String, Integer>
    // *  Function: count number of words in a string
    // *    duplicates are grouped into the same key
    //**************************************************
    public synchronized Map<String, Integer> countOccurrencesOfWordsWithin(String stringToEvaluate) {
        String[] tokens;
        int tempCount = 0;

        Boolean inputIsOK = this.inputValidate();
        if (inputIsOK) {
            stringToEvaluate = stringToEvaluate.toLowerCase();
            tokens = stringToEvaluate.split(" ");

            for (String key: tokens) {
                if (!wordMap.containsKey(key)) {
                    // if the word is encountered first
                    // time, increment the count to 1
                    wordMap.put(key, 1);
                } else {
                    // if the word is seen again, get the
                    // count value with that key and increment
                    // the count by 1
                    tempCount = wordMap.get(key);
                    wordMap.put(key, ++tempCount);
                }
            }
        }

        return wordMap;
    }
}

