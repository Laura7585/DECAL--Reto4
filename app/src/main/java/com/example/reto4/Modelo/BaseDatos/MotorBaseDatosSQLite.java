package com.example.reto4.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.reto4.Modelo.Entidad;
import com.example.reto4.Vista.fragment_compras;
import com.example.reto4.Vista.fragment_favoritos;


public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE productos (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230821', 'Chaqueta biker vuelo Casual', 'Ref. CH-H01', '$ 607,759 COP')");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230822', 'Chaqueta sporty humanista', 'Ref. CH-H02', '$ 1,029,900 COP')");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230823', 'Chaqueta aviador ovejera', 'Ref. CH-H01', '$ 741,930 COP')");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230824', 'Chaqueta biker vaquera slim', 'Ref. CH-M01', '$ 405,900 COP')");

        db.execSQL("CREATE TABLE comprar (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");

        db.execSQL("CREATE TABLE favoritos (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");

        db.execSQL("CREATE TABLE servicios (image TEXT, titulo TEXT, descripcion TETX)");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230854', 'Domicilios','Domicilios de puerta a puerta, no tendrás la necesidad de desplazarte a nuestro establecimineto y además no tendrá un costo adicional.')");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230849', 'Devoluciones', 'Sabemos que a veces podemos tener dificultades con nuestros productos, por esta razón ofrecemos la posibilidad de de darte la devolución del producto que hayas comprado, además sin cargos adicionales.')");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230855', 'Entregas rapidas', 'Las compras que pidas por nuestro servicio de domicilio será entregado dentro de las primeras 24 horas desde que lo pidas, si tu domicilio no llega en ese rango de tiempo, te devolvemos tú dinero!')");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230808', 'Bonos', 'Sabemos que eres un cliente fiel a nuestros productos, por esta misma razón, si haces compras por un cierto período de tiempo,  te daremos bonos de fidelidad a la marca.')");

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE comprar");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);
    }

    public void agregarProducto(SQLiteDatabase db, String imagen, String nombre, String ref, String precio){
        db.execSQL("INSERT INTO comprar VALUES('"+imagen+"', '"+nombre+"', '"+ref+"','"+precio+"')");
    }
    public void eliminarFav(SQLiteDatabase db, String tit){
        db.execSQL("DELETE FROM favoritos WHERE titulo='"+tit+"'");
    }
}
