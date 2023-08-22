package YasudisCFT.src.main.java.org.yasudis.sorter;

import YasudisCFT.src.main.java.org.yasudis.exeptionHandler.SortExceptionHandler;
import YasudisCFT.src.main.java.org.yasudis.reader.AbstractReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MergeSorter implements ISorter {
    private final SortInfo sortInfo;

    public MergeSorter(SortInfo sortInfo) {
        this.sortInfo = sortInfo;
    }

    public <T extends Comparable<T>> void sort(List<AbstractReader<T>> readers) throws SortExceptionHandler {
        try (FileWriter fileWriter = new FileWriter(sortInfo.getOutputFileName())) {
            var optionalReader = findReaderWithNextElement(readers);

            while (optionalReader.isPresent()) {

                doSortStep(optionalReader.get(), readers, fileWriter);

                optionalReader = findReaderWithNextElement(readers);
            }

        } catch (IOException e) {
            throw new SortExceptionHandler(sortInfo.getOutputFileName() + " ошибка обработки файла.");
        }
    }

    private <T extends Comparable<T>> Optional<AbstractReader<T>> findReaderWithNextElement(
            List<AbstractReader<T>> readers) {
        if (sortInfo.getSortOrder().equals(SortOrder.ASC)) {
            return readers.stream()
                    .min(Comparator.comparing(AbstractReader::getElement));
        }

        return readers.stream().max(Comparator.comparing(AbstractReader::getElement));
    }

    private <T extends Comparable<T>> boolean isSortedCorrectly(T curElement, T prevElement) {
        if (prevElement == null) {
            return true;
        }

        SortOrder sortOrder = sortInfo.getSortOrder();

        if (sortOrder.equals(SortOrder.ASC)) {
            return curElement.compareTo(prevElement) >= 0;
        }

        return curElement.compareTo(prevElement) <= 0;
    }

    private <T extends Comparable<T>> void removeReader(AbstractReader<T> reader, List<AbstractReader<T>> readers) {
        reader.close();
        readers.remove(reader);
    }

    private <T extends Comparable<T>> void doSortStep(
            AbstractReader<T> reader, List<AbstractReader<T>> readers, FileWriter fileWriter) throws IOException {

        if (!isSortedCorrectly(reader.getElement(), reader.getPreviousElement())) {
            removeReader(reader, readers);
            return;
        }

        fileWriter.write(reader.getElement() + "\n");

        var optionalNextElem = reader.readNext();
        optionalNextElem.ifPresentOrElse(reader::setElement, () -> removeReader(reader, readers));
    }
}
