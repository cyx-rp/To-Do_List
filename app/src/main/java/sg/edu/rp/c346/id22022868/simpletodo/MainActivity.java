package sg.edu.rp.c346.id22022868.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Initialising objects
    EditText etTodo;
    Button btnAdd;
    Button btnClear;
    ListView lvTodo;
    ArrayList<String> todolist = new ArrayList<String>();
    ArrayAdapter adapter;
    Spinner spinnerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking objects to their respective UI elements
        etTodo = findViewById(R.id.editTextTodo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvTodo = findViewById(R.id.listViewTodo);

        //Converts Arraylist objects into View objects
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, todolist);

        //Assign adapter to listview
        lvTodo.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etTodo.getText().toString();
                todolist.add(item);
                etTodo.setText("");
                adapter.notifyDataSetChanged();

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTodo.setText("");
                for (int i = 0; i < todolist.size(); i++) {
                    todolist.clear();
                    adapter.notifyDataSetChanged();
                }

            }
        });

/*        spinnerItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        tv.setText("Spinner Item, Yes Selected");
                        break;
                    case 1:
                        tv.setText("Spinner Item, No Selected");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/






    }
}