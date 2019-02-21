package com.quiniela.quinielale.tics;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import static android.content.ContentValues.TAG;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.quiniela.R;


public class Inicio extends Activity
{
    /** Called when the activity is first created. */
   
     
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.inicio);
        
      
        
          
       
    }
    
    public void eventoAcceder(View view)
    {
         if(isConnected()){
            Intent intento = new Intent(this, MenuPrincipal.class);
          startActivity(intento);
           this.finish();
            
        }
        else{
           AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);  
                dialogo2.setTitle("Error conexion a Internet");  
                dialogo2.setMessage("Verifique que tiene conexion a internet para poder acceder a Quiniela LE.");            
                dialogo2.setCancelable(false);  
                dialogo2.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialogo2, int id) {  
                         dialogo2.dismiss();
                    }  
                });  
                
                dialogo2.show(); 
        }
       
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
