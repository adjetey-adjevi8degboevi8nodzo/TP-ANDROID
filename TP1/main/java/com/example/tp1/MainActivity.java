package com.example.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
public class MainActivity extends Activity
{
    public static final String TAG = "TP2";
    private TextView textView;
    private Button button;
    private final int[] tableau = new int[]{1, 3, 6, 8, 9};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Démarrage de l'activité");
        textView = findViewById(R.id.textview);
        button=findViewById(R.id.button);
        display(tableau);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onPermuter(view);
            }
        });
    }
    private void display(int[] tab)
    {
        textView.setText(Arrays.toString(tab));
    }
    /** appelée quand on clique sur le bouton */
    public void onPermuter(View view)
    {
        Log.i(TAG, "clic sur le bouton Permuter");
        permutation(tableau);
        display(tableau);
    }
    /**
     * fait une permutation circulaire croissante des valeurs :
     * [a, b, c, d] => [d, a, b, c]
     * @param tab tableau à permuter
     */
    private void permutation(int[] tab)
    {
        int dernier = tab[tab.length-1];
        for (int i=tab.length-2;i >=0; i--) {
            recopierSurSuivant(tab,i);
        }
        tab[0] = dernier;
    }
    /**
     * place la valeur de la case pos du tableau tab dans la case pos+1
     * @param tab tableau à permuter
     * @param pos indice de l'élément à copier sur le suivant
     */
    private void recopierSurSuivant(int[] tab, int pos)
    {
        int courant = tab[pos];
        tab[pos + 1] = courant;
    }
}