package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Github_act extends AppCompatActivity {

    private Spinner spng;
    private TextView tvgh;
    private String[] precios = new String[]{"5000", "12000", "45000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);


        spng = (Spinner) findViewById(R.id.spinner);
        tvgh = (TextView)findViewById(R.id.tvg);


        Bundle dat = getIntent().getExtras();
        String[] lista = dat.getStringArray("libros");

        ArrayAdapter adapt = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista);

        spng.setAdapter(adapt);

    }



    public void Actividad(View v)
    {




    }
}
