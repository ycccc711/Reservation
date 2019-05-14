package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Name;
    TextView Mobile;
    TextView SizeOfGroup;
    TextView Display;
    EditText editName;
    EditText editMobile;
    EditText editSize;
    CheckBox Smoke;
    DatePicker dp;
    TimePicker tp;
    Button Confirm;
    Button Reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.tvName);
        Mobile = findViewById(R.id.tvMobile);
        SizeOfGroup = findViewById(R.id.tvSize);
        editName = findViewById(R.id.etName);
        editMobile = findViewById(R.id.etMobile);
        editSize = findViewById(R.id.etSize);
        Display = findViewById(R.id.tvDisplay);
        Smoke = findViewById(R.id.cbSmoke);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        Confirm = findViewById(R.id.btnCfm);
        Reset = findViewById(R.id.btnReset);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                String mobile = editMobile.getText().toString().trim();
                String size = editSize.getText().toString().trim();
                String area ="";
                String text="";

                if(name.isEmpty() ||mobile.isEmpty() ||size.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please fill in all the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(Smoke.isChecked()){
                        area = "smoking area";
                    }else{
                        area = "Non-smoking area";
                    }
                    text =  "Name: " + name
                            + "\n" + "MobileNo: " + mobile
                            + "\n" + "Size: " + size
                            + "\n" + "Time: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute()
                            + "\n" + "Date: " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear()
                            + "\n" + "Area: " + area;
                    Toast.makeText(MainActivity.this, "Reservation" + text, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText("");
                editName.setText("");
                editMobile.setText("");
                editSize.setText("");
                Smoke.setChecked(false);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2019,05,01);
            }
        });

    }
}
