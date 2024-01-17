package seminar.five.lection;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class XmlUtils {


    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {

        return files.stream()
                .collect(groupingBy(XmlFile::getEncoding,filtering(xmlFile -> xmlFile.getTags().stream().
                                anyMatch(tag -> tag.getName().equals(tagName)),
                        mapping(XmlFile::getTags,summingLong(List::size)))));


    }

    public  static Map<String, Long> countAllByTagNameSecond(List<XmlFile> files, String tagName){

        return files.stream()
                .collect(groupingBy(XmlFile::getEncoding,
                        summingLong(xmlFile ->xmlFile.getTags().stream()
                                .anyMatch(tag -> tag.getName().equals(tagName)) ? xmlFile.getTags().size() : 0)));
    }


    public  static Map<String, Long> countAllByTagNameThird(List<XmlFile> files, String tagName){

        return files.stream()
                .collect(groupingBy(XmlFile::getEncoding,
                        mapping(XmlFile::getTags,
                                filtering(list -> list.stream()
                                        .map(Tag::getName)
                                        .anyMatch(tagName::equals),
                                        summingLong(List::size)))));
    }

    public static void main(String[] args) {

        var spliterator = IntStream
                .generate(() -> 2)
                .limit(5)
                .spliterator();
        int count = 0;

        IntConsumer display = System.out::println;
        while (spliterator.tryAdvance(display)) {
            count++;
        }

        System.out.println("count: " + count);


        spliterator.trySplit();
        long a = spliterator.estimateSize();
        spliterator.trySplit();
        long b = spliterator.estimateSize();

        System.out.println(a);
        System.out.println(b);
    }




    class Tag {
        private final String name;

        public Tag(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


    }

    class XmlFile {
        private final String id;
        private final String encoding;
        private final List<Tag> tags;

        public XmlFile(String id, String encoding, List<Tag> tags) {
            this.id = id;
            this.encoding = encoding;
            this.tags = tags;
        }

        public String getId() {
            return id;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public String getEncoding() {
            return encoding;
        }
    }
}
