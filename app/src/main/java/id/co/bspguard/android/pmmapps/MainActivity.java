package id.co.bspguard.android.pmmapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button hitung;
    EditText alas, tinggi;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hitung = (Button) findViewById(R.id.button);
        alas = (EditText) findViewById(R.id.alas);
        tinggi = (EditText) findViewById(R.id.tinggi);
        hasil = (TextView) findViewById(R.id.hasil);


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double param_satu = Double.parseDouble(alas.getText().toString());
                Double param_dua = Double.parseDouble(tinggi.getText().toString());

                Double result = rumus(param_satu, param_dua);
                hasil.setText("Hasil =" + String.valueOf(result));

                Toast.makeText(getApplication(),"Hasil =" + String.valueOf(result), Toast.LENGTH_LONG).show();
            }
        });


    }

    public Double rumus(Double alas, Double tinggi){
        Double segitiga = 0.5 * alas * tinggi;
        return segitiga;
    }
}