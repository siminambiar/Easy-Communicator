package com.example.communicator;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btnDemoLayout1,btnDemoLayout2,btnDemoLayout3;
    EditText edit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        btnDemoLayout1 = (Button)findViewById(R.id.buttonDemoLayout1);

        //edit = (EditText)findViewById(R.id.buttonDemoLayout2);
        //btnDemoLayout3 = (Button)findViewById(R.id.buttonDemoLayout3);

        btnDemoLayout1.setOnClickListener(this);
        //btnDemoLayout2.setOnClickListener(this);
        //btnDemoLayout3.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onClick(View v)
    {
        if(btnDemoLayout1 == v)
        {
            Intent intent = new Intent(this, CommunicatorActivity.class);

            startActivity(intent);
        }
    }
}