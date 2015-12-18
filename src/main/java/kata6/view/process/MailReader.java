package kata6.view.process;

import kata6.model.Mail;
import kata6.model.Person;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class MailReader {

    public static List read(String filePath) {
        try(Stream<String> lines = lines(Paths.get(filePath))) {
            return lines.map(MailReader::toPerson).collect(toList());
        } catch (IOException e) {
            return emptyList();
        }
    }

    private static Person toPerson(String mail) {
        return new Person("user", new Mail(mail));
    }

}
