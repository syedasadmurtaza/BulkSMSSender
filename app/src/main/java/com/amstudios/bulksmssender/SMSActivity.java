package com.amstudios.bulksmssender;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {


    private Button btnSend;
    private EditText etText,etNumber,etNumberSMS;
    int a,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etText = (EditText) findViewById(R.id.etText);
        etNumber = (EditText) findViewById(R.id.etNumber);
        etNumberSMS = (EditText) findViewById(R.id.etSmsNumber);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        generateToast();

        assignValue();

        if (c == 4 && d == 4 && e == 4) {
            String text = etText.getText().toString();
            String number = etNumber.getText().toString();
            String nos = etNumberSMS.getText().toString();

            int no = Integer.parseInt(nos);


            SmsManager sms = SmsManager.getDefault();


            for (int i = 0; i < no; i++) {
                sms.sendTextMessage(number, null, text, null, null);
            }

            Toast.makeText(getApplicationContext(), "Messages Sent!", Toast.LENGTH_LONG).show();
        }
    }

});




        }


    private boolean isEmpty(EditText text)

    {

        if(text.getText().toString().trim().length()>0)
            return false;//Something is written in text fields
        else
        return true;//Field is Empty

    }

    private void generateToast(){

        if(isEmpty(etText)==true)
            Toast.makeText(getApplicationContext(), "Enter some text", Toast.LENGTH_SHORT).show();
        if(isEmpty(etNumber)==true)
            Toast.makeText(getApplicationContext(), "Enter number", Toast.LENGTH_SHORT).show();
        if(isEmpty(etNumberSMS)==true)
            Toast.makeText(getApplicationContext(), "Enter number of SMS to send", Toast.LENGTH_SHORT).show();
        a=2;
    }

    private void assignValue(){


        if(isEmpty(etText)==false)
            c=4;
         if(isEmpty(etNumber)==false)
            d=4;
        if(isEmpty(etNumberSMS)==false)
            e=4;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sms, menu);
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
