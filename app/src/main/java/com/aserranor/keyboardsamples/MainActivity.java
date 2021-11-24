package com.aserranor.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String SpinnerLabel = "";
    private static final String TAG = "com.aserranor.keyboardsamples";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        if(spinner != null){
            spinner.setAdapter(adapter);
        }
    }


    public void showText(View v){

        EditText edit = findViewById(R.id.editText);
        if(edit != null){
            String showString = edit.getText().toString() + " - " + SpinnerLabel;
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SpinnerLabel = parent.getItemAtPosition(position).toString();
        showText(view);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "onNothingSelected: ");
    }
}