
/**
 * Write a description of Part1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3);
        } else {
            return "";
        }
    }

    public void testSimpleGene() {
        // normal case
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        String result1 = findSimpleGene(dna1);
        System.out.println("DNA strand: " + dna1 + " -> Gene: " + result1);
        // case no "ATG"
        String dna2 = "AAAGCCCTAACTAGATTAAGAAACC";
        String result2 = findSimpleGene(dna2);
        System.out.println("DNA strand: " + dna2 + " -> Gene: " + result2);
        // case no "TAA"
        String dna3 = "AAATGCCCTAGCTAGATGAAGAAACC";
        String result3 = findSimpleGene(dna3);
        System.out.println("DNA strand: " + dna3 + " -> Gene: " + result3);
        // case no "ATG" and "TAA"
        String dna4 = "AAAGCCCTAACTAGACGAAGAAACC";
        String result4 = findSimpleGene(dna4);
        System.out.println("DNA strand: " + dna4 + " -> Gene: " + result4);
        // case "ATG" and "TAA" but not multiple of 3
        String dna5 = "AAATGCCCATAACTAGATGAAGAAACC";
        String result5 = findSimpleGene(dna5);
        System.out.println("DNA strand: " + dna5 + " -> Gene: " + result5);
    }

}
