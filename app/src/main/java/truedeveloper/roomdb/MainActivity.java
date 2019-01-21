package truedeveloper.roomdb;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText stName, stNumber;
    Button save_data, read_data;
    String student_name, student_number;

    public static MyRoomDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stName = (EditText)findViewById(R.id.editText01);
        stNumber = (EditText)findViewById(R.id.editText02);
        save_data = (Button)findViewById(R.id.button01);
        read_data = (Button)findViewById(R.id.button02);

        DB = Room.databaseBuilder(getApplicationContext(),MyRoomDB.class,"studentsdb1").allowMainThreadQueries().build();
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student_Table_Entity student = new Student_Table_Entity();
                student.setStudent_name(stName.getText().toString());
                student.setStudent_number(Integer.valueOf(stNumber.getText().toString()));
                long response_code = DB.studentsDao().Add_a_student(student);

                if(response_code > 0){
                    Toast.makeText(getBaseContext(),"Data Saved!",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(),"Duplicated student number. Data add failed.",Toast.LENGTH_LONG).show();
                    Log.d("response_code", "response code = " + response_code);
                }
                Log.d("RoomDB", "INFO01: ...");

                stName.setText("");
                stNumber.setText("");
            }
        });

        read_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<Student_Table_Entity> students = DB.studentsDao().getStudents();

                String students_list = "";

                for (Student_Table_Entity student : students){

                    int id = student.getId();
                    String name = student.getStudent_name();
                    int number = student.getStudent_number();
                    students_list = students_list + "\n\n" + "Id = " + id + "\nName = " + name + "\nNumber = " + number ;
                }
                Toast.makeText(getBaseContext(),"Reading Data ..." ,Toast.LENGTH_LONG).show();
                Log.d("RoomDB", "Reading Data ..." + students_list);
            }
        });
    }
}
