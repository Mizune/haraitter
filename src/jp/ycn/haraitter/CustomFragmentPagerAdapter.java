package jp.ycn.haraitter;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * FragmentPagerAdapter.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<PageItem> mList;

	public CustomFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		mList = new ArrayList<PageItem>();
	}

	@Override
	public Fragment getItem(int position) {
		PageItem item = mList.get(position);
		if (PageItem.TIMELINE == item.fragmentKind) {
			// GridView �� Fragment
			// GridViewFragment gridViewFragment = new GridViewFragment();
			AdviceTimeLineFragment timeLineFragment = new AdviceTimeLineFragment();
			Bundle bundle = new Bundle();
			bundle.putSerializable("list", item.dataList);
			timeLineFragment.setArguments(bundle);
			return timeLineFragment;
		} else {
			return new SettingFragment();

		}

	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mList.get(position).title;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	public void addItem(PageItem item) {
		mList.add(item);
	}

}
