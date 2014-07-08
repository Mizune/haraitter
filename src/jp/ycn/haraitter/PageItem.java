package jp.ycn.haraitter;

import java.util.ArrayList;

public class PageItem {

	/** Settings の Fragment の Id. */
	public static final int SETTINGS = 0;
	/** TIMELINE の Fragment の Id. */
	public static final int TIMELINE = 1;

	// XXX SETTINGS HELP ADVICE にする可能性あり

	/** ページ名. */
	public String title;
	/** Fragment の種類. */
	public int fragmentKind;

	public ArrayList<Data> dataList;

}