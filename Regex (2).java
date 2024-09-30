package week14;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
  static String input = "The gray sky lights up with occasional flashes among rolling hills of wispy gray clouds. The dull gray sky was interrupted by moments of a peaceful twilight storm.";
  static String [] inputArray = {"CCQQ", "QQCC", "CQQ", "QUACK", "CCQ", "CQC", "CQQQ", "CCCQQ"};
  static String date = "Today's date is 2024-05-19.";
  static String text = "The quick brown fox jumps over the lazy dog.";

  public static void main(String[] args) {
      //Task 1
     String regex = "grey | gray";
    Matcher matcher = Pattern.compile(regex).matcher(input);

    int counter = 0;
    while (matcher.find())
      counter++;
    System.out.println("counter = " + counter);
    
    //Task 2
    String regexText = "\\b\\w+\\b";
     Matcher matcherText = Pattern.compile(regexText).matcher(text);
      while (matcherText.find()){
        System.out.println("matcherText words = " + matcherText.group());
      }

      //Task 3
      String regexDate = "(\\d{4})-(\\d{1,2})-(\\d{2})";
      Matcher matcherDate = Pattern.compile(regexDate).matcher(date);
      while (matcherDate.find()){
        System.out.println("Year: " + matcherDate.group(1));
        System.out.println("Month: " + matcherDate.group(2));
        System.out.println("Day: " + matcherDate.group(3));
      }
      //Task 4
      String regexReplace = "dog";
      text = text.replaceAll(regexReplace, "cat");
    System.out.println("text replacement:  " + text);

    //Task 5 solution 1:
      String regexArray = "CQ{2}";
      Pattern pattern = Pattern.compile(regexArray);
      Matcher matcherArray;


      counter = 0;
      for(String elem : inputArray){
          matcherArray = pattern.matcher(elem);
          if(matcherArray.find())
              counter++;
      }
      System.out.println("Fonded Matched Element: " + counter);

      //Task 5 solution 2:

      AtomicInteger counterElem = new AtomicInteger();
      Arrays.stream(inputArray).forEach(elem->{
          if(pattern.matcher(elem).find())
              counterElem.getAndIncrement();
      });
      System.out.println("Fonded Matched Element: " + counterElem);
  }
}
