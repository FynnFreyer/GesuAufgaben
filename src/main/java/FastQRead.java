import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * A <code>FastQRead</code> has an ID and contains a sequence of bases and associated qualities.
 */
public class FastQRead {

    /**
     * Use this for playing around with the class.
     *
     * @param args an array of CLI arguments, ignore it for now...
     */
    public static void main(String[] args) {
        // change me to your file path ...
        String filename = "/path/to/sample.fastq";
        FastQRead[] records = readFastQ(filename);
        System.out.println(Arrays.toString(records));
    }

    /**
     * Read identifier.
     */
    String id;

    /**
     * Array with bases.
     */
    char[] bases;

    /**
     * Array with base-associated qualities.
     */
    int[] qualities;

    /**
     * Constructs a new <code>FastQRead</code>.
     *
     * @param id        the read identifier
     * @param bases     an array of bases
     * @param qualities an array of base-associated quality values
     */
    FastQRead(String id, char[] bases, int[] qualities) {
        this.id = id;
        this.bases = bases;
        this.qualities = qualities;
    }

    /**
     * This method controls how <code>FastQRead</code>s are printed to the terminal.
     *
     * @return a string representation of the <code>FastQRead</code>
     */
    @Override
    public String toString() {
        return "FastQRead: " + this.id;
    }

    /**
     * Read a FastQ file and parse the contained <code>FastQRead</code> records.
     *
     * @param filepath path to a FastQ file
     * @return an array containing the <code>FastQRead</code> records parsed from the file
     */
    public static FastQRead[] readFastQ(String filepath) {
        // lists can freely grow and shrink
        ArrayList<FastQRead> records = new ArrayList<>();
        // try/catch blocks are used for exception handling
        // we use these to ensure the computer knows what to do in case of operations that might fail
        // e.g. what if <filename> doesn't exist?
        try {
            // this represents a file on the file system
            File fastqFile = new File(filepath);
            // we can use scanners to read file contents
            Scanner fastqReader = new Scanner(fastqFile);

            // parsing logic goes here
            String id = null;
            char[] bases = null;
            int[] qualities = null;

            // we need to keep track of how many lines we've read so far
            int i = 0;
            // we need to check if the file has more lines
            // otherwise trying to read from it will block execution
            while (fastqReader.hasNextLine()) {
                String data = fastqReader.nextLine();

                // records are 4 lines long
                // with modulo we can check what this line encodes
                int offset = i % 4;

                // switch/case statements are if/else blocks on crack
                // they decide on one of multiple specified choices
                // based on a passed value (in this case, `offset`)
                switch (offset) {
                    case 0:
                        // is header
                        if (i != 0) {
                            FastQRead fastq = new FastQRead(id, bases, qualities);
                            records.add(fastq);
                        }
                        // ditch the `@` and remove whitespace from edges
                        id = data.substring(1).strip();
                        break;
                    case 1:
                        // is sequence
                        bases = data.toCharArray();
                        break;
                    case 3:
                        // is qualities
                        qualities = decodePhred33(data);
                        break;
                    default:
                        break;
                }
                i++;
            }

            // instantiate a new record and add it to the list
            FastQRead fastq = new FastQRead(id, bases, qualities);
            records.add(fastq);

            // scanners need to be closed after used
            fastqReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filepath);
        }

        // turn the list into an array
        int recordSize = records.size();
        FastQRead[] recordArray = new FastQRead[recordSize];
        return records.toArray(recordArray);
    }

    /**
     * Decode a string of PHRED33 encoded quality values.
     *
     * @param data a string of PHRED33 quality values
     * @return an array of decoded qualities
     */
    private static int[] decodePhred33(String data) {
        return null;
    }
}
