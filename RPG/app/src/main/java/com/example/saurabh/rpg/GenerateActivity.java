package com.example.saurabh.rpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GenerateActivity extends AppCompatActivity {
    Button generatePass;
    EditText fname;
    EditText lname;
    EditText website;
    EditText occupation;
    EditText address;
    EditText favouriteAnimal;
    EditText passwordLength;
    String first_name, last_name, website_name,user_occupation, user_address, fav_Animal,pLength;
    public static final char special[] = {'!','@','#','$','%','^','&','*','(',')'};
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        generatePass = (Button)findViewById(R.id.gen);
        fname = (EditText)findViewById(R.id.first);
        lname = (EditText)findViewById(R.id.last);
        website = (EditText)findViewById(R.id.website_name);
        occupation = (EditText)findViewById(R.id.occupation);
        address = (EditText)findViewById(R.id.address);
        favouriteAnimal = (EditText)findViewById(R.id.fav_animal);
        passwordLength = (EditText)findViewById(R.id.passlength);



        generatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first_name = fname.getText().toString();
                last_name = lname.getText().toString();
                website_name = fname.getText().toString();
                user_occupation = fname.getText().toString();
                user_address = fname.getText().toString();
                fav_Animal= fname.getText().toString();
                pLength = passwordLength.getText().toString();

                password = generatePassword();



                Intent displayPass = new Intent(getApplicationContext(),NewPasswordActivity.class);
                displayPass.putExtra("pass",password);
                startActivity(displayPass);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_generate, menu);
        return true;
    }
    public boolean isInputValid(){
        if(first_name==null || first_name.equals(""))
            return false;
        if(last_name == null || last_name.equals(""))
            return false;
        if(pLength == null || pLength.equals(""))
            return false;
        return true;
    }
    public String generatePassword(){

        char pass[];

        if(!isInputValid()){
            Toast.makeText(GenerateActivity.this, "Please fill up all mandatory fields", Toast.LENGTH_SHORT).show();
            return null;
        }
        else{
            Random rand = new Random();
            if(pLength.equals("")) pLength = "5";
            int length=Integer.parseInt(pLength);
             pass= new char[length];
            pass[length-1]=first_name.charAt(0);
            pass[0] =last_name.charAt(last_name.length()-1);
            pass[1] = website_name.charAt(0);
            pass[2] = website_name.charAt(1);
            for(int i = 3; i<length - 1; i++){

                int random=rand.nextInt(10);
                pass[i]=special[random];
            }

        }
        String pwd = new String(pass);
        return pwd;
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
