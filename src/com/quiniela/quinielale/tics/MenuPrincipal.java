/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiniela.quinielale.tics;

import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.quiniela.R;
import javax.net.ssl.ManagerFactoryParameters;

/**
 *
 * @author Carlos Miguel
 */
public class MenuPrincipal extends Activity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mOpcionesTitles;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTitle = mDrawerTitle = getTitle();
        mOpcionesTitles = getResources().getStringArray(R.array.opciones_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

       
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mOpcionesTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_refresh).setVisible(!drawerOpen);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
        case R.id.action_refresh:
            // create intent to perform web search for this planet
            if(isConnected()){
            
            Toast.makeText(getBaseContext(), "Tienes conexion a internet" , 2).show();
        }
        else{
            Toast.makeText(getBaseContext(), "NO estas conectado a internet :c" , 2).show();
        }
            return true;
         
        case R.id.action_settings:
            
            Intent intent1 = new Intent(MenuPrincipal.this, NotificationActivity.class);
          
            // catch event that there's no activity to handle intent
            if (intent1.resolveActivity(getPackageManager()) != null) {
                startActivity(intent1);
            } else {
                Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
            }
            return true;
            
        
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
     private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
     
     private void selectItem(int position) {
        // update the main content by replacing fragments
         
         FragmentTransaction fragmentTransaction;
         FragmentManager fragmentManager;
         switch(position)
         {
             case 0:
                fragmentManager = getFragmentManager();   
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentoCalendario calendarioFragment = new FragmentoCalendario();
                fragmentTransaction.replace(R.id.content_frame, calendarioFragment);
                fragmentTransaction.commit();
                 break;
             case 1:
                fragmentManager = getFragmentManager();   
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentoPosiciones posicionesFragment = new FragmentoPosiciones();
                fragmentTransaction.replace(R.id.content_frame, posicionesFragment);
                fragmentTransaction.commit();
                 break;
             case 2:
                fragmentManager = getFragmentManager();   
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentoQuiniela quinielaFragment = new FragmentoQuiniela();
                fragmentTransaction.replace(R.id.content_frame, quinielaFragment);
                fragmentTransaction.commit();
                 break;
             
             case 3:
                fragmentManager = getFragmentManager();   
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentoResultados resultadosFragment = new FragmentoResultados();
                fragmentTransaction.replace(R.id.content_frame, resultadosFragment);
                fragmentTransaction.commit();
                 break;
//             case 4:
//                     AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
//                     dialogo1.setTitle("Cerrar Sesion");  
//                     dialogo1.setMessage("¿Seguro quiere cerrar sesion ?");            
//                     dialogo1.setCancelable(false);  
//                     dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
//                         public void onClick(DialogInterface dialogo1, int id) {  
//                            Intent intento = new Intent(MenuPrincipal.this, Inicio.class);
//                            startActivity(intento);
//                            MenuPrincipal.this.finish();
//                         }  
//                     });  
//                     dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
//                         public void onClick(DialogInterface dialogo1, int id) { 
//                             dialogo1.dismiss();
//                         }
//                     }); 
//                     dialogo1.show(); 
//                 break;
             case 4:
                AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);  
                dialogo2.setTitle("Salir");  
                dialogo2.setMessage("¿Seguro quiere salir de la aplicacion ?");            
                dialogo2.setCancelable(false);  
                dialogo2.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialogo2, int id) {  
                        System.exit(0);
                    }  
                });  
                dialogo2.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialogo2, int id) {  
                        dialogo2.dismiss();
                    }
                }); 
                dialogo2.show(); 
                 break;      
         }
          
        

         // update selected item and title, then close the drawer
         mDrawerList.setItemChecked(position, true);
         setTitle(mOpcionesTitles[position]);
         mDrawerLayout.closeDrawer(mDrawerList);
        
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) 
                return true;
            else
                return false;   
    }
    
    
     
    
}
