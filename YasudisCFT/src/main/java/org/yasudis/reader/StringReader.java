package YasudisCFT.src.main.java.org.yasudis.reader;

import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.FileReaderExceptionHandler;

import java.util.Optional;

public class StringReader extends AbstractReader<String> {
    public StringReader(String fileName) throws FileReaderExceptionHandler {
        super(fileName);
    }

    @Override
    public Optional<String> readNext() {
        String nextLine;

        do {
            if (!scanner.hasNext()) {
                return Optional.empty();
            }

            nextLine = scanner.nextLine();
        } while (nextLine.contains(" "));

        return Optional.of(nextLine);
    }
}
