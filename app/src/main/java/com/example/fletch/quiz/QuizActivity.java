package com.example.fletch.quiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /* Declaration des boutons */
        Button buttonVrai = (Button) findViewById(R.id.buttonVrai);
        Button buttonFaux = findViewById(R.id.buttonFaux);



        /**
         *  Fait à noter ici, OnClickListener est une interface plutôt qu'une classe.
         *  La déclaration subséquente de OnClick est donc obligatoire.
         *  Remarquez aussi la déclaration de la classe qui est anonyme (anonymous class)
         *  (https://docstore.mik.ua/orelly/java-ent/jnut/ch03_12.htm)
        */
        buttonVrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.this.alertDialog("Tu as cliqué sur Vrai");
            }
        });

        buttonFaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.this.alertDialog("Tu as cliqué sur Faux");
            }
        });

    }

    /**
     * Permet de générer une alerte avec une réponse neutre : OK
     * @param message Le message à afficher
     */
    private void alertDialog(String message) {

        /** Remarquez ici l'utilisation du contexte dans le paramétrage de AlertDialog.Builder
         * Cela permet à l'application d'avoir accès à l'object instancié en cours
         *
         * */
        AlertDialog alertDialog = new AlertDialog.Builder(QuizActivity.this).create();
        alertDialog.setTitle("Alerte");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
