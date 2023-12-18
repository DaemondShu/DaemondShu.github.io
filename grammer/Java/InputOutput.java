import java.util.*;
import java.io.*;

public class InputOutput {

    //https://blog.csdn.net/qiao1245/article/details/53020417 ACM
    public static void main(String[] args) throws IOException {
        //System.in = stdin
        //System.out = stdout
        //System.err = stderr

        //BufferedReader based StreamTokenizer vs Scanner
        StreamTokenizer st =  new StreamTokenizer(new BufferedReader(new StringReader("a,b,c xxx\n ttt")));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            if (st.sval != null) {  // st may get null
                System.out.printf("%s;", st.sval); // a;b;c;ttt;
            }
        }
        System.out.println();


        //Scanner a bit slow than StreamTokenizer as it will parse with reading: nextInt, nextBigDecimal, nextBigInteger, nextDouble
        // fast: we'd better use BufferInputStream to fasten
        InputStream source = new BufferedInputStream(System.in);
        // InputStream in= new ByteArrayInputStream("a,b,c xxx\n ttt".getBytes());
        Scanner scanner = new Scanner(source);

        while (scanner.hasNext()) {
            System.out.printf("%s;", scanner.next());  //a,b,c;xxx;ttt;
        }

        System.out.printf("\n %s %d", "format test", 2222);
        // System.setIn(System.in);
        System.setOut(new PrintStream(new FileOutputStream("temp.out")));
        System.out.printf("%s %d", "file test", 2222);
        System.out.flush();
    }
}