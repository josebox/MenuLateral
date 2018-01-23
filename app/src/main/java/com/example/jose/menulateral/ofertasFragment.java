package com.example.jose.menulateral;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ofertasFragment extends Fragment {
    static String var= "";
    View vista_ofertas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("cosas",var );
        // Inflate the layout for this fragment

        vista_ofertas= inflater.inflate(R.layout.fragment_ofertas, container, false);
        ((TextView)vista_ofertas.findViewById(R.id.tv_izq)).setText("ACTUALES");
        //((TextView)vista_ofertas.findViewById(R.id.tv_der)).setText("HISTORIAL");
        var = "";
        return vista_ofertas;
    }

    public View getVista_ofertas() {
        return vista_ofertas;
    }

    public static String numero(String valor) {
        var=valor;
        return var;
    }
}
