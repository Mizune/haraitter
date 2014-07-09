package jp.ycn.haraitter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import android.os.AsyncTask;

public class DataTask extends AsyncTask<String, String, String> {
	private String mRes;
	Map<Object, Object> data = null;

	protected String doInBackground(String... params) {
		// インスタンス作成
		try {
			// (2)URLクラスを使用して通信を行う
			URL url = new URL(params[0]);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			// 動作を入力に設定
			connection.setRequestProperty("ShakringToken", "1");
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			InputStream stream = connection.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(
					stream));
			// (3)データの取得
			String data = "";
			String tmp = "";
			while ((tmp = input.readLine()) != null) {
				data += tmp;
			}
			// (4)終了処理
			stream.close();
			input.close();
			System.out.println(data);
			return data;
		} catch (Exception e) {
			// (5)エラー処理
			return e.toString();
		}

	}

	// @Override
	// public void onPostExecute(String result) {
	// ObjectMapper mapper = new ObjectMapper();
	// try {
	// data = mapper.readValue(result, Map.class);
	// } catch (JsonParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (JsonMappingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	// @Override
	// protected String doInBackground(String... params) {
	// // インスタンス作成
	// HttpGet request = new HttpGet(params[0]);
	// DefaultHttpClient client = new DefaultHttpClient();
	// request.setHeader("ShakringToken", "1");
	// request.setHeader("content-type", "application/json");
	//
	// // HTTPリクエスト発行
	// HttpResponse res = null;
	// try {
	// res = client.execute(request);
	// } catch (ClientProtocolException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// // 結果コード取得
	// int status = res.getStatusLine().getStatusCode();
	// if (status != HttpStatus.SC_OK) {
	// // エラー時の処理
	// } else {
	// // 取り合えず取得内容をログに吐いてみましょうか
	// try {
	// Log.d("http response",
	// EntityUtils.toString(res.getEntity(), "UTF-8"));
	// } catch (ParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// System.out.println(res.toString());
	// this.mRes = res.toString();
	// return res.toString();
	// }

	// public String getString() {
	// return mRes;
	// }

	public Map<Object, Object> getData() {
		return this.data;
	}
}
