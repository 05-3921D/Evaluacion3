package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        et1 = (EditText)findViewById(R.id.cod);
        et2 = (EditText)findViewById(R.id.nombre);
        et3 = (EditText)findViewById(R.id.precio);


    }
    public void añadirLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase Biblioteca = admin.getWritableDatabase();

        if (!et1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues(); //Contenedor de valores que deseo insertar
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            //LLamo a la clase y doy insert a la tabla "Libros"
            Biblioteca.insert("libros", null, registro);
            Biblioteca.close();

            //Verificacion
            Toast.makeText(this, "Se ha ingresado un libro a la lista", Toast.LENGTH_LONG).show();

        }
    }

    public void eliminarLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase Biblioteca = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        Biblioteca.delete("libros", "codigo"+codigo,null);
        Biblioteca.close();

        //Verificacion
        Toast.makeText(this, "Se ha eliminado un libro a la lista con el codigo" +codigo, Toast.LENGTH_LONG).show();

    }

    public void modificarLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase Biblioteca = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        ContentValues cont = new ContentValues();
        cont.put("codigo", et1.getText().toString());
        cont.put("nombre", et2.getText().toString() );
        cont.put("precio", et3.getText().toString() );

        //Cambio consulta
        if (!et1.getText().toString().isEmpty())
        {
            Biblioteca.update("libros",cont,"codigo"+codigo, null);
            Toast.makeText(this, "Se ha Actualizado un libro de la lista con el codigo" +codigo, Toast.LENGTH_LONG).show();



        }
    }
}
