package truedeveloper.roomdb;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long Add_a_student(Student_Table_Entity student);

    @Query("select * from Students")
    public List<Student_Table_Entity> getStudents();

}
