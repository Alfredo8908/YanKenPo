package com.example.alfredosalvador.yankenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private static final Random rgenerator = new Random();
    private static Integer id;
    //Guardamos los ID de las imagenes en un array de enteros
    private static final Integer[] imagenesID = {R.drawable.piedra,R.drawable.papel,R.drawable.tijera};

    private ImageView imgPapel,imgPiedra,imgTijera,imgUsuario,imgIncognita,imgSistema;
    private Button btnJugar,btnResetear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPiedra = (ImageView) findViewById(R.id.imgPiedra);
        imgPapel = (ImageView)findViewById(R.id.imgPapel);
        imgTijera = (ImageView) findViewById(R.id.imgTijera);
        imgUsuario = (ImageView) findViewById(R.id.imgUsuario);

        btnJugar = (Button) findViewById(R.id.btnJugar);
        btnResetear = (Button) findViewById(R.id.btnResetear);


        final ImageView imgSistema = (ImageView) findViewById(R.id.imgSistema);

        //Comienxza el juega
        //Metodo para las Imagenes
        imgPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = R.drawable.piedra;
                imgUsuario.setImageResource(id);

            }
        });

        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = R.drawable.papel;
                imgUsuario.setImageResource(id);
            }
        });

        imgTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = R.drawable.tijera;
                imgUsuario.setImageResource(id);
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer arreglo = num_q();
                imgSistema.setImageResource(arreglo);

                if (imagenesID[0].equals(id)) {
                    if (imagenesID[0].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Empate", Toast.LENGTH_SHORT).show();
                    } else if (imagenesID[1].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Perdiste", Toast.LENGTH_SHORT).show();
                    } else if (imagenesID[2].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Ganaste", Toast.LENGTH_SHORT).show();
                    }
                } else if (imagenesID[1].equals(id)) {
                    if (imagenesID[0].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Ganaste", Toast.LENGTH_SHORT).show();
                    } else if (imagenesID[1].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Empate", Toast.LENGTH_SHORT).show();
                    } else if (imagenesID[2].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Perdiste", Toast.LENGTH_SHORT).show();
                    }
                } else if (imagenesID[2].equals(id)) {
                    if (imagenesID[0].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Perdiste", Toast.LENGTH_SHORT).show();
                    } else if (imagenesID[1].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Ganaste", Toast.LENGTH_SHORT).show();
                    } else if (imagenesID[2].equals(arreglo)) {
                        Toast.makeText(MainActivity.this, "Empate", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Seleccione para jugar", Toast.LENGTH_SHORT).show();
                    imgSistema.setImageResource(R.drawable.incognita);
                }

            }
       });
        btnResetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSistema.setImageResource(R.drawable.incognita);
                imgUsuario.setImageResource(R.drawable.incognita);

            }
        });
    }
    private Integer num_q(){
        Integer q =imagenesID[rgenerator.nextInt(imagenesID.length)];
        return q;
    }

}
