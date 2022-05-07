package com.example.addcontactusingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton=(Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view){
        Intent intent=new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        EditText mFirstname= (EditText) findViewById(R.id.editTextTextPersonName);
        EditText mLastname=(EditText) findViewById(R.id.editTextTextPersonName2);
        EditText mPhone=(EditText) findViewById(R.id.editTextPhone);
        EditText memail=(EditText) findViewById(R.id.editTextTextEmailAddress2);

        intent
                .putExtra(ContactsContract.Intents.Insert.EMAIL,memail.getText())
                .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.PHONE,mPhone.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.NAME,mFirstname.getText() + " " + mLastname.getText())
                ;
        startActivity(intent);
    }

        });
    }
}
