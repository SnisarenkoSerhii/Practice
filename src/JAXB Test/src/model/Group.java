package model;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sergey on 11.12.2015.
 */
@XmlRootElement
public class Group implements Serializable {
    private String groupNumber;
    private List<Student> students;

    public String getGroupNumber() {
        return groupNumber;
    }

    @XmlAttribute(name = "groupNumber")
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    @XmlElement(name = "student")
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber='" + groupNumber + '\'' +
                ", students=" + students +
                '}';
    }
}
