package wattsco.healthcaresystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText ET_NAME, ET_CPR, ET_EMAIL, ET_PASS, ET_CONFIRMPASS;
    String reg_name, reg_cpr, reg_email, reg_pass, reg_confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_NAME = (EditText)findViewById(R.id.reg_name);
        ET_CPR = (EditText)findViewById(R.id.reg_cpr);
        ET_EMAIL = (EditText)findViewById(R.id.reg_email);
        ET_PASS = (EditText)findViewById(R.id.reg_pass);
        ET_CONFIRMPASS = (EditText) findViewById(R.id.reg_confirmpass);


    }

    public void reg_regbutton(View view) {
        if(ET_EMAIL.getText().toString().contains("@")){
            reg_name = ET_NAME.getText().toString();
            reg_cpr = ET_CPR.getText().toString();
            reg_email = ET_EMAIL.getText().toString();
            reg_pass = ET_PASS.getText().toString();
            reg_confirmpass = ET_CONFIRMPASS.getText().toString();
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, reg_name, reg_cpr, reg_email, reg_pass, reg_confirmpass);
            finish();
        }else{
            Toast.makeText(this,"Not a valid E-mail address.", Toast.LENGTH_LONG).show();
        }
    }


}


