package com.example.jose.menulateral;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class demandasFragment extends Fragment {
    View vista_demandas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista_demandas= inflater.inflate(R.layout.fragment_demandas, container, false);
        ((TextView)vista_demandas.findViewById(R.id.tv_der)).setText("HISTORIAL");
        //((TextView)vista_ofertas.findViewById(R.id.tv_der)).setText("HISTORIAL");
        return vista_demandas;
    }

    public View getVista_demandas() {
        return vista_demandas;
    }
    }


