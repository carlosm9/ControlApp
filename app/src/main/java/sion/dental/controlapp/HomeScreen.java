package sion.dental.controlapp;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Only if the navigation is very first action.
        if(savedInstanceState == null){
            ////Remove if we don't want to have the navigation drawer open right after launching the application
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AgendaFragment()).commit();
            ////To have one item selected by default after launching the application
            navigationView.setCheckedItem(R.id.nav_agenda);
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_agenda:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AgendaFragment()).commit();
                break;
            case R.id.nav_facturas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FacturasFragment()).commit();
                break;
            case R.id.nav_inventario:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InventarioFragment()).commit();
                break;
            case R.id.nav_pacientes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PacientesFragment()).commit();
                break;
            case R.id.nav_registrar_compra:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RegistrarComprasFragment()).commit();
                break;
            case R.id.nav_registrar_venta:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RegistrarVentaFragment()).commit();
                break;
            case R.id.nav_reporte_compras:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReporteComprasFragment()).commit();
                break;
            case R.id.nav_reporte_ventas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReporteVentasFragment()).commit();
                break;
            case R.id.nav_recordatorios:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RecordatorioFragment()).commit();
                break;
            case R.id.nav_facebook:
                Toast.makeText(this, "Opening Facebook App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_instagram:
                Toast.makeText(this, "Opening Instagram App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_email:
                Toast.makeText(this, "Opening Email App", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
