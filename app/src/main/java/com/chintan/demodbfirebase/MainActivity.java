package com.chintan.demodbfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText mName;
    private EditText mEmail;
    private Button mButton;
    private  String userId;
    private User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        mName   = (EditText)findViewById(R.id.name1);
        mEmail   = (EditText)findViewById(R.id.email1);
        mButton = (Button)findViewById(R.id.btn_save);

        userId = mDatabase.push().getKey();



        //mDatabase.setValue(user1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user1 = new User(userId, mName.getText().toString(), mEmail.getText().toString());
                Log.i("uname", mName.getText().toString());
                Log.i("email", mEmail.getText().toString());
                Log.i("infoFirebase", user1.toString());

                mDatabase.setValue(user1);
            }
        });


      /*  userId = mDatabase.push().getKey();

        User user2 = new User(userId, "chintan2", "c2@gmail.com");

        mDatabase.setValue(user2);*/
    }
}
