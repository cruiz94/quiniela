
package com.quiniela.quinielale.tics;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

public class FragmentoPosiciones extends Fragment {
    
    TextView Posicion1, Equipo1, JuegosJugados1,DiferenciaGoles1,Puntos1,JuegosGanados1,JuegosEmpatados1,JuegosPerdidos1,GolesFavor1,GolesContra1;
    TextView Posicion2, Equipo2, JuegosJugados2,DiferenciaGoles2,Puntos2,JuegosGanados2,JuegosEmpatados2,JuegosPerdidos2,GolesFavor2,GolesContra2;
    TextView Posicion3, Equipo3, JuegosJugados3,DiferenciaGoles3,Puntos3,JuegosGanados3,JuegosEmpatados3,JuegosPerdidos3,GolesFavor3,GolesContra3;
    TextView Posicion4, Equipo4, JuegosJugados4,DiferenciaGoles4,Puntos4,JuegosGanados4,JuegosEmpatados4,JuegosPerdidos4,GolesFavor4,GolesContra4;
    TextView Posicion5, Equipo5, JuegosJugados5,DiferenciaGoles5,Puntos5,JuegosGanados5,JuegosEmpatados5,JuegosPerdidos5,GolesFavor5,GolesContra5;
    TextView Posicion6, Equipo6, JuegosJugados6,DiferenciaGoles6,Puntos6,JuegosGanados6,JuegosEmpatados6,JuegosPerdidos6,GolesFavor6,GolesContra6;
    TextView Posicion7, Equipo7, JuegosJugados7,DiferenciaGoles7,Puntos7,JuegosGanados7,JuegosEmpatados7,JuegosPerdidos7,GolesFavor7,GolesContra7;
    TextView Posicion8, Equipo8, JuegosJugados8,DiferenciaGoles8,Puntos8,JuegosGanados8,JuegosEmpatados8,JuegosPerdidos8,GolesFavor8,GolesContra8;
    TextView Posicion9, Equipo9, JuegosJugados9,DiferenciaGoles9,Puntos9,JuegosGanados9,JuegosEmpatados9,JuegosPerdidos9,GolesFavor9,GolesContra9;
    TextView Posicion10, Equipo10, JuegosJugados10,DiferenciaGoles10,Puntos10,JuegosGanados10,JuegosEmpatados10,JuegosPerdidos10,GolesFavor10,GolesContra10;
    TextView Posicion11, Equipo11, JuegosJugados11,DiferenciaGoles11,Puntos11,JuegosGanados11,JuegosEmpatados11,JuegosPerdidos11,GolesFavor11,GolesContra11;
    TextView Posicion12, Equipo12, JuegosJugados12,DiferenciaGoles12,Puntos12,JuegosGanados12,JuegosEmpatados12,JuegosPerdidos12,GolesFavor12,GolesContra12;
    TextView Posicion13, Equipo13, JuegosJugados13,DiferenciaGoles13,Puntos13,JuegosGanados13,JuegosEmpatados13,JuegosPerdidos13,GolesFavor13,GolesContra13;
    TextView Posicion14, Equipo14, JuegosJugados14,DiferenciaGoles14,Puntos14,JuegosGanados14,JuegosEmpatados14,JuegosPerdidos14,GolesFavor14,GolesContra14;
    TextView Posicion15, Equipo15, JuegosJugados15,DiferenciaGoles15,Puntos15,JuegosGanados15,JuegosEmpatados15,JuegosPerdidos15,GolesFavor15,GolesContra15;
    TextView Posicion16, Equipo16, JuegosJugados16,DiferenciaGoles16,Puntos16,JuegosGanados16,JuegosEmpatados16,JuegosPerdidos16,GolesFavor16,GolesContra16;
    TextView Posicion17, Equipo17, JuegosJugados17,DiferenciaGoles17,Puntos17,JuegosGanados17,JuegosEmpatados17,JuegosPerdidos17,GolesFavor17,GolesContra17;
    TextView Posicion18, Equipo18, JuegosJugados18,DiferenciaGoles18,Puntos18,JuegosGanados18,JuegosEmpatados18,JuegosPerdidos18,GolesFavor18,GolesContra18;
    TextView Posicion19, Equipo19, JuegosJugados19,DiferenciaGoles19,Puntos19,JuegosGanados19,JuegosEmpatados19,JuegosPerdidos19,GolesFavor19,GolesContra19;
    TextView Posicion20, Equipo20, JuegosJugados20,DiferenciaGoles20,Puntos20,JuegosGanados20,JuegosEmpatados20,JuegosPerdidos20,GolesFavor20,GolesContra20;
    
