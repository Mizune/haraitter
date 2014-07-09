package jp.ycn.haraitter;

import java.io.Serializable;

import android.graphics.Bitmap;

public class Data implements Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -8730067026050196758L;

	public String name;

	public String comment;

	public String imgUrl;

	public Bitmap userImageBitmap;

	public String date;

	public boolean isHelp;// true > helpcall null多数 false advice null無し

}