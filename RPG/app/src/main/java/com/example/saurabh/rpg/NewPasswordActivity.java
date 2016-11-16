package com.example.saurabh.rpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewPasswordActivity extends AppCompatActivity {
    TextView textView;
    PasswordListActivity pla = null;

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "NPA - onDestroy()", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "NPA - onStop()", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "NPA - onPause()", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "NPA - onResume()", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "NPA - onStart()", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        textView = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        String newpass = intent.getStringExtra("pass");
        textView.setText(newpass);
        Toast.makeText(this, "NPA - onCreate()", Toast.LENGTH_SHORT).show();
        if(pla == null) {
            Toast.makeText(this, "NPA - onCreate() - null", Toast.LENGTH_SHORT).show();
            pla = new PasswordListActivity();
        }
        pla.addtoList(newpass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_password, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
