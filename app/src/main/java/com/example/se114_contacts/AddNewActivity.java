package com.example.se114_contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewActivity extends AppCompatActivity {
    Button btn;
    EditText editTextName, editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        editTextName=findViewById(R.id.editTextName);
        editTextPhone=findViewById(R.id.editTextPhone);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextName.getText().toString().isEmpty()) | (editTextPhone.getText().toString().isEmpty()) )
                {
                    Toast toast = Toast.makeText(v.getContext(), "Please Fill Full", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Intent i = new Intent(AddNewActivity.this, MainActivity.class);
                    i.putExtra("ID", 3);
                    i.putExtra("name", editTextName.getText().toString());
                    i.putExtra("phone", editTextPhone.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}