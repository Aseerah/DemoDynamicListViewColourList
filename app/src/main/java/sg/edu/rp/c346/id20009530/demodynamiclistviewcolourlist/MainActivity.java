package sg.edu.rp.c346.id20009530.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextPosition);
        btnRemove = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);

        // initialising
        alColours = new ArrayList<String>();
        // adding element inside arrayList
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etIndexElement.getText().toString().isEmpty() == true) {
                    Toast.makeText(MainActivity.this, "Please enter position", Toast.LENGTH_LONG).show();

                } else if (etElement.getText().toString().isEmpty() == true) {
                    Toast.makeText(MainActivity.this, "Please enter colour", Toast.LENGTH_LONG).show();

                } else if (etElement.getText().toString().isEmpty() == false && etIndexElement.getText().toString().isEmpty() == false) {
                    if ((Integer.parseInt(etIndexElement.getText().toString())) > alColours.size()) {
                        Toast.makeText(MainActivity.this, "please enter valid number", Toast.LENGTH_SHORT).show();
                    } else {
                        int pos = Integer.parseInt(etIndexElement.getText().toString());
                        String colour = etElement.getText().toString();

                        alColours.add(pos, colour);
                        aaColour.notifyDataSetChanged();

                    }


                }
            }
        });


        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                aaColour.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();

            }

        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIndexElement.getText().toString().isEmpty() == false) {
                    if ((Integer.parseInt(etIndexElement.getText().toString())) > alColours.size()) {
                        Toast.makeText(MainActivity.this, "please enter smaller number", Toast.LENGTH_SHORT).show();
                    } else {
                        int pos = Integer.parseInt(etIndexElement.getText().toString());


                        if (aaColour.getCount() > pos) {
                            alColours.remove(pos);
                            aaColour.notifyDataSetChanged();

                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "please enter a number", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                String colour = etElement.getText().toString();

                if (etIndexElement.getText().toString().equalsIgnoreCase("") || etElement.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(MainActivity.this, "please enter something", Toast.LENGTH_LONG).show();
                } else if (pos > alColours.size() - 1) {
                    Toast.makeText(MainActivity.this, "please enter smaller number", Toast.LENGTH_LONG).show();

                } else {
                    alColours.set(pos, colour);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

    }
}