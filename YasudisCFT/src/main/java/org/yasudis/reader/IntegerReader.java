package YasudisCFT.src.main.java.org.yasudis.reader;

import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.FileReaderExceptionHandler;

import java.util.Optional;

public class IntegerReader extends AbstractReader<Integer> {
    public IntegerReader(String fileName) throws FileReaderExceptionHandler {
        super(fileName);
    }

    @Override
    public Optional<Integer> readNext() {
        String nextLine;

        do {
            if (!scanner.hasNext()) {
                return Optional.empty();
            }

            nextLine = scanner.nextLine();
        } while (!isInteger(nextLine));

        return Optional.of(Integer.parseInt(nextLine));
    }

    private boolean isInteger(String string) {
        if (string == null) {
            return false;
        }

        try {
            Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
