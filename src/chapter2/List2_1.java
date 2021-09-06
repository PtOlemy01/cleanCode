package chapter2;

public class List2_1 {
    // 맥락이 불분명한 변수
    private void printGuessStatistics(char candidate, int count){
        String number;
        String verb;
        String pluralModifier;

        if(count == 0){
            number = "no";
            verb = "are";
            pluralModifier = "s";
        }else if (count == 1){
            number = "1";
            verb = "is";
            pluralModifier = "";
        }else{
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
        print(guessMessage);

    }

    private void print(String guessMessage) {
        System.out.println(guessMessage);

    }
}