    String posiciones[] = new String[20];
    String equipos[] = new String[20];
    String juegosJugados[] = new String[20];
    String diferenciaGoles[] = new String[20];
    String puntajes[] = new String[20];
    String juegosganados[] = new String[20];
    String juegosempatados[] = new String[20];
    String juegosperdidos[] = new String[20];
    String golesafavor[] = new String[20];
    String golesencontra[] = new String[20];
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragmentoposiciones, container, false); 
       ((MenuPrincipal) getActivity()).getActionBar().setTitle("Posiciones");
       
       Posicion1 = (TextView)view.findViewById(R.id.Posicion1);
       Posicion2 = (TextView)view.findViewById(R.id.Posicion2);
       Posicion3 = (TextView)view.findViewById(R.id.Posicion3);
       Posicion4 = (TextView)view.findViewById(R.id.Posicion4);
       Posicion5 = (TextView)view.findViewById(R.id.Posicion5);
       Posicion6 = (TextView)view.findViewById(R.id.Posicion6);
       Posicion7 = (TextView)view.findViewById(R.id.Posicion7);
       Posicion8 = (TextView)view.findViewById(R.id.Posicion8);
       Posicion9 = (TextView)view.findViewById(R.id.Posicion9);
       Posicion10 = (TextView)view.findViewById(R.id.Posicion10);
       
       Posicion11 = (TextView)view.findViewById(R.id.Posicion11);
       Posicion12 = (TextView)view.findViewById(R.id.Posicion12);
       Posicion13 = (TextView)view.findViewById(R.id.Posicion13);
       Posicion14 = (TextView)view.findViewById(R.id.Posicion14);
       Posicion15 = (TextView)view.findViewById(R.id.Posicion15);
       Posicion16 = (TextView)view.findViewById(R.id.Posicion16);
       Posicion17 = (TextView)view.findViewById(R.id.Posicion17);
       Posicion18 = (TextView)view.findViewById(R.id.Posicion18);
       Posicion19 = (TextView)view.findViewById(R.id.Posicion19);
       Posicion20 = (TextView)view.findViewById(R.id.Posicion20);
       
       Equipo1 = (TextView)view.findViewById(R.id.Equipo1);
       Equipo2 = (TextView)view.findViewById(R.id.Equipo2);
       Equipo3 = (TextView)view.findViewById(R.id.Equipo3);
       Equipo4 = (TextView)view.findViewById(R.id.Equipo4);
       Equipo5 = (TextView)view.findViewById(R.id.Equipo5);
       Equipo6 = (TextView)view.findViewById(R.id.Equipo6);
       Equipo7 = (TextView)view.findViewById(R.id.Equipo7);
       Equipo8 = (TextView)view.findViewById(R.id.Equipo8);
       Equipo9 = (TextView)view.findViewById(R.id.Equipo9);
       Equipo10 = (TextView)view.findViewById(R.id.Equipo10);
       
       Equipo11 = (TextView)view.findViewById(R.id.Equipo11);
       Equipo12 = (TextView)view.findViewById(R.id.Equipo12);
       Equipo13 = (TextView)view.findViewById(R.id.Equipo13);
       Equipo14 = (TextView)view.findViewById(R.id.Equipo14);
       Equipo15 = (TextView)view.findViewById(R.id.Equipo15);
       Equipo16 = (TextView)view.findViewById(R.id.Equipo16);
       Equipo17 = (TextView)view.findViewById(R.id.Equipo17);
       Equipo18 = (TextView)view.findViewById(R.id.Equipo18);
       Equipo19 = (TextView)view.findViewById(R.id.Equipo19);
       Equipo20 = (TextView)view.findViewById(R.id.Equipo20);
       
       JuegosJugados1 = (TextView)view.findViewById(R.id.JuegosJugados1);
       JuegosJugados2 = (TextView)view.findViewById(R.id.JuegosJugados2);
       JuegosJugados3 = (TextView)view.findViewById(R.id.JuegosJugados3);
       JuegosJugados4 = (TextView)view.findViewById(R.id.JuegosJugados4);
       JuegosJugados5 = (TextView)view.findViewById(R.id.JuegosJugados5);
       JuegosJugados6 = (TextView)view.findViewById(R.id.JuegosJugados6);
       JuegosJugados7 = (TextView)view.findViewById(R.id.JuegosJugados7);
       JuegosJugados8 = (TextView)view.findViewById(R.id.JuegosJugados8);
       JuegosJugados9 = (TextView)view.findViewById(R.id.JuegosJugados9);
       JuegosJugados10 = (TextView)view.findViewById(R.id.JuegosJugados10);
       
       JuegosJugados11 = (TextView)view.findViewById(R.id.JuegosJugados11);
       JuegosJugados12 = (TextView)view.findViewById(R.id.JuegosJugados12);
       JuegosJugados13 = (TextView)view.findViewById(R.id.JuegosJugados13);
       JuegosJugados14 = (TextView)view.findViewById(R.id.JuegosJugados14);
       JuegosJugados15 = (TextView)view.findViewById(R.id.JuegosJugados15);
       JuegosJugados16 = (TextView)view.findViewById(R.id.JuegosJugados16);
       JuegosJugados17 = (TextView)view.findViewById(R.id.JuegosJugados17);
       JuegosJugados18 = (TextView)view.findViewById(R.id.JuegosJugados18);
       JuegosJugados19 = (TextView)view.findViewById(R.id.JuegosJugados19);
       JuegosJugados20 = (TextView)view.findViewById(R.id.JuegosJugados20);
       
       DiferenciaGoles1 = (TextView)view.findViewById(R.id.DiferenciaGoles1);
       DiferenciaGoles2 = (TextView)view.findViewById(R.id.DiferenciaGoles2);
       DiferenciaGoles3 = (TextView)view.findViewById(R.id.DiferenciaGoles3);
       DiferenciaGoles4 = (TextView)view.findViewById(R.id.DiferenciaGoles4);
       DiferenciaGoles5 = (TextView)view.findViewById(R.id.DiferenciaGoles5);
       DiferenciaGoles6 = (TextView)view.findViewById(R.id.DiferenciaGoles6);
       DiferenciaGoles7 = (TextView)view.findViewById(R.id.DiferenciaGoles7);
       DiferenciaGoles8 = (TextView)view.findViewById(R.id.DiferenciaGoles8);
       DiferenciaGoles9 = (TextView)view.findViewById(R.id.DiferenciaGoles9);
       DiferenciaGoles10 = (TextView)view.findViewById(R.id.DiferenciaGoles10);
       
       DiferenciaGoles11 = (TextView)view.findViewById(R.id.DiferenciaGoles11);
       DiferenciaGoles12 = (TextView)view.findViewById(R.id.DiferenciaGoles12);
       DiferenciaGoles13 = (TextView)view.findViewById(R.id.DiferenciaGoles13);
       DiferenciaGoles14 = (TextView)view.findViewById(R.id.DiferenciaGoles14);
       DiferenciaGoles15 = (TextView)view.findViewById(R.id.DiferenciaGoles15);
       DiferenciaGoles16 = (TextView)view.findViewById(R.id.DiferenciaGoles16);
       DiferenciaGoles17 = (TextView)view.findViewById(R.id.DiferenciaGoles17);
       DiferenciaGoles18 = (TextView)view.findViewById(R.id.DiferenciaGoles18);
       DiferenciaGoles19 = (TextView)view.findViewById(R.id.DiferenciaGoles19);
       DiferenciaGoles20 = (TextView)view.findViewById(R.id.DiferenciaGoles20);
       
       Puntos1 = (TextView)view.findViewById(R.id.Puntos1);
       Puntos2 = (TextView)view.findViewById(R.id.Puntos2);
       Puntos3 = (TextView)view.findViewById(R.id.Puntos3);
       Puntos4 = (TextView)view.findViewById(R.id.Puntos4);
       Puntos5 = (TextView)view.findViewById(R.id.Puntos5);
       Puntos6 = (TextView)view.findViewById(R.id.Puntos6);
       Puntos7 = (TextView)view.findViewById(R.id.Puntos7);
       Puntos8 = (TextView)view.findViewById(R.id.Puntos8);
       Puntos9 = (TextView)view.findViewById(R.id.Puntos9);
       Puntos10 = (TextView)view.findViewById(R.id.Puntos10);
       
       Puntos11 = (TextView)view.findViewById(R.id.Puntos11);
       Puntos12 = (TextView)view.findViewById(R.id.Puntos12);
       Puntos13 = (TextView)view.findViewById(R.id.Puntos13);
       Puntos14 = (TextView)view.findViewById(R.id.Puntos14);
       Puntos15 = (TextView)view.findViewById(R.id.Puntos15);
       Puntos16 = (TextView)view.findViewById(R.id.Puntos16);
       Puntos17 = (TextView)view.findViewById(R.id.Puntos17);
       Puntos18 = (TextView)view.findViewById(R.id.Puntos18);
       Puntos19 = (TextView)view.findViewById(R.id.Puntos19);
       Puntos20 = (TextView)view.findViewById(R.id.Puntos20);
       
       JuegosGanados1 = (TextView)view.findViewById(R.id.JuegosGanados1);
       JuegosGanados2 = (TextView)view.findViewById(R.id.JuegosGanados2);
       JuegosGanados3 = (TextView)view.findViewById(R.id.JuegosGanados3);
       JuegosGanados4 = (TextView)view.findViewById(R.id.JuegosGanados4);
       JuegosGanados5 = (TextView)view.findViewById(R.id.JuegosGanados5);
       JuegosGanados6 = (TextView)view.findViewById(R.id.JuegosGanados6);
       JuegosGanados7 = (TextView)view.findViewById(R.id.JuegosGanados7);
       JuegosGanados8 = (TextView)view.findViewById(R.id.JuegosGanados8);
       JuegosGanados9 = (TextView)view.findViewById(R.id.JuegosGanados9);
       JuegosGanados10 = (TextView)view.findViewById(R.id.JuegosGanados10);
       
       JuegosGanados11 = (TextView)view.findViewById(R.id.JuegosGanados11);
       JuegosGanados12 = (TextView)view.findViewById(R.id.JuegosGanados12);
       JuegosGanados13 = (TextView)view.findViewById(R.id.JuegosGanados13);
       JuegosGanados14 = (TextView)view.findViewById(R.id.JuegosGanados14);
       JuegosGanados15 = (TextView)view.findViewById(R.id.JuegosGanados15);
       JuegosGanados16 = (TextView)view.findViewById(R.id.JuegosGanados16);
       JuegosGanados17 = (TextView)view.findViewById(R.id.JuegosGanados17);
       JuegosGanados18 = (TextView)view.findViewById(R.id.JuegosGanados18);
       JuegosGanados19 = (TextView)view.findViewById(R.id.JuegosGanados19);
       JuegosGanados20 = (TextView)view.findViewById(R.id.JuegosGanados20);
       
       JuegosEmpatados1 = (TextView)view.findViewById(R.id.JuegosEmpatados1);
       JuegosEmpatados2 = (TextView)view.findViewById(R.id.JuegosEmpatados2);
       JuegosEmpatados3 = (TextView)view.findViewById(R.id.JuegosEmpatados3);
       JuegosEmpatados4 = (TextView)view.findViewById(R.id.JuegosEmpatados4);
       JuegosEmpatados5 = (TextView)view.findViewById(R.id.JuegosEmpatados5);
       JuegosEmpatados6 = (TextView)view.findViewById(R.id.JuegosEmpatados6);
       JuegosEmpatados7 = (TextView)view.findViewById(R.id.JuegosEmpatados7);
       JuegosEmpatados8 = (TextView)view.findViewById(R.id.JuegosEmpatados8);
       JuegosEmpatados9 = (TextView)view.findViewById(R.id.JuegosEmpatados9);
       JuegosEmpatados10 = (TextView)view.findViewById(R.id.JuegosEmpatados10);
       
       JuegosEmpatados11 = (TextView)view.findViewById(R.id.JuegosEmpatados11);
       JuegosEmpatados12 = (TextView)view.findViewById(R.id.JuegosEmpatados12);
       JuegosEmpatados13 = (TextView)view.findViewById(R.id.JuegosEmpatados13);
       JuegosEmpatados14 = (TextView)view.findViewById(R.id.JuegosEmpatados14);
       JuegosEmpatados15 = (TextView)view.findViewById(R.id.JuegosEmpatados15);
       JuegosEmpatados16 = (TextView)view.findViewById(R.id.JuegosEmpatados16);
       JuegosEmpatados17 = (TextView)view.findViewById(R.id.JuegosEmpatados17);
       JuegosEmpatados18 = (TextView)view.findViewById(R.id.JuegosEmpatados18);
       JuegosEmpatados19 = (TextView)view.findViewById(R.id.JuegosEmpatados19);
       JuegosEmpatados20 = (TextView)view.findViewById(R.id.JuegosEmpatados20);
       
       JuegosPerdidos1 = (TextView)view.findViewById(R.id.JuegosPerdidos1);
        JuegosPerdidos2 = (TextView)view.findViewById(R.id.JuegosPerdidos2);
         JuegosPerdidos3 = (TextView)view.findViewById(R.id.JuegosPerdidos3);
          JuegosPerdidos4 = (TextView)view.findViewById(R.id.JuegosPerdidos4);
           JuegosPerdidos5 = (TextView)view.findViewById(R.id.JuegosPerdidos5);
            JuegosPerdidos6 = (TextView)view.findViewById(R.id.JuegosPerdidos6);
             JuegosPerdidos7 = (TextView)view.findViewById(R.id.JuegosPerdidos7);
              JuegosPerdidos8 = (TextView)view.findViewById(R.id.JuegosPerdidos8);
               JuegosPerdidos9 = (TextView)view.findViewById(R.id.JuegosPerdidos9);
                JuegosPerdidos10 = (TextView)view.findViewById(R.id.JuegosPerdidos10);
                 
        JuegosPerdidos11 = (TextView)view.findViewById(R.id.JuegosPerdidos11);
        JuegosPerdidos12 = (TextView)view.findViewById(R.id.JuegosPerdidos12);
         JuegosPerdidos13 = (TextView)view.findViewById(R.id.JuegosPerdidos13);
          JuegosPerdidos14 = (TextView)view.findViewById(R.id.JuegosPerdidos14);
           JuegosPerdidos15 = (TextView)view.findViewById(R.id.JuegosPerdidos15);
            JuegosPerdidos16 = (TextView)view.findViewById(R.id.JuegosPerdidos16);
             JuegosPerdidos17 = (TextView)view.findViewById(R.id.JuegosPerdidos17);
              JuegosPerdidos18 = (TextView)view.findViewById(R.id.JuegosPerdidos18);
               JuegosPerdidos19 = (TextView)view.findViewById(R.id.JuegosPerdidos19);
                JuegosPerdidos20 = (TextView)view.findViewById(R.id.JuegosPerdidos20);
       
       GolesFavor1 = (TextView)view.findViewById(R.id.GolesFavor1);
       GolesFavor2 = (TextView)view.findViewById(R.id.GolesFavor2);
       GolesFavor3 = (TextView)view.findViewById(R.id.GolesFavor3);
       GolesFavor4 = (TextView)view.findViewById(R.id.GolesFavor4);
       GolesFavor5 = (TextView)view.findViewById(R.id.GolesFavor5);
       GolesFavor6 = (TextView)view.findViewById(R.id.GolesFavor6);
       GolesFavor7 = (TextView)view.findViewById(R.id.GolesFavor7);
       GolesFavor8 = (TextView)view.findViewById(R.id.GolesFavor8);
       GolesFavor9 = (TextView)view.findViewById(R.id.GolesFavor9);
       GolesFavor10 = (TextView)view.findViewById(R.id.GolesFavor10);
       
       GolesFavor11 = (TextView)view.findViewById(R.id.GolesFavor11);
       GolesFavor12 = (TextView)view.findViewById(R.id.GolesFavor12);
       GolesFavor13 = (TextView)view.findViewById(R.id.GolesFavor13);
       GolesFavor14 = (TextView)view.findViewById(R.id.GolesFavor14);
       GolesFavor15 = (TextView)view.findViewById(R.id.GolesFavor15);
       GolesFavor16 = (TextView)view.findViewById(R.id.GolesFavor16);
       GolesFavor17 = (TextView)view.findViewById(R.id.GolesFavor17);
       GolesFavor18 = (TextView)view.findViewById(R.id.GolesFavor18);
       GolesFavor19 = (TextView)view.findViewById(R.id.GolesFavor19);
       GolesFavor20 = (TextView)view.findViewById(R.id.GolesFavor20);
       
       GolesContra1 = (TextView)view.findViewById(R.id.GolesContra1);
       GolesContra2 = (TextView)view.findViewById(R.id.GolesContra2);
       GolesContra3 = (TextView)view.findViewById(R.id.GolesContra3);
       GolesContra4 = (TextView)view.findViewById(R.id.GolesContra4);
       GolesContra5 = (TextView)view.findViewById(R.id.GolesContra5);
       GolesContra6 = (TextView)view.findViewById(R.id.GolesContra6);
       GolesContra7 = (TextView)view.findViewById(R.id.GolesContra7);
       GolesContra8 = (TextView)view.findViewById(R.id.GolesContra8);
       GolesContra9 = (TextView)view.findViewById(R.id.GolesContra9);
       GolesContra10 = (TextView)view.findViewById(R.id.GolesContra10);
       
       GolesContra11 = (TextView)view.findViewById(R.id.GolesContra11);
       GolesContra12 = (TextView)view.findViewById(R.id.GolesContra12);
       GolesContra13 = (TextView)view.findViewById(R.id.GolesContra13);
       GolesContra14 = (TextView)view.findViewById(R.id.GolesContra14);
       GolesContra15 = (TextView)view.findViewById(R.id.GolesContra15);
       GolesContra16 = (TextView)view.findViewById(R.id.GolesContra16);
       GolesContra17 = (TextView)view.findViewById(R.id.GolesContra17);
       GolesContra18 = (TextView)view.findViewById(R.id.GolesContra18);
       GolesContra19 = (TextView)view.findViewById(R.id.GolesContra19);
       GolesContra20 = (TextView)view.findViewById(R.id.GolesContra20);
       
        new HttpAsyncTask().execute("http://api.football-data.org/v1/soccerseasons/399/leagueTable");
    
       
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
    
     private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
            return GET(urls[0]);
        }
        
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getActivity(), "Received!", Toast.LENGTH_LONG).show();
            JSONObject json;
            
            try {
                json = new JSONObject(result); 
                JSONArray articles = json.getJSONArray("standing"); // get articles array
                
                for (int i = 0; i < 20; i++) {
                     posiciones[i] = articles.getJSONObject(i).getString("position").toString(); 
                     equipos[i] = articles.getJSONObject(i).getString("teamName").toString(); 
                       puntajes[i] = articles.getJSONObject(i).getString("points").toString();
                       juegosJugados[i] = articles.getJSONObject(i).getString("playedGames").toString();
                       juegosganados[i] = articles.getJSONObject(i).getString("wins").toString();
                       juegosempatados[i] = articles.getJSONObject(i).getString("draws").toString();
                       juegosperdidos[i] = articles.getJSONObject(i).getString("losses").toString();
                       golesafavor[i] = articles.getJSONObject(i).getString("goals").toString();
                       golesencontra[i] = articles.getJSONObject(i).getString("goalsAgainst").toString();
                        diferenciaGoles[i] = articles.getJSONObject(i).getString("goalDifference").toString();
                }
                
                Posicion1.setText(posiciones[0]);
                 Posicion2.setText(posiciones[1]);
                  Posicion3.setText(posiciones[2]);
                   Posicion4.setText(posiciones[3]);
                    Posicion5.setText(posiciones[4]);
                     Posicion6.setText(posiciones[5]);
                      Posicion7.setText(posiciones[6]);
                       Posicion8.setText(posiciones[7]);
                        Posicion9.setText(posiciones[8]);
                         Posicion10.setText(posiciones[9]);
                          Posicion11.setText(posiciones[10]);
                           Posicion12.setText(posiciones[11]);
                            Posicion13.setText(posiciones[12]);
                             Posicion14.setText(posiciones[13]);
                              Posicion15.setText(posiciones[14]);
                               Posicion16.setText(posiciones[15]);
                                Posicion17.setText(posiciones[16]);
                                 Posicion18.setText(posiciones[17]);
                                  Posicion19.setText(posiciones[18]);
                                   Posicion20.setText(posiciones[19]);
                            
                
                Equipo1.setText(equipos[0]);
                 Equipo2.setText(equipos[1]);
                  Equipo3.setText(equipos[2]);
                   Equipo4.setText(equipos[3]);
                    Equipo5.setText(equipos[4]);
                     Equipo6.setText(equipos[5]);
                      Equipo7.setText(equipos[6]);
                       Equipo8.setText(equipos[7]);
                        Equipo9.setText(equipos[8]);
                         Equipo10.setText(equipos[9]);
                          Equipo11.setText(equipos[10]);
                           Equipo12.setText(equipos[11]);
                            Equipo13.setText(equipos[12]);
                             Equipo14.setText(equipos[13]);
                              Equipo15.setText(equipos[14]);
                               Equipo16.setText(equipos[15]);
                                Equipo17.setText(equipos[16]);
                                 Equipo18.setText(equipos[17]);
                                  Equipo19.setText(equipos[18]);
                                   Equipo20.setText(equipos[19]);
                                 
                
                Puntos1.setText(puntajes[0]);
                 Puntos2.setText(puntajes[1]);
                  Puntos3.setText(puntajes[2]);
                   Puntos4.setText(puntajes[3]);
                    Puntos5.setText(puntajes[4]);
                     Puntos6.setText(puntajes[5]);
                      Puntos7.setText(puntajes[6]);
                       Puntos8.setText(puntajes[7]);
                        Puntos9.setText(puntajes[8]);
                        Puntos10.setText(puntajes[9]);
                          Puntos11.setText(puntajes[10]);
                           Puntos12.setText(puntajes[11]);
                            Puntos13.setText(puntajes[12]);
                             Puntos14.setText(puntajes[13]);
                              Puntos15.setText(puntajes[14]);
                               Puntos16.setText(puntajes[15]);
                                Puntos17.setText(puntajes[16]);
                                 Puntos18.setText(puntajes[17]);
                                  Puntos19.setText(puntajes[18]);
                                   Puntos20.setText(puntajes[19]);
                       
                                   DiferenciaGoles1.setText(diferenciaGoles[0]);
                                   DiferenciaGoles2.setText(diferenciaGoles[1]);
                                   DiferenciaGoles3.setText(diferenciaGoles[2]);
                                   DiferenciaGoles4.setText(diferenciaGoles[3]);
                                   DiferenciaGoles5.setText(diferenciaGoles[4]);
                                   DiferenciaGoles6.setText(diferenciaGoles[5]);
                                   DiferenciaGoles7.setText(diferenciaGoles[6]);
                                   DiferenciaGoles8.setText(diferenciaGoles[7]);
                                   DiferenciaGoles9.setText(diferenciaGoles[8]);
                                   DiferenciaGoles10.setText(diferenciaGoles[9]);
                                   DiferenciaGoles11.setText(diferenciaGoles[10]);
                                   DiferenciaGoles12.setText(diferenciaGoles[11]);
                                   DiferenciaGoles13.setText(diferenciaGoles[12]);
                                   DiferenciaGoles14.setText(diferenciaGoles[13]);
                                   DiferenciaGoles15.setText(diferenciaGoles[14]);
                                   DiferenciaGoles16.setText(diferenciaGoles[15]);
                                   DiferenciaGoles17.setText(diferenciaGoles[16]);
                                   DiferenciaGoles18.setText(diferenciaGoles[17]);
                                   DiferenciaGoles19.setText(diferenciaGoles[18]);
                                   DiferenciaGoles20.setText(diferenciaGoles[19]);
                                   
                                   
                         
                
                JuegosJugados1.setText(juegosJugados[0]);
                JuegosJugados2.setText(juegosJugados[1]);
                JuegosJugados3.setText(juegosJugados[2]);
                JuegosJugados4.setText(juegosJugados[3]);
                JuegosJugados5.setText(juegosJugados[4]);
                JuegosJugados6.setText(juegosJugados[5]);
                JuegosJugados7.setText(juegosJugados[6]);
                JuegosJugados8.setText(juegosJugados[7]);
                JuegosJugados9.setText(juegosJugados[8]);
                JuegosJugados10.setText(juegosJugados[9]);
                JuegosJugados11.setText(juegosJugados[10]);
                JuegosJugados12.setText(juegosJugados[11]);
                JuegosJugados13.setText(juegosJugados[12]);
                JuegosJugados14.setText(juegosJugados[13]);
                JuegosJugados15.setText(juegosJugados[14]);
                JuegosJugados16.setText(juegosJugados[15]);
                JuegosJugados17.setText(juegosJugados[16]);
                JuegosJugados18.setText(juegosJugados[17]);
                JuegosJugados19.setText(juegosJugados[18]);
                JuegosJugados20.setText(juegosJugados[19]);
                
                
                
                JuegosGanados1.setText(juegosganados[0]);
                JuegosGanados2.setText(juegosganados[1]);
                JuegosGanados3.setText(juegosganados[2]);
                JuegosGanados4.setText(juegosganados[3]);
                JuegosGanados5.setText(juegosganados[4]);
                JuegosGanados6.setText(juegosganados[5]);
                JuegosGanados7.setText(juegosganados[6]);
                JuegosGanados8.setText(juegosganados[7]);
                JuegosGanados9.setText(juegosganados[8]);
                JuegosGanados10.setText(juegosganados[9]);
                JuegosGanados11.setText(juegosganados[10]);
                JuegosGanados12.setText(juegosganados[11]);
                JuegosGanados13.setText(juegosganados[12]);
                JuegosGanados14.setText(juegosganados[13]);
                JuegosGanados15.setText(juegosganados[14]);
                JuegosGanados16.setText(juegosganados[15]);
                JuegosGanados17.setText(juegosganados[16]);
                JuegosGanados18.setText(juegosganados[17]);
                JuegosGanados19.setText(juegosganados[18]);
                JuegosGanados20.setText(juegosganados[19]);
                
                
                JuegosEmpatados1.setText(juegosempatados[0]);
                JuegosEmpatados2.setText(juegosempatados[1]);
                JuegosEmpatados3.setText(juegosempatados[2]);
                JuegosEmpatados4.setText(juegosempatados[3]);
                JuegosEmpatados5.setText(juegosempatados[4]);
                JuegosEmpatados6.setText(juegosempatados[5]);
                JuegosEmpatados7.setText(juegosempatados[6]);
                JuegosEmpatados8.setText(juegosempatados[7]);
                JuegosEmpatados9.setText(juegosempatados[8]);
                JuegosEmpatados10.setText(juegosempatados[9]);
                JuegosEmpatados11.setText(juegosempatados[10]);
                JuegosEmpatados12.setText(juegosempatados[11]);
                JuegosEmpatados13.setText(juegosempatados[12]);
                JuegosEmpatados14.setText(juegosempatados[13]);
                JuegosEmpatados15.setText(juegosempatados[14]);
                JuegosEmpatados16.setText(juegosempatados[15]);
                JuegosEmpatados17.setText(juegosempatados[16]);
                JuegosEmpatados18.setText(juegosempatados[17]);
                JuegosEmpatados19.setText(juegosempatados[18]);
                JuegosEmpatados20.setText(juegosempatados[19]);
                
                
                JuegosPerdidos1.setText(juegosperdidos[0]);
                JuegosPerdidos2.setText(juegosperdidos[1]);
                JuegosPerdidos3.setText(juegosperdidos[2]);
                JuegosPerdidos4.setText(juegosperdidos[3]);
                JuegosPerdidos5.setText(juegosperdidos[4]);
                JuegosPerdidos6.setText(juegosperdidos[5]);
                JuegosPerdidos7.setText(juegosperdidos[6]);
                JuegosPerdidos8.setText(juegosperdidos[7]);
                JuegosPerdidos9.setText(juegosperdidos[8]);
                JuegosPerdidos10.setText(juegosperdidos[9]);
                JuegosPerdidos11.setText(juegosperdidos[10]);
                JuegosPerdidos12.setText(juegosperdidos[11]);
                JuegosPerdidos13.setText(juegosperdidos[12]);
                JuegosPerdidos14.setText(juegosperdidos[13]);
                JuegosPerdidos15.setText(juegosperdidos[14]);
                JuegosPerdidos16.setText(juegosperdidos[15]);
                JuegosPerdidos17.setText(juegosperdidos[16]);
                JuegosPerdidos18.setText(juegosperdidos[17]);
                JuegosPerdidos19.setText(juegosperdidos[18]);
                JuegosPerdidos20.setText(juegosperdidos[19]);
                
                
                GolesFavor1.setText(golesafavor[0]);
                GolesFavor2.setText(golesafavor[1]);
                GolesFavor3.setText(golesafavor[2]);
                GolesFavor4.setText(golesafavor[3]);
                GolesFavor5.setText(golesafavor[4]);
                GolesFavor6.setText(golesafavor[5]);
                GolesFavor7.setText(golesafavor[6]);
                GolesFavor8.setText(golesafavor[7]);
                GolesFavor9.setText(golesafavor[8]);
                GolesFavor10.setText(golesafavor[9]);
                GolesFavor11.setText(golesafavor[10]);
                GolesFavor12.setText(golesafavor[11]);
                GolesFavor13.setText(golesafavor[12]);
                GolesFavor14.setText(golesafavor[13]);
                GolesFavor15.setText(golesafavor[14]);
                GolesFavor16.setText(golesafavor[15]);
                GolesFavor17.setText(golesafavor[16]);
                GolesFavor18.setText(golesafavor[17]);
                GolesFavor19.setText(golesafavor[18]);
                GolesFavor20.setText(golesafavor[19]);
                
                
               
                GolesContra1.setText(golesencontra[0]);
                GolesContra2.setText(golesencontra[1]);
                GolesContra3.setText(golesencontra[2]);
                GolesContra4.setText(golesencontra[3]);
                GolesContra5.setText(golesencontra[4]);
                GolesContra6.setText(golesencontra[5]);
                GolesContra7.setText(golesencontra[6]);
                GolesContra8.setText(golesencontra[7]);
                GolesContra9.setText(golesencontra[8]);
                GolesContra10.setText(golesencontra[9]);
                GolesContra11.setText(golesencontra[10]);
                GolesContra12.setText(golesencontra[11]);
                GolesContra13.setText(golesencontra[12]);
                GolesContra14.setText(golesencontra[13]);
                GolesContra15.setText(golesencontra[14]);
                GolesContra16.setText(golesencontra[15]);
                GolesContra17.setText(golesencontra[16]);
                GolesContra18.setText(golesencontra[17]);
                GolesContra19.setText(golesencontra[18]);
                GolesContra20.setText(golesencontra[19]);
                
                
                } catch (JSONException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
        
    
}