/**
 * This class contains methods to find a gene in a DNA strand.
 * It includes a method to find a gene given a start codon and a stop codon.
 * 
 * @author Klaus Von Reinherz
 * @version 1.0
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // Determine if input DNA is uppercase
        boolean isUpperCase = dna.equals(dna.toUpperCase());

        // Convert everything to uppercase for processing
        String upperDna = dna.toUpperCase();
        String upperStartCodon = startCodon.toUpperCase();
        String upperStopCodon = stopCodon.toUpperCase();

        int startIndex = upperDna.indexOf(upperStartCodon);
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = upperDna.indexOf(upperStopCodon, startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            String result = dna.substring(startIndex, stopIndex + stopCodon.length());
            // Convert result to match input case
            return isUpperCase ? result.toUpperCase() : result.toLowerCase();
        } else {
            return "";
        }
    }

    public void testSimpleGene() {
        // Case 1: DNA strand contains both "ATG" and "TAA" with a valid gene sequence
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        String result1 = findSimpleGene(dna1, "ATG", "TAA");
        System.out.println("DNA strand: " + dna1 + " -> Gene: " + result1);
        // Case 2: DNA strand does not contain "ATG" start codon
        String dna2 = "AAAGCCCTAACTAGATTAAGAAACC";
        String result2 = findSimpleGene(dna2, "ATG", "TAA");
        System.out.println("DNA strand: " + dna2 + " -> Gene: " + result2);
        // Case 3: DNA strand does not contain "TAA" stop codon
        String dna3 = "AAATGCCCTAGCTAGATGAAGAAACC";
        String result3 = findSimpleGene(dna3, "ATG", "TAA");
        System.out.println("DNA strand: " + dna3 + " -> Gene: " + result3);
        // Case 4: DNA strand does not contain both "ATG" start codon and "TAA" stop
        // codon
        String dna4 = "AAAGCCCTAACTAGACGAAGAAACC";
        String result4 = findSimpleGene(dna4, "ATG", "TAA");
        System.out.println("DNA strand: " + dna4 + " -> Gene: " + result4);
        // Case 5: DNA strand contains both "ATG" and "TAA" but the sequence length is
        // not a multiple of 3
        String dna5 = "AAATGCCCATAACTAGATGAAGAAACC";
        String result5 = findSimpleGene(dna5, "ATG", "TAA");
        System.out.println("DNA strand: " + dna5 + " -> Gene: " + result5);
        // Case 6: DNA in just lowercase
        String dna6 = "aaatgccctaactagattaaagaaacc";
        String result6 = findSimpleGene(dna6, "atg", "taa");
        System.out.println("DNA strand: " + dna6 + " -> Gene: " + result6);
        // Case 7: DNA in mixed case
        String dna7 = "AaAtGcCcTaAcTaGaTtAaAgAaAcC";
        String result7 = findSimpleGene(dna7, "aTg", "tAa");
        System.out.println("DNA strand: " + dna7 + " -> Gene: " + result7);

    }

}
