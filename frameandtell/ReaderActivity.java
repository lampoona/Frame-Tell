package edu.dartmouth.cs.frameandtell;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class ReaderActivity extends Activity {
	
	//temp total # pages, to be set by Story
    private static final int NUM_PAGES = 12;
    
    //pager widget, handles swipes
    private ViewPager mPager;
    
    //provides pages to the viewPager
    private PagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reader);
		
		 // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ReaderPagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active.
                invalidateOptionsMenu();
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reader, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_home:
	    		Intent intent = new Intent(getApplicationContext(),
	    				HomeActivity.class);
	    		startActivity(intent);
	            return true;
	        case R.id.activity_timeline:
	    		Intent intent1 = new Intent(getApplicationContext(),
	    				TimelineActivity.class);
	    		startActivity(intent1);
	           return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	
	//adapter that represents sequence of ReaderPageFragment objects
    private class ReaderPagerAdapter extends FragmentStatePagerAdapter {
        public ReaderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ReaderPageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
