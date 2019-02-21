
package com.quiniela.quinielale.tics;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class FragmentoResultados extends Fragment{
    TextView tvreslocal1,tvresvisita1,tvequipo1,tvequipo2,
            tvreslocal2,tvresvisita2,tvequipo3,tvequipo4,
            tvreslocal3,tvresvisita3,tvequipo5,tvequipo6,
            tvreslocal4,tvresvisita4,tvequipo7,tvequipo8,
            tvreslocal5,tvresvisita5,tvequipo9,tvequipo10,
            tvreslocal6,tvresvisita6,tvequipo11,tvequipo12,
            tvreslocal7,tvresvisita7,tvequipo13,tvequipo14,
            tvreslocal8,tvresvisita8,tvequipo15,tvequipo16,
            tvreslocal9,tvresvisita9,tvequipo17,tvequipo18,
            tvreslocal10,tvresvisita10,tvequipo19,tvequipo20;
     Spinner spinnerJornadas;
     
      final String locales[] = new String[10];
    final String visitantes[] = new String[10];
    final String resLocales[]=new String[10];
    final String resVisitantes[]=new String[10];
    
    TextView tvJornada;
     
      public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragmentoresultados, container, false); 
       ((MenuPrincipal) getActivity()).getActionBar().setTitle("Resultados");
       
        tvJornada = (TextView)view.findViewById(R.id.tvJornada);
    
        tvreslocal1=(TextView)view.findViewById(R.id.tvreslocal1);
        tvresvisita1=(TextView)view.findViewById(R.id.tvresvisita1);
        
        tvequipo1=(TextView)view.findViewById(R.id.tvequipo1);
        tvequipo2=(TextView)view.findViewById(R.id.tvequipo2);
        
        tvreslocal2=(TextView)view.findViewById(R.id.tvreslocal2);
        tvresvisita2=(TextView)view.findViewById(R.id.tvresvisita2);
        
        tvequipo3=(TextView)view.findViewById(R.id.tvequipo3);
        tvequipo4=(TextView)view.findViewById(R.id.tvequipo4);
        
        tvreslocal3=(TextView)view.findViewById(R.id.tvreslocal3);
        tvresvisita3=(TextView)view.findViewById(R.id.tvresvisita3);
        
        tvequipo5=(TextView)view.findViewById(R.id.tvequipo5);
        tvequipo6=(TextView)view.findViewById(R.id.tvequipo6);
        
        tvreslocal4=(TextView)view.findViewById(R.id.tvreslocal4);
        tvresvisita4=(TextView)view.findViewById(R.id.tvresvisita4);
        
        tvequipo7=(TextView)view.findViewById(R.id.tvequipo7);
        tvequipo8=(TextView)view.findViewById(R.id.tvequipo8);
        
        tvreslocal5=(TextView)view.findViewById(R.id.tvreslocal5);
        tvresvisita5=(TextView)view.findViewById(R.id.tvresvisita5);
        
        tvequipo9=(TextView)view.findViewById(R.id.tvequipo9);
        tvequipo10=(TextView)view.findViewById(R.id.tvequipo10);
                
        tvreslocal6=(TextView)view.findViewById(R.id.tvreslocal6);
        tvresvisita6=(TextView)view.findViewById(R.id.tvresvisita6);
        
        tvequipo11=(TextView)view.findViewById(R.id.tvequipo11);
        tvequipo12=(TextView)view.findViewById(R.id.tvequipo12);
        
        tvreslocal7=(TextView)view.findViewById(R.id.tvreslocal7);
        tvresvisita7=(TextView)view.findViewById(R.id.tvresvisita7);
        
        tvequipo13=(TextView)view.findViewById(R.id.tvequipo13);
        tvequipo14=(TextView)view.findViewById(R.id.tvequipo14);
        
        tvreslocal8=(TextView)view.findViewById(R.id.tvreslocal8);
        tvresvisita8=(TextView)view.findViewById(R.id.tvresvisita8);
        
        tvequipo15=(TextView)view.findViewById(R.id.tvequipo15);
        tvequipo16=(TextView)view.findViewById(R.id.tvequipo16);
        
        tvreslocal9=(TextView)view.findViewById(R.id.tvreslocal9);
        tvresvisita9=(TextView)view.findViewById(R.id.tvresvisita9);
        
        tvequipo17=(TextView)view.findViewById(R.id.tvequipo17);
        tvequipo18=(TextView)view.findViewById(R.id.tvequipo18);
        
        tvreslocal10=(TextView)view.findViewById(R.id.tvreslocal10);
        tvresvisita10=(TextView)view.findViewById(R.id.tvresvisita10);
        
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
        
        //generaJornadas();
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
                     resLocales[i]= articles.getJSONObject(i).getString("local_goals").toString();
                     resVisitantes[i]= articles.getJSONObject(i).getString("visitor_goals").toString();
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
                
                tvreslocal1.setText(resLocales[0]);
                tvreslocal2.setText(resLocales[1]);
                tvreslocal3.setText(resLocales[2]);
                tvreslocal4.setText(resLocales[3]);
                tvreslocal5.setText(resLocales[4]);
                tvreslocal6.setText(resLocales[5]);
                tvreslocal7.setText(resLocales[6]);
                tvreslocal8.setText(resLocales[7]);
                tvreslocal9.setText(resLocales[8]);
                tvreslocal10.setText(resLocales[9]);
                
                tvresvisita1.setText(resVisitantes[0]);
                tvresvisita2.setText(resVisitantes[1]);
                tvresvisita3.setText(resVisitantes[2]);
                tvresvisita4.setText(resVisitantes[3]);
                tvresvisita5.setText(resVisitantes[4]);
                tvresvisita6.setText(resVisitantes[5]);
                tvresvisita7.setText(resVisitantes[6]);
                tvresvisita8.setText(resVisitantes[7]);
                tvresvisita9.setText(resVisitantes[8]);
                tvresvisita10.setText(resVisitantes[9]);
                
                tvreslocal2.setTextColor(Color.BLACK);
                tvreslocal4.setTextColor(Color.BLACK);
                tvreslocal6.setTextColor(Color.BLACK);
                tvreslocal8.setTextColor(Color.BLACK);
                tvreslocal10.setTextColor(Color.BLACK);
                
                tvresvisita2.setTextColor(Color.BLACK);
                tvresvisita4.setTextColor(Color.BLACK);
                tvresvisita6.setTextColor(Color.BLACK);
                tvresvisita8.setTextColor(Color.BLACK);
                tvresvisita10.setTextColor(Color.BLACK);
                
                }
             catch (JSONException ex) 
             {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
     }
}
