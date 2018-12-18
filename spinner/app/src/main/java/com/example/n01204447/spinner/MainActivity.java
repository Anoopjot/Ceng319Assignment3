package com.example.n01204447.spinner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
//import android.app.Activity;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    //in this function we are making a 2nd spinner and adding a content to it
    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        List<String> list = new ArrayList<String>();

        list.add("Red");
        list.add("Blue");
        list.add("Yellow");
        list.add("Pink");
        list.add("Orange");
        list.add("white");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, //create an  ArrayAdapter using the string array and a default spinner layout
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //specify the layout to use when the list of choices appears
        spinner2.setAdapter(dataAdapter);  // apply the adapter to the spinner

    }

    //this is for implementation of sppinner1
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }


    // get the selected dropdown list value
    //In this we added listener to three control items
    //when we click on button it should show what the user has selected

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener (new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "OnClickListener: "
                               + "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();

            }


        });
    }


}
