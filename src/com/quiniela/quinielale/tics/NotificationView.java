package com.quiniela.quinielale.tics;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.quiniela.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationView extends Activity {

        TextView idnotificaionita;
        
        String locales[] = new String[6];
        String Visitantes[] = new String[6];
        String Competitions[] = new String[6];
        
        
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
                idnotificaionita = (TextView)this.findViewById(R.id.idnotificaionita);
                
                
                
                java.util.Date fecha = new Date();
                fecha.getDate();
                String Cadena = Integer.toString(fecha.getDate());
                new HttpAsyncTask().execute("http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=matchsday&key=d34b2e471eb7ad025d57149f84f4242f&limit=6&date=2016-6-" + Cadena);

		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// Cancelamos la Notificacion que hemos comenzado
		nm.cancel(getIntent().getExtras().getInt("notificationID"));
                
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
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            JSONObject json;
            
           
            try {
                json = new JSONObject(result);
                JSONArray articles = json.getJSONArray("matches");
                
                for (int i = 0; i < 6; i++) {
                    locales[i]= articles.getJSONObject(i).getString("local").toString();
                    Visitantes[i]= articles.getJSONObject(i).getString("visitor").toString();
                    Competitions[i]=articles.getJSONObject(i).getString("competition_name").toString();
                    
                   
                }
              
                String partidos = locales[0] + " - " + Visitantes[0] + " : " + Competitions[0] + "\n"+
                locales[1] + " - " + Visitantes[1] + " : " + Competitions[1] + "\n"+
                locales[2] + " - " + Visitantes[2] + " : " + Competitions[2] + "\n"+
                locales[3] + " - " + Visitantes[3] + " : " + Competitions[3] + "\n"+
                locales[4] + " - " + Visitantes[4] + " : " + Competitions[4] + "\n"+
                locales[5] + " - " + Visitantes[5] + " : " + Competitions[5] + "\n";
               
               idnotificaionita.setText(partidos);
                
                
              
            
                
                } catch (JSONException ex) {
                Logger.getLogger(NotificationActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
       
    }

}
