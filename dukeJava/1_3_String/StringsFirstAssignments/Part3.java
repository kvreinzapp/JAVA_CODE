/**
 * Write a description of Part3 here.
 * 
 * @author Klaus Von Reinherz
 * @version 1.0.0
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int count = 0;
        int fromIndex = 0;

        while (true) {
            int index = stringb.indexOf(stringa, fromIndex);
            if (index == -1) {
                break;
            }
            count++;
            fromIndex = index + stringa.length();
        }

        return count == 2;
    }

    public String lastPart(String stringa, String stringb) {
        int firstOccurrence = stringb.indexOf(stringa);
        if (firstOccurrence == -1) {
            return stringb;
        }
        return stringb.substring(firstOccurrence + stringa.length());
    }

    public void testing() {
        String stringa = "by";
        String stringb = "A story by Abby Long";
        System.out
                .println("String A: " + stringa + " String B: " + stringb + " -> " + twoOccurrences(stringa, stringb));
        stringa = "a";
        stringb = "banana";
        System.out
                .println("String A: " + stringa + " String B: " + stringb + " -> " + twoOccurrences(stringa, stringb));
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out
                .println("String A: " + stringa + " String B: " + stringb + " -> " + twoOccurrences(stringa, stringb));
        stringa = "an";
        stringb = "banana";
        System.out.println("String A: " + stringa + " String B: " + stringb + " -> " + lastPart(stringa, stringb));
        stringa = "zoo";
        stringb = "forest";
        System.out.println("String A: " + stringa + "StringB: " + stringb + " -> " + lastPart(stringa, stringb));
    }

}
