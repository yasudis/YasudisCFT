package YasudisCFT.src.main.java.org.yasudis.sorter;

import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.SortExceptionHandler;
import YasudisCFT.src.main.java.org.yasudis.reader.AbstractReader;

import java.util.List;

public interface ISorter {
    <T extends Comparable<T>> void sort(List<AbstractReader<T>> readers) throws SortExceptionHandler;
}
