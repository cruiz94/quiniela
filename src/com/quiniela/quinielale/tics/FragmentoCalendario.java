
package com.quiniela.quinielale.tics;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.quiniela.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FragmentoCalendario extends Fragment{
    
    TextView tvcaljuego1,tvequipo1,tvequipo2,
            tvcaljuego2,tvequipo3,tvequipo4,
            tvcaljuego3,tvequipo5,tvequipo6,
            tvcaljuego4,tvequipo7,tvequipo8,
            tvcaljuego5,tvequipo9,tvequipo10,
            tvcaljuego6,tvequipo11,tvequipo12,
            tvcaljuego7,tvequipo13,tvequipo14,
            tvcaljuego8,tvequipo15,tvequipo16,
            tvcaljuego9,tvequipo17,tvequipo18,
            tvcaljuego10,tvequipo19,tvequipo20;
     Spinner spinnerJornadas;
     
     final String locales[] = new String[10];
    final String visitantes[] = new String[10];
    final String fechas[]=new String[10];
    
    TextView tvJornada;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragmentocalendario, container, false);
     
        
       ((MenuPrincipal) getActivity()).getActionBar().setTitle("Calendario");
 
        
        tvJornada = (TextView)view.findViewById(R.id.tvJornada);
        tvcaljuego1=(TextView)view.findViewById(R.id.tvcaljuego1);
        
        tvequipo1=(TextView)view.findViewById(R.id.tvequipo1);
        tvequipo2=(TextView)view.findViewById(R.id.tvequipo2);
        
        tvcaljuego2=(TextView)view.findViewById(R.id.tvcaljuego2);
        
        tvequipo3=(TextView)view.findViewById(R.id.tvequipo3);
        tvequipo4=(TextView)view.findViewById(R.id.tvequipo4);
        
        tvcaljuego3=(TextView)view.findViewById(R.id.tvcaljuego3);
        
        tvequipo5=(TextView)view.findViewById(R.id.tvequipo5);
        tvequipo6=(TextView)view.findViewById(R.id.tvequipo6);
        
        
        tvcaljuego4=(TextView)view.findViewById(R.id.tvcaljuego4);
        
        tvequipo7=(TextView)view.findViewById(R.id.tvequipo7);
        tvequipo8=(TextView)view.findViewById(R.id.tvequipo8);
        
        tvcaljuego5=(TextView)view.findViewById(R.id.tvcaljuego5);
        
        tvequipo9=(TextView)view.findViewById(R.id.tvequipo9);
        tvequipo10=(TextView)view.findViewById(R.id.tvequipo10);
        
        tvcaljuego6=(TextView)view.findViewById(R.id.tvcaljuego6);
        
        tvequipo11=(TextView)view.findViewById(R.id.tvequipo11);
        tvequipo12=(TextView)view.findViewById(R.id.tvequipo12);
        
        tvcaljuego7=(TextView)view.findViewById(R.id.tvcaljuego7);
        
        tvequipo13=(TextView)view.findViewById(R.id.tvequipo13);
        tvequipo14=(TextView)view.findViewById(R.id.tvequipo14);
        
        tvcaljuego8=(TextView)view.findViewById(R.id.tvcaljuego8);
        
        tvequipo15=(TextView)view.findViewById(R.id.tvequipo15);
        tvequipo16=(TextView)view.findViewById(R.id.tvequipo16);
        
        tvcaljuego9=(TextView)view.findViewById(R.id.tvcaljuego9);
        
        tvequipo17=(TextView)view.findViewById(R.id.tvequipo17);
        tvequipo18=(TextView)view.findViewById(R.id.tvequipo18);
        
        tvcaljuego10=(TextView)view.findViewById(R.id.tvcaljuego10);
        
        tvequipo19=(TextView)view.findViewById(R.id.tvequipo19);
        tvequipo20=(TextView)view.findViewById(R.id.tvequipo20);
        
        spinnerJornadas = (Spinner)view.findViewById(R.id.spinnerJornadas);
        
        
        new HttpAsyncTask2().execute("http://www.resultados-futbol.com/scripts/api/api.php?&key=d34b2e471eb7ad025d57149f84f4242f&tz=America/Mexico_City&format=json&req=matchs&league=1"); 
        
        spinnerJornadas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try{
                  int jornada = 38;
                if(jornada != 0){
                for (int i = 1; i < 39; i++) {
                    if(jornada == i ){
                        jornada = spinnerJornadas.getSelectedItemPosition();
                        
                        String url2 = "http://www.resultados-futbol.com/scripts/api/api.php?&key=d34b2e471eb7ad025d57149f84f4242f&tz=America/Mexico_City&format=json&req=matchs&league=1&round=" + jornada;
                        
                        new HttpAsyncTask2().execute(url2);
                    } 
                }
                }
                }
                catch(Exception ex){
                    Toast.makeText(getActivity(), "Que paso amiguito" + spinnerJornadas.getSelectedItemPosition() , 2).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        
        
        return view;
    }
    
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {
 
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
 
            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        return result;
    }
 
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }  
    
     private class HttpAsyncTask2 extends AsyncTask<String, Void, String> 
    {

        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        
        @Override
        protected void onPostExecute(String result) {
            JSONObject json;
            
            try 
             {
                json = new JSONObject(result);               
                JSONArray articles = json.getJSONArray("match");
                
                String jornada = articles.getJSONObject(0).getString("round").toString(); 
               
                tvJornada.setText("Jornada " +  jornada );
                for (int i = 0; i < locales.length; i++) {
                     locales[i] = articles.getJSONObject(i).getString("local").toString();
                     visitantes[i] = articles.getJSONObject(i).getString("visitor").toString();
                     fechas[i] = articles.getJSONObject(i).getString("schedule").toString(); 
                 }  
                
                
               
                
                tvequipo1.setText(locales[0]);
                tvequipo2.setText(visitantes[0]);
                tvequipo3.setText(locales[1]);
                tvequipo4.setText(visitantes[1]);
                tvequipo5.setText(locales[2]);
                tvequipo6.setText(visitantes[2]);
                tvequipo7.setText(locales[3]);
                tvequipo8.setText(visitantes[3]);
                tvequipo9.setText(locales[4]);
                tvequipo10.setText(visitantes[4]);
                tvequipo11.setText(locales[5]);
                tvequipo12.setText(visitantes[5]);
                tvequipo13.setText(locales[6]);
                tvequipo14.setText(visitantes[6]);
                tvequipo15.setText(locales[7]);
                tvequipo16.setText(visitantes[7]);
                tvequipo17.setText(locales[8]);
                tvequipo18.setText(visitantes[8]);
                tvequipo19.setText(locales[9]);
                tvequipo20.setText(visitantes[9]);
                
                tvcaljuego2.setTextColor(Color.BLACK);
                tvcaljuego4.setTextColor(Color.BLACK);
                tvcaljuego6.setTextColor(Color.BLACK);
                tvcaljuego8.setTextColor(Color.BLACK);
                tvcaljuego10.setTextColor(Color.BLACK);
                
                tvcaljuego1.setText(fechas[0]);               
                tvcaljuego2.setText(fechas[1]);
                tvcaljuego3.setText(fechas[2]);
                tvcaljuego4.setText(fechas[3]);
                tvcaljuego5.setText(fechas[4]);
                tvcaljuego6.setText(fechas[5]);
                tvcaljuego7.setText(fechas[6]);
                tvcaljuego8.setText(fechas[7]);
                tvcaljuego9.setText(fechas[8]);
                tvcaljuego10.setText(fechas[9]);
                
                }
             catch (JSONException ex) 
             {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
     }
    
}
