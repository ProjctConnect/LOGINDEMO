package android.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;
    private  TextView userRegistrarion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView) findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);
        userRegistrarion=(TextView)findViewById(R.id.tvRegister);
        Info.setText("No of attempts remaining:5");
        userRegistrarion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String username,String password){
        if(username.equals("harshanand") && password.equals("harshanand")){
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("No of attempts remaining:"+String.valueOf(counter));
            if(counter==0){
                Login.setEnabled(false);
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

            }
        }
    }
}