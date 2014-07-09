package jp.ycn.haraitter;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

public class ImageTask extends AsyncTask<String, String, String> {
	private Context mContext;
	private Bitmap img;
	private View convertView;

	public ImageTask(Context context, View convertView) {
		mContext = context;
		this.convertView = convertView;
	}

	@Override
	protected String doInBackground(String... params) {
		// 画像のURLを直うち
		System.out.println("Image Task url = " + params[0]);
		URL url;
		InputStream istream;
		try {
			url = new URL(params[0]);
			System.out.println("Image url = " + params[0]);
			istream = url.openStream();
			this.img = BitmapFactory.decodeStream(istream);
			// ビットマップをImageViewに設定
			// インプットストリームを閉じる
			istream.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// インプットストリームで画像を読み込む
		// 読み込んだファイルをビットマップに変換
		return null;
	}

	public Bitmap getImage() {
		return this.img;
	}

}