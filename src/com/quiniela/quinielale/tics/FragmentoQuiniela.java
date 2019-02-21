
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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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

/**
 *
 * @author Pepe
 */
public class FragmentoQuiniela extends Fragment{
    
     
    Spinner spinnerJornadas;
     
    TextView tvEquipo1, tvEquipo2;
    TextView tvEquipo3, tvEquipo4;
    TextView tvEquipo5, tvEquipo6;
    TextView tvEquipo7, tvEquipo8;
    TextView tvEquipo9, tvEquipo10;
    TextView tvEquipo11, tvEquipo12;
    TextView tvEquipo13, tvEquipo14;
    TextView tvEquipo15, tvEquipo16;
    TextView tvEquipo17, tvEquipo18;
    TextView tvEquipo19, tvEquipo20;
    
    RelativeLayout Encuentro1;
    RadioGroup rgjuego1;
    RadioButton rblocal1,rbempate1,rbvisita1;
    
    RelativeLayout Encuentro2;
    RadioGroup rgjuego2;
    RadioButton rblocal2,rbempate2,rbvisita2;
    
    RelativeLayout Encuentro3;
    RadioGroup rgjuego3;
    RadioButton rblocal3,rbempate3,rbvisita3;
    
    RelativeLayout Encuentro4;
    RadioGroup rgjuego4;
    RadioButton rblocal4,rbempate4,rbvisita4;
    
    RelativeLayout Encuentro5;
    RadioGroup rgjuego5;
    RadioButton rblocal5,rbempate5,rbvisita5;
    
    RelativeLayout Encuentro6;
    RadioGroup rgjuego6;
    RadioButton rblocal6,rbempate6,rbvisita6;
    
    RelativeLayout Encuentro7;
    RadioGroup rgjuego7;
    RadioButton rblocal7,rbempate7,rbvisita7;
    
    RelativeLayout Encuentro8;
    RadioGroup rgjuego8;
    RadioButton rblocal8,rbempate8,rbvisita8;
    
    RelativeLayout Encuentro9;
    RadioGroup rgjuego9;
    RadioButton rblocal9,rbempate9,rbvisita9;
    
    RelativeLayout Encuentro10;
    RadioGroup rgjuego10;
    RadioButton rblocal10,rbempate10,rbvisita10;
   
    final String comparadores[] = new String[10];
    final String locales[] = new String[10];
    final String visitantes[] = new String[10];
    final String vencedores[] = new String[10];
  
    Button btJugar; 
    
    String vencedor ="";
    int aciertos;
    String winLocal = "ganadorLocal";
    String draw = "empate";
    String winVisita = "ganadorVisita";
    
