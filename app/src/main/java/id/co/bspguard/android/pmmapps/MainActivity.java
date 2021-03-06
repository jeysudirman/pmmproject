package id.co.bspguard.android.pmmapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button hitung, go_contact;
    EditText alas, tinggi;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.this.setTitle("Home");


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

                Bundle bundle = new Bundle();
                bundle.putString("alas", alas.getText().toString());
                bundle.putString("tinggi", tinggi.getText().toString());
                bundle.putString("hasil", String.valueOf(result));

                Intent intent = new Intent(MainActivity.this, Hasil.class);
                intent.putExtras(bundle);
                startActivity(intent);

                /**
                 * Melalui intent
                 */
            //        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            //        intent.putExtra("alas", alas.getText().toString());
            //        intent.putExtra("tinggi", tinggi.getText().toString());
            //        intent.putExtra("hasil", String.valueOf(result));
            //        startActivity(intent);

                Toast.makeText(getApplication(),"Hasil =" + String.valueOf(result), Toast.LENGTH_LONG).show();
            }
        });


        go_contact = (Button) findViewById(R.id.contact);
        go_contact.setOnClickListener(this);


    }

    public Double rumus(Double alas, Double tinggi){
        Double segitiga = 0.5 * alas * tinggi;
        return segitiga;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.contact:
                Intent goContact = new Intent(MainActivity.this, Contact.class);
                getApplication().startActivity(goContact);
                break;
            case R.id.button:
                break;
            default:
                break;
                
        }
    }
}
