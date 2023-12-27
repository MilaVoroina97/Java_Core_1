package seminar.five.lection;

import java.util.Date;
import java.util.Random;

public class PersonID {
    private final int ID;
    private final String FIO;
    private Date DOB;
    private float salary;
    PersonID(String fio, Date dob, float salary) {
        FIO = fio;
        DOB = dob;
        ID = new Random().nextInt();
        this.salary = salary;
    }
    public int getID() {return ID;}
    public String getFIO() {return FIO;}
    public String getDOB() {return ""+DOB.getDate() + " " +
            Months.values()[DOB.getMonth()] + " " + DOB.getYear();}
    public float getSalary() {return salary;}
    public void setSalary(float salary) {this.salary = salary;}

    public Date getDate(){return DOB;}
}