    TextView tvAciertos, tvJornada;
     
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragmentoquiniela, container, false); 
       ((MenuPrincipal) getActivity()).getActionBar().setTitle("Quiniela");
 
        tvAciertos = (TextView)view.findViewById(R.id.tvAciertos);
        tvJornada = (TextView)view.findViewById(R.id.tvJornada);
        
        Encuentro1 = (RelativeLayout)view.findViewById(R.id.Encuentro1);
        rgjuego1= (RadioGroup)view.findViewById(R.id.rgjuego1);        
        rblocal1=(RadioButton)view.findViewById(R.id.rblocal1);
        rbempate1=(RadioButton)view.findViewById(R.id.rbempate1);
        rbvisita1=(RadioButton)view.findViewById(R.id.rbvisita1);
        
        Encuentro2 = (RelativeLayout)view.findViewById(R.id.Encuentro2);
        rgjuego2= (RadioGroup)view.findViewById(R.id.rgjuego2);        
        rblocal2=(RadioButton)view.findViewById(R.id.rblocal2);
        rbempate2=(RadioButton)view.findViewById(R.id.rbempate2);
        rbvisita2=(RadioButton)view.findViewById(R.id.rbvisita2);
        
        Encuentro3 = (RelativeLayout)view.findViewById(R.id.Encuentro3);
        rgjuego3= (RadioGroup)view.findViewById(R.id.rgjuego3);        
        rblocal3=(RadioButton)view.findViewById(R.id.rblocal3);
        rbempate3=(RadioButton)view.findViewById(R.id.rbempate3);
        rbvisita3=(RadioButton)view.findViewById(R.id.rbvisita3);
        
        Encuentro4 = (RelativeLayout)view.findViewById(R.id.Encuentro4);
        rgjuego4= (RadioGroup)view.findViewById(R.id.rgjuego4);        
        rblocal4=(RadioButton)view.findViewById(R.id.rblocal4);
        rbempate4=(RadioButton)view.findViewById(R.id.rbempate4);
        rbvisita4=(RadioButton)view.findViewById(R.id.rbvisita4);
        
        Encuentro5 = (RelativeLayout)view.findViewById(R.id.Encuentro5);
        rgjuego5= (RadioGroup)view.findViewById(R.id.rgjuego5);        
        rblocal5=(RadioButton)view.findViewById(R.id.rblocal5);
        rbempate5=(RadioButton)view.findViewById(R.id.rbempate5);
        rbvisita5=(RadioButton)view.findViewById(R.id.rbvisita5);
        
        Encuentro6 = (RelativeLayout)view.findViewById(R.id.Encuentro6);
        rgjuego6= (RadioGroup)view.findViewById(R.id.rgjuego6);        
        rblocal6=(RadioButton)view.findViewById(R.id.rblocal6);
        rbempate6=(RadioButton)view.findViewById(R.id.rbempate6);
        rbvisita6=(RadioButton)view.findViewById(R.id.rbvisita6);
        
        Encuentro7 = (RelativeLayout)view.findViewById(R.id.Encuentro7);
        rgjuego7= (RadioGroup)view.findViewById(R.id.rgjuego7);        
        rblocal7=(RadioButton)view.findViewById(R.id.rblocal7);
        rbempate7=(RadioButton)view.findViewById(R.id.rbempate7);
        rbvisita7=(RadioButton)view.findViewById(R.id.rbvisita7);
        
        Encuentro8 = (RelativeLayout)view.findViewById(R.id.Encuentro8);
        rgjuego8= (RadioGroup)view.findViewById(R.id.rgjuego8);        
        rblocal8=(RadioButton)view.findViewById(R.id.rblocal8);
        rbempate8=(RadioButton)view.findViewById(R.id.rbempate8);
        rbvisita8=(RadioButton)view.findViewById(R.id.rbvisita8);
        
        Encuentro9 = (RelativeLayout)view.findViewById(R.id.Encuentro9);
        rgjuego9= (RadioGroup)view.findViewById(R.id.rgjuego9);        
        rblocal9=(RadioButton)view.findViewById(R.id.rblocal9);
        rbempate9=(RadioButton)view.findViewById(R.id.rbempate9);
        rbvisita9=(RadioButton)view.findViewById(R.id.rbvisita9);
        
        Encuentro10 = (RelativeLayout)view.findViewById(R.id.Encuentro10);
        rgjuego10= (RadioGroup)view.findViewById(R.id.rgjuego10);        
        rblocal10=(RadioButton)view.findViewById(R.id.rblocal10);
        rbempate10=(RadioButton)view.findViewById(R.id.rbempate10);
        rbvisita10=(RadioButton)view.findViewById(R.id.rbvisita10);
        
        
        tvEquipo1 = (TextView)view.findViewById(R.id.tvequipo1);
        tvEquipo2 = (TextView)view.findViewById(R.id.tvequipo2);
        tvEquipo3 = (TextView)view.findViewById(R.id.tvequipo3);
        tvEquipo4 = (TextView)view.findViewById(R.id.tvequipo4);
        tvEquipo5 = (TextView)view.findViewById(R.id.tvequipo5);
        tvEquipo6 = (TextView)view.findViewById(R.id.tvequipo6);
        tvEquipo7 = (TextView)view.findViewById(R.id.tvequipo7);
        tvEquipo8 = (TextView)view.findViewById(R.id.tvequipo8);
        tvEquipo9 = (TextView)view.findViewById(R.id.tvequipo9);
        tvEquipo10 =(TextView)view.findViewById(R.id.tvequipo10);
        tvEquipo11 = (TextView)view.findViewById(R.id.tvequipo11);
        tvEquipo12 = (TextView)view.findViewById(R.id.tvequipo12);
        tvEquipo13 = (TextView)view.findViewById(R.id.tvequipo13);
        tvEquipo14 = (TextView)view.findViewById(R.id.tvequipo14);
        tvEquipo15 = (TextView)view.findViewById(R.id.tvequipo15);
        tvEquipo16 = (TextView)view.findViewById(R.id.tvequipo16);
        tvEquipo17 = (TextView)view.findViewById(R.id.tvequipo17);
        tvEquipo18 = (TextView)view.findViewById(R.id.tvequipo18);
        tvEquipo19 = (TextView)view.findViewById(R.id.tvequipo19);
        tvEquipo20 =(TextView)view.findViewById(R.id.tvequipo20);
        
        btJugar = (Button)view.findViewById(R.id.btJugar);
        spinnerJornadas = (Spinner)view.findViewById(R.id.spinnerJornadas);
        
        new HttpAsyncTask2().execute("http://www.resultados-futbol.com/scripts/api/api.php?&key=d34b2e471eb7ad025d57149f84f4242f&tz=America/Mexico_City&format=json&req=matchs&league=1"); 
        
        spinnerJornadas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               
                btJugar.setEnabled(true);
                
                rgjuego1.clearCheck();
                rblocal1.setChecked(false);
                rbempate1.setChecked(false);
                rbvisita1.setChecked(false);
                rblocal1.setEnabled(true);
                rbempate1.setEnabled(true);
                rbvisita1.setEnabled(true);
