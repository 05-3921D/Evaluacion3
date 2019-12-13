package chile.maps.biblioteca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper //Implementar para utilizar sus metodos

{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override //BD BIBLIOTECA TABLA LIBROS !!!!
    public void onCreate(SQLiteDatabase Biblioteca) {

        Biblioteca.execSQL("CREATE TABLE libros(codigo int primary key, nombre text, precio float)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
