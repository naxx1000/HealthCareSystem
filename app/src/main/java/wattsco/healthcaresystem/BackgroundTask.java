package wattsco.healthcaresystem;

import android.content.Context;
import android.os.AsyncTask;
import android.system.Os;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Louise on 29/03/17.
 */

public class BackgroundTask extends AsyncTask<String,Void,String>{
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://p5testing.tk/register2.php"; //represents the login host - folder - document
        String login_url = "http://10.0.2.login.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String reg_name = params[1];
            String reg_cpr = params[2];
            String reg_email = params[3];
            String reg_pass = params[4];
            String reg_confirmpass = params[5];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("reg_name", "UTF-8") +"=" + URLEncoder.encode(reg_name, "UTF-8") + "&" +
                        URLEncoder.encode("reg_cpr", "UTF-8") + "=" + URLEncoder.encode(reg_cpr, "UTF-8") + "&" +
                        URLEncoder.encode("reg_email", "UTF-8") + "=" + URLEncoder.encode(reg_email, "UTF-8") + "&" +
                        URLEncoder.encode("reg_pass", "UTF-8") + "=" + URLEncoder.encode(reg_pass, "UTF-8") + "&" +
                        URLEncoder.encode("reg_confirmpass", "UTF-8") + "=" + URLEncoder.encode(reg_confirmpass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}
