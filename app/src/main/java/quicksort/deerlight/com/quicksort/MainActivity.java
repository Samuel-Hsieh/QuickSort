package quicksort.deerlight.com.quicksort;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_sort;
    private TextView textview_number;
    private EditText edit_input;
    int number[] = new int[5];
    int single_number;
    int i = 0;
    StringBuilder string_number = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Declare();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i<5) {
                        if(!edit_input.getText().toString().isEmpty()){
                            single_number = Integer.parseInt(edit_input.getText().toString());
                            number[i] = single_number;
                            string_number.append(number[i]+" ");
                            Toast.makeText(getApplicationContext(), "add " + number[i] + " " + i, Toast.LENGTH_SHORT).show();
                            textview_number.setText(string_number);
                            edit_input.setText("");
                            i++;
                         }
                }else {
                        Toast.makeText(getApplicationContext(), "無法再新增", Toast.LENGTH_SHORT).show();
                   }
            }
        });
        button_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuickSort();
                string_number.delete(0,string_number.length());
                for(int k : number) {
                    string_number.append(k+" ");
                }
                textview_number.setText(string_number);
            }
        });
    }
    public void Declare(){
        button_sort = (Button)findViewById(R.id.button_sort);
        textview_number = (TextView)findViewById(R.id.textview_number);
        edit_input = (EditText)findViewById(R.id.edit_input);
    }
    public void QuickSort() {
        sort(0,number.length - 1);
    }
    public void swap (int left , int right){
        int temp;
        temp = number[left];
        number[left] = number[right];
        number[right] = temp;
    }
    public void sort(int left , int right){
        if(left<right){
            int i = left;
            int j = right+1;
            while (true){
                while (i+1<number.length && number[++i] < number[left]);
                while (j - 1 >= 0 && number[--j] > number[left]);
                if(i >= j) break;
                swap(i,j);
            }
            swap(left,j);
            sort(left, j - 1);
            sort(j + 1 , right);
        }
    }
}

