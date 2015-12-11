package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sergey on 11.12.2015.
 */
@XmlRootElement
public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String middleName;

    private Date birthday;

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "lpName") //<lpNmae>hagdhhsj</lpName>
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @XmlElement(name = "middlename")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthday() {
        return birthday;
    }

    @XmlElement(name = "birthday")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
