package Strings;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sarvothampai on 20/01/16.
 */
public class TextFileIterable {



    /** A reference to a file. */
    public class TextFile implements Iterable<String> {
        Scanner scanner;
        public TextFile(String fileName) {
            try {
                scanner = new Scanner(new File(fileName));
            } catch (Exception e) {

            }
        }

        /** Begin reading the file, line by line.
         *  The returned Iterator.next() will return a line.
         */
        public Iterator<String> iterator() {
            return new TextFileIterator();
        }

        private class TextFileIterator implements Iterator<String> {

            public boolean hasNext() {
                return scanner.hasNext();
            }


            public String next() {
                return scanner.nextLine();
            }


            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }
}
