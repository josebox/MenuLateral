package com.example.jose.menulateral;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    //botones activity_main izq/dere
    protected Button btn_dercho,btn_izquerdo;
    protected TextView tv_der,tv_izq;

    private void panelDerecho(){
        android.support.v4.app.Fragment fragmentoDerecho = new demandasFragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.contenedor,fragmentoDerecho);
        t.commit();
    }

    private void panelIzquierdo(){
        android.support.v4.app.Fragment fragmentoIzquierdo = new ofertasFragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.contenedor,fragmentoIzquierdo);
        t.commit();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //texto derecho e izquierdo


        //navegación desde el tablon boton derecho e izquierdo
        btn_dercho = (Button)findViewById(R.id.btn_der);
        btn_izquerdo = (Button)findViewById(R.id.btn_izq);

        btn_dercho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panelDerecho();
            }
        });
        btn_izquerdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panelIzquierdo();
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Metodo para selecciona las acciones dentro del menu lateral
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
      android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_ofertas) {
            String uno = "1";
            ofertasFragment.numero(uno);
            fragmentManager.beginTransaction().replace(R.id.contenedor,new ofertasFragment()).commit();
            btn_izquerdo.setText(R.string.ofertas);
            btn_dercho.setText(R.string.demandas);

        } else if (id == R.id.nav_demandas) {
            String uno = "2";
            ofertasFragment.numero(uno);
            fragmentManager.beginTransaction().replace(R.id.contenedor,new ofertasFragment()).commit();
            btn_izquerdo.setText(R.string.ofertas);
            btn_dercho.setText(R.string.demandas);

        } else if (id == R.id.nav_Actuales) {
            ofertasFragment of=new ofertasFragment();
            fragmentManager.beginTransaction().replace(R.id.contenedor,of).commit();
            btn_izquerdo.setText(R.string.actuales);
            btn_dercho.setText(R.string.historial);


        } else if (id == R.id.nav_historial) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new demandasFragment()).commit();
            btn_izquerdo.setText(R.string.actuales);
            btn_dercho.setText(R.string.historial);

        } else if (id == R.id.nav_recibidas) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new ofertasFragment()).commit();
            btn_izquerdo.setText(R.string.recibidas);
            btn_dercho.setText(R.string.enviadas);

        } else if (id == R.id.nav_enviadas) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new demandasFragment()).commit();
            btn_izquerdo.setText(R.string.recibidas);
            btn_dercho.setText(R.string.enviadas);

        }else if (id==R.id.nav_tablon)
        {
            Log.v("Clicado", "Clicado nav_tablon");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
