package truedeveloper.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Student_Table_Entity.class}, version = 1)
public abstract class MyRoomDB extends RoomDatabase {

    public abstract StudentsDao studentsDao();
}
