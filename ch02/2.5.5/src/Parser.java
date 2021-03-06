import java.io.*;

public class Parser {

    static int lookahead;

    public Parser() throws IOException {
        lookahead = System.in.read();
    }

    /**
     * The reason why return can be used in else branch instead of throw
     * an error is that rest can be epsilon in translation scheme.
     */
    void expr() throws IOException {
        term();
        while(true) {
            if (lookahead == '+') {
                match('+'); term(); System.out.write('+');
            } else if (lookahead == '-') {
                match('-'); term(); System.out.write('-');
            } else return;
        }
    }

    void term() throws IOException {
        if (Character.isDigit((char)lookahead)) {
            System.out.write((char)lookahead); match(lookahead);
        } else {
            throw new Error("syntax error thrown by term()");
        }
    }

    void match(int t) throws IOException {
        if (lookahead == t) lookahead = System.in.read();
        else throw new Error("syntax error thrown by match()");
    }

}
