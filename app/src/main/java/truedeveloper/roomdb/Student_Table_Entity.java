package truedeveloper.roomdb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Students", indices = @Index(value = {"student_number"}, unique = true))
public class Student_Table_Entity {

@PrimaryKey(autoGenerate = true)
private int id;

@ColumnInfo(name="student_name")
private String student_name;

@ColumnInfo(name="student_number")
private int student_number;

// Alt+Insert to add getters and setters


    public int getId() {
        return id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }
}
