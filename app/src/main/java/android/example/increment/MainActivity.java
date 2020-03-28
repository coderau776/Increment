package android.example.increment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i=0;
    ArrayList<String> arrayList = new ArrayList<>();
    Spinner spinner;
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<10;i++)
        {
            arrayList.add(String.valueOf(i));
        }

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

       textView = findViewById(R.id.txt);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(arrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText(arrayList.get(0));
            }
        });

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView.getText().toString();
                int a=(Integer.parseInt(t));
                a++;
                textView.setText(String.valueOf(a));
            }
        });



        //final TextView txt = findViewById(R.id.textView);
//        i=Integer.parseInt(String.valueOf(txt.getText()));
//        Button btn = findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i++;
//                txt.setText(String.valueOf(i));
//            }
//        });

    }
}