//                
                rgjuego2.clearCheck();
                rblocal2.setChecked(false);
                rbempate2.setChecked(false);
                rbvisita2.setChecked(false);
                rblocal2.setEnabled(true);
                rbempate2.setEnabled(true);
                rbvisita2.setEnabled(true);
                
                rgjuego3.clearCheck();
                rblocal3.setChecked(false);
                rbempate3.setChecked(false);
                rbvisita3.setChecked(false);
                rblocal3.setEnabled(true);
                rbempate3.setEnabled(true);
                rbvisita3.setEnabled(true);
                
                rgjuego4.clearCheck();
                rblocal4.setChecked(false);
                rbempate4.setChecked(false);
                rbvisita4.setChecked(false);
                rblocal4.setEnabled(true);
                rbempate4.setEnabled(true);
                rbvisita4.setEnabled(true);
                
                rgjuego5.clearCheck();
                rblocal5.setChecked(false);
                rbempate5.setChecked(false);
                rbvisita5.setChecked(false);
                rblocal5.setEnabled(true);
                rbempate5.setEnabled(true);
                rbvisita5.setEnabled(true);
                
                rgjuego6.clearCheck();
                rblocal6.setChecked(false);
                rbempate6.setChecked(false);
                rbvisita6.setChecked(false);
                rblocal6.setEnabled(true);
                rbempate6.setEnabled(true);
                rbvisita6.setEnabled(true);
                
                rgjuego7.clearCheck();
                rblocal7.setChecked(false);
                rbempate7.setChecked(false);
                rbvisita7.setChecked(false);
                rblocal7.setEnabled(true);
                rbempate7.setEnabled(true);
                rbvisita7.setEnabled(true);
                
                rgjuego8.clearCheck();
                rblocal8.setChecked(false);
                rbempate8.setChecked(false);
                rbvisita8.setChecked(false);
                rblocal8.setEnabled(true);
                rbempate8.setEnabled(true);
                rbvisita8.setEnabled(true);
                
                rgjuego9.clearCheck();
                rblocal9.setChecked(false);
                rbempate9.setChecked(false);
                rbvisita9.setChecked(false);
                rblocal9.setEnabled(true);
                rbempate9.setEnabled(true);
                rbvisita9.setEnabled(true);
                
                rgjuego10.clearCheck();
                rblocal10.setChecked(false);
                rbempate10.setChecked(false);
                rbvisita10.setChecked(false);
                rblocal10.setEnabled(true);
                rbempate10.setEnabled(true);
                rbvisita10.setEnabled(true);
                
               
                try{
                  int jornada = 38;
                if(jornada != 0){
                for (int i = 1; i < 39; i++) {
                    if(jornada == i ){
                        jornada = spinnerJornadas.getSelectedItemPosition();
                        String url = "http://www.resultados-futbol.com/scripts/api/api.php?&key=d34b2e471eb7ad025d57149f84f4242f&tz=America/Mexico_City&format=json&req=matchs&league=1&round=" + jornada;
                        String url2 = "http://www.resultados-futbol.com/scripts/api/api.php?&key=d34b2e471eb7ad025d57149f84f4242f&tz=America/Mexico_City&format=json&req=matchs&league=1&round=" + jornada;
                        new HttpAsyncTask().execute(url);
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
                String jornada;
            }
        });
        
        
        
        rgjuego1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal1){
                    comparadores[0] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate1){
                    comparadores[0] = "empate";                 
                }else if (checkedId == R.id.rbvisita1){
                    comparadores[0]= "ganadorVisita";
                }else{
                    comparadores[0]="nulo";
                }
            }
        });
        
        rgjuego2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal2){
                    comparadores[1] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate2){
                    comparadores[1] = "empate";                 
                }else if (checkedId == R.id.rbvisita2){
                    comparadores[1] = "ganadorVisita";
                }else{
                    comparadores[1]="nulo";
                }
            }
        });
        
        rgjuego3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal3){
                    comparadores[2] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate3){
                    comparadores[2] = "empate";                 
                }else if (checkedId == R.id.rbvisita3){
                    comparadores[2] = "ganadorVisita";
                }else{
                    comparadores[2]="nulo";
                }
            }
        });
        
        rgjuego4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal4){
                    comparadores[3] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate4){
                    comparadores[3] = "empate";                 
                }else if (checkedId == R.id.rbvisita4){
                    comparadores[3] = "ganadorVisita";
                }else{
                    comparadores[3]="nulo";
                }
            }
        });
        
        rgjuego5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal5){
                    comparadores[4] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate5){
                    comparadores[4] = "empate";                 
                }else if (checkedId == R.id.rbvisita5){
                    comparadores[4] = "ganadorVisita";
                }else{
                    comparadores[4]="nulo";
                }
            }
        });
        
        rgjuego6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal6){
                    comparadores[5] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate6){
                    comparadores[5] = "empate";                 
                }else if (checkedId == R.id.rbvisita6){
                    comparadores[5] = "ganadorVisita";
                }else{
                    comparadores[5]="nulo";
                }
            }
        });
        
        rgjuego7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal7){
                    comparadores[6] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate7){
                    comparadores[6] = "empate";                 
                }else if (checkedId == R.id.rbvisita7){
                    comparadores[6] = "ganadorVisita";
                }else{
                    comparadores[6]="nulo";
                }
            }
        });
        
        rgjuego8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal8){
                    comparadores[7] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate8){
                    comparadores[7] = "empate";                 
                }else if (checkedId == R.id.rbvisita8){
                    comparadores[7] = "ganadorVisita";
                }else{
                    comparadores[7]="nulo";
                }
            }
        });
        
        rgjuego9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal9){
                    comparadores[8] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate9){
                    comparadores[8] = "empate";                 
                }else if (checkedId == R.id.rbvisita9){
                    comparadores[8] = "ganadorVisita";
                }else{
                    comparadores[8]="nulo";
                }
            }
        });
        
        rgjuego10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rblocal10){
                    comparadores[9] = "ganadorLocal";
                }else if (checkedId == R.id.rbempate10){
                    comparadores[9] = "empate";                 
                }else if (checkedId == R.id.rbvisita10){
                    comparadores[9] = "ganadorVisita";
                }else{
                    comparadores[9]="nulo";
                }
            }
        });
        
         
 
       
         btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 
               eventoJugar();
 
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
                 }  
                
                
               
                
                tvEquipo1.setText(locales[0]);
                tvEquipo2.setText(visitantes[0]);
                tvEquipo3.setText(locales[1]);
                tvEquipo4.setText(visitantes[1]);
                tvEquipo5.setText(locales[2]);
                tvEquipo6.setText(visitantes[2]);
                tvEquipo7.setText(locales[3]);
                tvEquipo8.setText(visitantes[3]);
                tvEquipo9.setText(locales[4]);
                tvEquipo10.setText(visitantes[4]);
                tvEquipo11.setText(locales[5]);
                tvEquipo12.setText(visitantes[5]);
                tvEquipo13.setText(locales[6]);
                tvEquipo14.setText(visitantes[6]);
                tvEquipo15.setText(locales[7]);
                tvEquipo16.setText(visitantes[7]);
                tvEquipo17.setText(locales[8]);
                tvEquipo18.setText(visitantes[8]);
                tvEquipo19.setText(locales[9]);
                tvEquipo20.setText(visitantes[9]);
                
                }
             catch (JSONException ex) 
             {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
     }
    
    private class HttpAsyncTask extends AsyncTask<String, Void, String> 
    {

        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getActivity(), "Received!", Toast.LENGTH_LONG).show();
            JSONObject json;

            
             try 
             {
                json = new JSONObject(result);               
                JSONArray articles = json.getJSONArray("match");

                String marcadores;
                String marcadorLocal;
                String marcadorVisita;
                
                aciertos=0;
                
                String jornada = articles.getJSONObject(0).getString("round").toString(); 
               
                tvJornada.setText("Jornada " +  jornada  );
                for (int i = 0; i < comparadores.length; i++) {
                    
                    marcadorLocal= articles.getJSONObject(i).getString("local_goals").toString();
                    marcadorVisita= articles.getJSONObject(i).getString("visitor_goals").toString();
                    
                    int mrcLocal = Integer.parseInt(marcadorLocal);
                    int mrcVisita = Integer.parseInt(marcadorVisita);
                    
                    if(mrcLocal > mrcVisita){
                       vencedores[i]= vencedor = winLocal;
                    }                    
                    if(mrcLocal < mrcVisita){
                        vencedores[i]= vencedor = winVisita;
                    }
                    if(mrcLocal == mrcVisita){
                        vencedores[i]= vencedor = draw;
                    }
                  
                }
               
                   if(vencedores[0].equals(comparadores[0])){
                       Encuentro1.setBackgroundColor(Color.GREEN);
                       aciertos++;
                       
                   }
                   if(comparadores[0].equals("nulo")){
                       Encuentro1.setBackgroundColor(Color.BLACK);
                   }
                   else if(vencedores[0] != comparadores[0]){
                       Encuentro1.setBackgroundColor(Color.RED);
                   }
                   
                   
                   if(vencedores[1].equals(comparadores[1])){
                       Encuentro2.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[1].equals("nulo")){
                       Encuentro2.setBackgroundColor(Color.WHITE);
                   }
                   else if(vencedores[1] != comparadores[1]){
                       Encuentro2.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[2].equals(comparadores[2])){
                       Encuentro3.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[2].equals("nulo")){
                       Encuentro3.setBackgroundColor(Color.BLACK);
                   }
                   else if(vencedores[2] != comparadores[2]){
                       Encuentro3.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[3].equals(comparadores[3])){
                       Encuentro4.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                   if(comparadores[3].equals("nulo")){
                       Encuentro4.setBackgroundColor(Color.WHITE);
                   }
                   else if(vencedores[3] != comparadores[3]){
                       Encuentro4.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[4].equals(comparadores[4])){
                       Encuentro5.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                   if(comparadores[4].equals("nulo")){
                       Encuentro5.setBackgroundColor(Color.BLACK);
                   }
                   else if(vencedores[4] != comparadores[4]){
                       Encuentro5.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[5].equals(comparadores[5])){
                       Encuentro6.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[5].equals("nulo")){
                       Encuentro6.setBackgroundColor(Color.WHITE);
                   }
                   else if(vencedores[5] != comparadores[5]){
                       Encuentro6.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[6].equals(comparadores[6])){
                       Encuentro7.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[6].equals("nulo")){
                       Encuentro7.setBackgroundColor(Color.BLACK);
                   }
                   else if(vencedores[6] != comparadores[6]){
                       Encuentro7.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[7].equals(comparadores[7])){
                       Encuentro8.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[7].equals("nulo")){
                       Encuentro8.setBackgroundColor(Color.WHITE);
                   }
                   else if(vencedores[7] != comparadores[7]){
                       Encuentro8.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[8].equals(comparadores[8])){
                       Encuentro9.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[8].equals("nulo")){
                       Encuentro9.setBackgroundColor(Color.BLACK);
                   }
                   else if(vencedores[8] != comparadores[8]){
                       Encuentro9.setBackgroundColor(Color.RED);
                   }
                   
                   if(vencedores[9].equals(comparadores[9])){
                       Encuentro10.setBackgroundColor(Color.GREEN);
                       aciertos++;
                   }
                    if(comparadores[9].equals("nulo")){
                       Encuentro10.setBackgroundColor(Color.WHITE);
                   }
                   else if(vencedores[9] != comparadores[9]){
                       Encuentro10.setBackgroundColor(Color.RED);
                   }
               
                   tvAciertos.setText(aciertos + " / 10 aciertos");
                
             }
             catch (JSONException ex) 
             {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }
     public void eventoJugar()
     {
         btJugar.setEnabled(false);
         
         rblocal1.setEnabled(false);
         rbempate1.setEnabled(false);
         rbvisita1.setEnabled(false);
         
         rblocal2.setEnabled(false);
         rbempate2.setEnabled(false);
         rbvisita2.setEnabled(false);
         
         rblocal3.setEnabled(false);
         rbempate3.setEnabled(false);
         rbvisita3.setEnabled(false);
         
          rblocal4.setEnabled(false);
         rbempate4.setEnabled(false);
         rbvisita4.setEnabled(false);
         
          rblocal5.setEnabled(false);
         rbempate5.setEnabled(false);
         rbvisita5.setEnabled(false);
         
          rblocal6.setEnabled(false);
         rbempate6.setEnabled(false);
         rbvisita6.setEnabled(false);
         
          rblocal7.setEnabled(false);
         rbempate7.setEnabled(false);
         rbvisita7.setEnabled(false);
         
          rblocal8.setEnabled(false);
         rbempate8.setEnabled(false);
         rbvisita8.setEnabled(false);
         
          rblocal9.setEnabled(false);
         rbempate9.setEnabled(false);
         rbvisita9.setEnabled(false);
         
          rblocal10.setEnabled(false);
         rbempate10.setEnabled(false);
         rbvisita10.setEnabled(false);
         
         new HttpAsyncTask().execute("http://www.resultados-futbol.com/scripts/api/api.php?&key=d34b2e471eb7ad025d57149f84f4242f&tz=America/Mexico_City&format=json&req=matchs&league=1&round=38");
     }
     
}
