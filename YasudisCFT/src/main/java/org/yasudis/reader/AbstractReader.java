package YasudisCFT.src.main.java.org.yasudis.reader;

import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.FileReaderExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public abstract class AbstractReader<T extends Comparable<T>> implements IReader<T> {
    protected final String FILE_NAME;

    protected final Scanner scanner;

    protected T element;
    protected T previousElement;

    public AbstractReader(String fileName) throws FileReaderExceptionHandler {
        this.FILE_NAME = fileName;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            this.scanner = new Scanner(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new FileReaderExceptionHandler(fileName + " файл не найден");
        }

        var optionalElement = readNext();

        if (optionalElement.isEmpty()) {
            scanner.close();
            throw new FileReaderExceptionHandler("В файле " + fileName + " нет корректных строк." +
                    " Данные из файла не будут включены в выходной файл");
        }

        this.element = optionalElement.get();
    }

    public T getElement() {
        return element;
    }

    public void setElement(T nextElement) {
        this.previousElement = this.element;
        this.element = nextElement;
    }

    public T getPreviousElement() {
        return previousElement;
    }

    public abstract Optional<T> readNext();

    public void close() {
        scanner.close();
    }
}
