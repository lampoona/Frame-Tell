package edu.dartmouth.cs.frameandtell;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ParseObject.registerSubclass(Panel.class);

		//Sayeh's IDs
		//Parse.initialize(this, "gLzHXDmsQotFc8cELJ2QzoGUc4jo62tTbCntJBU5", "hV0GXI8A9OVnuglYNXOhPn5OzGDngEDagPpDQeYo");
		//Runi's IDs
		Parse.initialize(this, "qdb4KyApeHvYqfcgN2k0Pax6JgOHswxK44MaM9QK", "gxE52nVOiTb2gZmIOp6rnqDBkYblk9JKSWGyf5D4");
		
		
		ParseUser.enableAutomaticUser();
		ParseUser.getCurrentUser().increment("RunCount");
		ParseUser.getCurrentUser().saveInBackground();
		
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_actions, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_home:
	
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

	public void onMakeClicked(View view) {
		Intent intent = new Intent(getApplicationContext(),
				NewStoryActivity.class);
		startActivity(intent);
	}
	
	public void onReadClicked(View view) {
		Intent intent = new Intent(getApplicationContext(),
				ReaderActivity.class);
		startActivity(intent);
	}

}
