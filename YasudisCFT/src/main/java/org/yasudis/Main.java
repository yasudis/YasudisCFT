package YasudisCFT.src.main.java.org.yasudis;

import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.FileReaderExceptionHandler;
import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.SortExceptionHandler;
import YasudisCFT.src.main.java.org.yasudis.reader.AbstractReader;
import YasudisCFT.src.main.java.org.yasudis.reader.IntegerReader;
import YasudisCFT.src.main.java.org.yasudis.reader.StringReader;
import YasudisCFT.src.main.java.org.yasudis.sorter.ArgumentsParser;
import YasudisCFT.src.main.java.org.yasudis.sorter.ISorter;
import YasudisCFT.src.main.java.org.yasudis.sorter.MergeSorter;
import YasudisCFT.src.main.java.org.yasudis.sorter.SortInfo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArgumentsParser.parse(args);
            SortInfo sortInfo = ArgumentsParser.getSortInfo();
            ISorter sorter = new MergeSorter(sortInfo);
            if (sortInfo.getInputType().equals(Integer.class)) {
                sorter.sort(makeIntegerReaders(sortInfo.getInputFileNames()));
            } else {
                sorter.sort(makeStringReaders(sortInfo.getInputFileNames()));
            }
        } catch (IllegalArgumentException | SortExceptionHandler e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<AbstractReader<Integer>> makeIntegerReaders(List<String> fileNames) {
        List<AbstractReader<Integer>> readers = new ArrayList<>();
        for (var filename : fileNames) {
            try {
                readers.add(new IntegerReader(filename));
            } catch (FileReaderExceptionHandler e) {
                System.err.println(e.getMessage());
            }
        }
        return readers;
    }

    private static List<AbstractReader<String>>  makeStringReaders(List<String> fileNames) {
        List<AbstractReader<String>> readers = new ArrayList<>();
        for (var fileName : fileNames) {
            try {
                readers.add(new StringReader(fileName));
            } catch (FileReaderExceptionHandler e) {
                System.err.println(e.getMessage());
            }
        }
        return readers;
    }
}
