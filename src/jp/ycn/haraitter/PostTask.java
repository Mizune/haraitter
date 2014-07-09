package jp.ycn.haraitter;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class PostTask extends AsyncTask<String, String, String> {
	@Override
	protected String doInBackground(String... urls) { // ２つ目に生成したpostパラメータをふよする
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(urls[0]);
		try {
			httpPost.setEntity(new StringEntity(urls[1]));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				httpResponse.getEntity().writeTo(outputStream);
				return outputStream.toString();
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	protected void onPostExecute(String result) {
		System.out.println(result.toString());
		// エラー検知用
	}

}
