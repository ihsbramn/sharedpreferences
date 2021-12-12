package com.rab.pab_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText Email = (EditText) findViewById(R.id.etNewEmail);
        final EditText Password = (EditText) findViewById(R.id.etNewPassword);

        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newEmail = Email.getText().toString();
                String newPassword = Password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newPassword, newPassword);
                editor.commit();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });
    }
}
