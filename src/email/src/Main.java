import model.Attachment;
import model.Email;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 04.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                Email.newBuilder()
                        .from("user1@gmail.com")
                        .body("This\r\nis\r\nemail.")
                        .to("user2@mail.ru")
                        .attachments(Arrays.asList(
                                new Attachment("This is attachment".getBytes(), "Attachment1.txt"),
                                new Attachment("This is attachment2".getBytes(), "Attachment2.txt")
                        ))
                        .build(),
                Email.newBuilder()
                        .from("user3@gmail.com")
                        .body("This\r\nis\r\nemail\r\n\r\nbOmB \r\nwith some attachemnt\r\n.")
                        .to("user1@mail.ru")
                        .attachments(Arrays.asList(
                                new Attachment("This is attachment\r\n 1".getBytes(), "Attachment1.txt"),
                                new Attachment("This is attachment2 \r\n 2".getBytes(), "Some Attachment.txt")
                        ))
                        .build()
        );

        List<Email> emailsWithBomb = emails.stream()
                .filter(email -> email.getBody().toLowerCase().contains("bomb"))
                .collect(Collectors.toList());
        System.out.println(emailsWithBomb);

        List<Attachment> attachments = emails.stream()
                .flatMap(email -> email.getAttachments().stream())
                .collect(Collectors.toList());
        System.out.println(attachments);

        List<String> collect = emails.stream()
                .flatMap(email -> email.getAttachments().stream())
                .map(attachment -> new String(attachment.getData()))
                .filter(s -> s.toLowerCase().contains("bomb"))
                .collect(Collectors.toList());

        List<Attachment> collect2 = emails.stream()
                .flatMap(email -> email.getAttachments().stream())
                .filter(attachment -> new String(attachment.getData()).toLowerCase().contains("bomb"))
                .collect(Collectors.toList());

        List<String> subjects = emails.stream()
                .map(email -> email.getSubject())
                .collect(Collectors.toList());
        List<List<Attachment>> att = emails.stream()
                .map(email -> email.getAttachments())
                .map(list -> list)
                .collect(Collectors.toList());

        emails.stream()
                .flatMap(email -> email.getAttachments().stream())
                .sorted((o1, o2) -> o1.getFileName().compareToIgnoreCase(o2.getFileName()))
                .collect(Collectors.toList());
//        Map<String, Attachment> attchmentMap = emails.stream()
//                .flatMap(email -> email.getAttachments().stream())
//                .sorted((o1, o2) -> o1.getFileName().compareToIgnoreCase(o2.getFileName()))
//                .collect(Collectors.toMap(attachment -> attachment.getFileName(), attachment1 -> attachment1));
//        System.out.println(attchmentMap);
    }
}
