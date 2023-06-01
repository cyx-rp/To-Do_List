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
import android.widget.Toast;

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
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking objects to their respective UI elements
        etTodo = findViewById(R.id.editTextTodo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvTodo = findViewById(R.id.listViewTodo);
        spinnerItem = findViewById(R.id.choice);
        btnDelete = findViewById(R.id.buttonDelete);

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

        //Enhancement 1 - Delete button
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if list is empty and you try to delete
                if (todolist.isEmpty()) {
                    Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                }

                String numString = etTodo.getText().toString();

                //check to ensure that string is all int
                if (numString.matches("\\d+")) {

                    int num = Integer.parseInt(numString);

                    if (num >= 0 && num < todolist.size()) {
                        todolist.remove(num);
                    }

                    else {
                        Toast.makeText(MainActivity.this, "Wrong Index Number", Toast.LENGTH_SHORT).show();

                    }


/*                else if (num < 0 && num > count) {
                    Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                }*//*
                    else {
                        todolist.remove(num);
                    }
                    todolist.remove(num);*/
                }

                adapter.notifyDataSetChanged();



/*                int count = 0;

                for (int i = 0; i < todolist.size(); i++) {
                    count += 1;
                }*/


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

        //Enhancement 1
        spinnerItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        etTodo.setHint("Type in a new task here");
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        etTodo.setHint("Type in the index of the task to be removed");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/*        lvTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                todolist.remove(position);

            }
        });*/






    }
}