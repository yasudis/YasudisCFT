package YasudisCFT.src.main.java.org.yasudis.reader;

import java.util.Optional;

public interface IReader<T> {
Optional<T> readNext();
}
