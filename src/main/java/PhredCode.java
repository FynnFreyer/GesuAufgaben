/**
 * Decodes Phred encoded quality scores, and offers other utility functions.
 */
public class PhredCode {
    int offset;

    /**
     * Constructs a <code>PhredParser</code> with the specified offset.
     *
     * @param offset the ASCII table offset used, usually 33 or 64
     */
    PhredCode(int offset) {
        this.offset = offset;
    }

    /**
     * Calculates a quality score from an error probability.
     * Rounds to the nearest integer.
     *
     * @param probability the probability that a base wasn't read correctly
     * @return the approximate error probability associated with the quality
     */
    public static int toQuality(double probability) {
        return -1;
    }

    /**
     * Calculates the probability that a base wasn't read correctly from a quality score.
     *
     * @param quality a quality score
     * @return the approximate error probability associated with the quality
     */
    public static double toProbability(int quality) {
        return -1;
    }

    /**
     * Encodes a quality score using PHRED encoding.
     *
     * @param phredCode a PHRED encoded quality score
     * @return the decoded quality score
     */
    public char encode(int phredCode) {
        return ' ';
    }

    /**
     * Encodes an array of quality scores into a string using PHRED encoding.
     *
     * @param data an array of quality scores
     * @return a string of PHRED quality scores
     */
    public String encodeMany(int[] data) {
        return null;
    }

    /**
     * Decodes a PHRED encoded quality score.
     *
     * @param phredCode a PHRED encoded quality score
     * @return the decoded quality score
     */
    public int decode(char phredCode) {
        return -1;
    }

    /**
     * Decodes a string of PHRED encoded quality scores.
     *
     * @param data a string of PHRED quality scores
     * @return an array of decoded quality scores
     */
    public int[] decodeMany(String data) {
        return null;
    }
}
