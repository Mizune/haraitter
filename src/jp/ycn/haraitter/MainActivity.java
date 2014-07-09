package jp.ycn.haraitter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.fragmenttest2.R;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements OnClickListener {
	private Button mHelpCallButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (!TwitterUtils.hasAccessToken(this)) {
			Intent intent = new Intent(this, TwitterOAuthActivity.class);
			startActivity(intent);
		}
		getActionBar().hide();
		mHelpCallButton = (Button) findViewById(R.id.helpCall);
		mHelpCallButton.setOnClickListener(this);
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		PagerTabStrip strip = (PagerTabStrip) findViewById(R.id.strip);// pager
																		// とstripの指定
		strip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14); // titleのサイズ
		strip.setTextColor(0xff3232cd);// textの色
		strip.setTextSpacing(50);// となりのFragmentのタイトルまでのスペース
		strip.setNonPrimaryAlpha(0.3f);// 隣のFragmentTextの薄さ
		strip.setDrawFullUnderline(true); // 透過案ダーラーンが引いたままになるかならないか
		// strip.setDrawFullUnderline(false);
		strip.setTabIndicatorColor(0xff3232cd);// underLineの色
		// strip.setTabIndicatorColor(0xff323232);

		// ViewPager �� Adapter
		CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(
				getSupportFragmentManager());

		// GridView �� Adapter
		ArrayList<Data> adviceList = new ArrayList<Data>();
		for (int i = 0; i < 30; i++) {
			Data item = new Data();

			item.name = "Data" + i;
			item.comment = "このアプリはHaraitterです。このアプリはHaraitterです。このアプリはHaraitterです。このアプリはHaraitterです。このアプリはHaraitterです。";
			item.imgUrl = "http://hogehoge.jpg";
			item.date = "2 minutes ago";
			item.isHelp = true;
			adviceList.add(item); // 適当に追加している
		}

		ArrayList<Data> helpList = new ArrayList<Data>();
		for (int i = 0; i < 30; i++) {
			Data item = new Data();

			item.name = "Data" + i;
			item.imgUrl = "http://hogehoge.jpg";
			item.date = "2 minutes ago";
			item.isHelp = false;
			helpList.add(item); // 適当に追加している
		}

		PageItem helpme = new PageItem();
		helpme.title = "Help me";
		helpme.fragmentKind = PageItem.TIMELINE;
		helpme.dataList = helpList;// 表示するlistの形
		adapter.addItem(helpme);

		PageItem advice = new PageItem();
		advice.title = "Advice to you";
		advice.fragmentKind = PageItem.TIMELINE;
		advice.dataList = adviceList;

		adapter.addItem(advice);

		PageItem setting = new PageItem();
		setting.title = "Settings";
		setting.fragmentKind = PageItem.SETTINGS;
		adapter.addItem(setting);

		pager.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

	}
}
