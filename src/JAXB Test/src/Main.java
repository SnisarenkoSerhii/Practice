import model.Group;
import model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sergey on 11.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        Group group = initData();

        serialiseGroup(group);

        group = deserializeGroup();
        System.out.println(group);
    }

    private static Group deserializeGroup() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Group) unmarshaller.unmarshal(new File("group.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void serialiseGroup(Group group) {
        try {
            File file = new File("group.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(group, file);
            jaxbMarshaller.marshal(group, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static <T> T deserialize(Class clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File("group.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> void serialize(T group) {
        try {
            File file = new File("group.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(group.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(group, file);
            jaxbMarshaller.marshal(group, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private static Group initData() {
            List<Student> students = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();

            Student student1 = new Student();
            student1.setFirstName("fname 1");
            student1.setLastName("lname 1");
            student1.setMiddleName("mname 1");
            calendar.set(Calendar.YEAR, 1986);
            calendar.set(Calendar.MONTH, 10);
            calendar.set(Calendar.DATE, 28);
            student1.setBirthday(calendar.getTime());
            students.add(student1);

            Student student2 = new Student();
            student2.setFirstName("fname 2");
            student2.setLastName("lname 2");
            student2.setMiddleName("mname 2");
            calendar.set(Calendar.YEAR, 1999);
            calendar.set(Calendar.MONTH, 5);
            calendar.set(Calendar.DATE, 14);
            student2.setBirthday(calendar.getTime());
            students.add(student2);

            Group group = new Group();
            group.setGroupNumber("G101");
            group.setStudents(students);
            return group;
        }
    }

