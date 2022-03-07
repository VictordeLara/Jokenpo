package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionarPedra(View view){

        this.opcaoSelecionada("Pedra");
    }
    public void selecionarPapel(View view){

        this.opcaoSelecionada("Papel");
    }
    public void selecionarTesoura(View view){

        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes [ numero ];

        switch (escolhaApp){

            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp =="Tesoura" && opcaoUsuario == "Papel") ||
                (escolhaApp =="Papel" && opcaoUsuario == "Pedra")   ||
                (escolhaApp =="Pedra" && opcaoUsuario == "Tesoura")
        ){
            //app ganha
            textoResultado.setText("Voce Perdeu : (");
        }
        else if(
                (opcaoUsuario =="Tesoura" && escolhaApp == "Papel") ||
                (opcaoUsuario =="Papel" && escolhaApp == "Pedra")   ||
                (opcaoUsuario =="Pedra" && escolhaApp == "Tesoura")

        ){
            //jogador ganha
            textoResultado.setText("Voce Ganhou : )");
        }
        else{ //empate
            textoResultado.setText("Empate, jogue novamente");
        }
        System.out.println("Item clicado : "+ escolhaApp);

    }

}