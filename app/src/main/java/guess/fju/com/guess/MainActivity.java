package guess.fju.com.guess;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int r = new Random().nextInt(10)+1;//括號內為產生幾個數字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView n = (TextView)findViewById(R.id.txt_number);
        n.setText(Integer.toString(r));
    }

    public void guess(View view){
        EditText edNumber = (EditText)findViewById(R.id.ed_number);
        int n = Integer.parseInt(edNumber.getText().toString());
        TextView m = (TextView)findViewById(R.id.txt_message);
        if(n>10 || n<1){
            m.setText(R.string.wrong);
            new AlertDialog.Builder(this)
                    .setMessage(R.string.wrong)
                    .setPositiveButton("OK", null)
                    .show();
        }else if(n<r){
            m.setText(R.string.bigger);
            Toast.makeText(this, R.string.bigger, Toast.LENGTH_LONG).show();
        }else if(n>r){
            m.setText(R.string.smaller);
            Toast.makeText(this, R.string.smaller, Toast.LENGTH_LONG).show();
        }else{
            m.setText(R.string.bingo);
            new AlertDialog.Builder(this)
                    .setMessage(R.string.bingo)
                    .setPositiveButton("OK", null)
                    .show();
        }
    }

}
