package edu.dartmouth.cs.frameandtell;

import com.parse.ParseQueryAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class TimelineActivity extends Activity {
	private static Story story;

	private ParseQueryAdapter<Panel> mainAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		//ListView list = (ListView)findViewById(R.id.listView);
		ListView list = (ListView)findViewById(android.R.id.list); 
		//getListView().setClickable(false);
		mainAdapter = new ParseQueryAdapter<Panel>(this, Panel.class);
		mainAdapter.setTextKey("title");
		mainAdapter.setImageKey("photo");

		// Default view is all meals
		list.setAdapter(mainAdapter);
		//setListAdapter(mainAdapter);
		story = new Story();
		displayDialog(4);
	}


	public static Story getCurrentStory() {
		return story;
	}

	public void onStorySet(String s)
	{

		story.onTitleSet(s);
	}

	public void doPositiveClick() {
		//

	}

	public void doNegativeClick() {
		//
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timeline, menu);

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

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

	public void onNewPanelClicked(View view) {
		Intent intent = new Intent(getApplicationContext(),
				EditPanelActivity.class);
		startActivityForResult(intent, 0);
	}

	public void displayDialog(int id) {
		DialogFragment fragment = FrameandtellDialogFragments
				.newInstance(id);
		fragment.show(getFragmentManager(),getString(R.string.dialog_fragment_tag_photo_picker));
	}
	
	private void updatePanelList() {
		mainAdapter.loadObjects();
		ListView list = (ListView)findViewById(android.R.id.list); 
		list.setAdapter(mainAdapter);
	}

	
//	private void newPanel() {
//		Intent i = new Intent(this, EditPanelActivity.class);
//		startActivityForResult(i, 0);
//	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			// If a new post has been added, update
			// the list of posts
			updatePanelList();
		}
	}
	
}
