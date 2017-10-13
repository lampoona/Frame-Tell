package edu.dartmouth.cs.frameandtell;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.parse.ParseImageView;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class EditPanelActivity extends Activity {
	private Panel panel;
	private Story story;
//	private ImageButton photoButton;
//	private ParseImageView panelPreview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		panel = new Panel();
		story = new Story();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);

		// Begin with main data entry view,
		// NewMealFragment
		setContentView(R.layout.activity_edit_panel);
		FragmentManager manager = getFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

		if (fragment == null) {
			fragment = new NewPanelFragment();
			manager.beginTransaction().add(R.id.fragmentContainer, fragment)
			.commit();
		}
	}

	public Panel getCurrentPanel() {
		return panel;
	}
	
	public Story getCurrentStory() {
		return story;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_panel, menu);
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
//
//	public void onSaveClicked(View view) {
//		Intent intent = new Intent(getApplicationContext(),
//				TimelineActivity.class);
//		startActivity(intent);
//	}
//
//	public void onCancelClicked(View view) {
//		Intent intent = new Intent(getApplicationContext(),
//				TimelineActivity.class);
//		startActivity(intent);
//	}
//	
//	public void onAddImageClicked(View view) {
//		FragmentManager manager = getFragmentManager();
//		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
//
//		if (fragment == null) {
//			fragment = new NewPanelFragment();
//			manager.beginTransaction().add(R.id.fragmentContainer, fragment)
//			.commit();
//		}
//
//	}
//
//	public void onAddTextClicked(View view) {
//
//	}
//
//	public void onUndoClicked(View view) {
//
//	}
//	
	
	
}

//
//	public static final int REQUEST_CODE_TAKE_FROM_CAMERA = 0;
//	public static final int REQUEST_CODE_SELECT_FROM_GALLERY = 1;
//	public static final int REQUEST_CODE_CROP_PHOTO = 2;
//	private static final String IMAGE_UNSPECIFIED = "image/*";
//	private static final String URI_INSTANCE_STATE_KEY = "saved_uri";
//	private Uri mImageCaptureUri;
//	private ImageView mImageView;
//	private boolean isTakenFromCamera;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_edit_panel);
//
//
//
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.edit_panel, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle presses on the action bar items
//		switch (item.getItemId()) {
//		case R.id.action_home:
//			Intent intent = new Intent(getApplicationContext(),
//					HomeActivity.class);
//			startActivity(intent);
//			return true;
//		case R.id.activity_timeline:
//			Intent intent1 = new Intent(getApplicationContext(),
//					TimelineActivity.class);
//			startActivity(intent1);
//			return true;
//		default:
//			return super.onOptionsItemSelected(item);
//		}
//	}
//
//	public void onSaveClicked(View view) {
//		Intent intent = new Intent(getApplicationContext(),
//				TimelineActivity.class);
//		startActivity(intent);
//	}
//
//	public void onCancelClicked(View view) {
//		Intent intent = new Intent(getApplicationContext(),
//				TimelineActivity.class);
//		startActivity(intent);
//	}
//
//
//	public void onChangeImageClicked(View v) {
//
//		displayDialog(FrameandtellDialogFragments.DIALOG_ID_IMAGE_PICKER);
//	}
//	//photo picker related functions
//	public void displayDialog(int id) {
//		DialogFragment fragment = FrameandtellDialogFragments
//				.newInstance(id);
//		fragment.show(getFragmentManager(),getString(R.string.dialog_fragment_tag_photo_picker));
//	}
//
//
//
//
//	public void onAddImageClicked(View view) {

//
//	}
//
//	public void onAddTextClicked(View view) {
//
//	}
//
//	public void onUndoClicked(View view) {
//
//	}
//
//	// Handle date after activity returns.
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		if (resultCode != RESULT_OK)
//			return;
//
//		switch (requestCode) {
//		case REQUEST_CODE_TAKE_FROM_CAMERA:
//			// Send image taken from camera for cropping
//			cropImage();
//			break;
//
//		case REQUEST_CODE_SELECT_FROM_GALLERY:
//			// Send selected image from gallery for cropping
//			mImageCaptureUri = data.getData();
//			cropImage();
//			break;
//
//		case REQUEST_CODE_CROP_PHOTO:
//			// Update image view after image crop
//			Bundle extras = data.getExtras();
//			// Set the profile image in UI
//			if (extras != null) {
//				mImageView
//				.setImageBitmap((Bitmap) extras.getParcelable("data"));
//			}
//
//			// Delete temporary image taken by camera after crop.
//			if (isTakenFromCamera){
//				File f = new File(mImageCaptureUri.getPath());
//				if (f.exists()) f.delete();
//			}
//
//			break;
//		}
//	}
//
//	public void onImagePickerItemSelected(int item) {
//		Intent intent;
//
//		switch (item) {
//
//		case FrameandtellDialogFragments.ID_PHOTO_PICKER_FROM_CAMERA:
//			// Take photo from camera���
//			// Construct an intent with action
//			// MediaStore.ACTION_IMAGE_CAPTURE
//			intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//			// Construct temporary image path and name to save the taken
//			// photo
//			mImageCaptureUri = Uri.fromFile(new File(Environment
//					.getExternalStorageDirectory(), "tmp_"
//							+ String.valueOf(System.currentTimeMillis()) + ".jpg"));
//			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
//					mImageCaptureUri);
//			intent.putExtra("return-data", true);
//			try {
//				// Start a camera capturing activity
//				// REQUEST_CODE_TAKE_FROM_CAMERA is an integer tag you
//				// defined to identify the activity in onActivityResult()
//				// when it returns
//				startActivityForResult(intent, REQUEST_CODE_TAKE_FROM_CAMERA);
//			} catch (ActivityNotFoundException e) {
//				e.printStackTrace();
//			}
//			isTakenFromCamera = true;
//			break;
//
//		case FrameandtellDialogFragments.ID_PHOTO_PICKER_FROM_GALLERY:
//			// Select from gallery
//			intent = new Intent();
//			intent.setType(IMAGE_UNSPECIFIED);
//			intent.setAction(Intent.ACTION_GET_CONTENT);
//			// Start a gallery choosing activity
//			// REQUEST_CODE_SELECT_FROM_GALLERY is an integer tag you
//			// defined to identify the activity in onActivityResult()
//			// when it returns
//			startActivityForResult(intent, REQUEST_CODE_SELECT_FROM_GALLERY);
//			break;
//
//		default:
//			return;
//		}
//
//	}
//
//
//	// Crop and resize the image for profile
//	private void cropImage() {
//		// Use existing crop activity.
//		Intent intent = new Intent("com.android.camera.action.CROP");
//		intent.setDataAndType(mImageCaptureUri, IMAGE_UNSPECIFIED);
//
//		// Specify image size
//		intent.putExtra("outputX", 100);
//		intent.putExtra("outputY", 100);
//
//		// Specify aspect ratio, 1:1
//		intent.putExtra("aspectX", 1);
//		intent.putExtra("aspectY", 1);
//		intent.putExtra("scale", true);
//		intent.putExtra("return-data", true);
//		// REQUEST_CODE_CROP_PHOTO is an integer tag you defined to
//		// identify the activity in onActivityResult() when it returns
//		startActivityForResult(intent, REQUEST_CODE_CROP_PHOTO);
//	}
//
//	//private helper functions
////	private void savePanel() {
////		String key, str_val;
////		int int_val;
////
////		key = getString(R.string.preference_name);
////		SharedPreferences prefs = getSharedPreferences(key, MODE_PRIVATE);
////		SharedPreferences.Editor editor = prefs.edit();
////
////		//save title
////		// Write screen contents into corresponding editor fields.
////		key = getString(R.string.preference_key_panel_name);
////		str_val = ((EditText) findViewById(R.id.editTitle)).getText().toString();
////		editor.putString(key, str_val);
//////********make sure to add editTitle and Editcaption to XML*******
////		key = getString(R.string.preference_key_panel_caption);
////		str_val = ((EditText) findViewById(R.id.editCaption)).getText()
////				.toString();
////		editor.putString(key, str_val);
////
////		// Commit all the changes into preference file
////		editor.apply();
////
////		// Save profile image into internal storage.
////		mImageView.buildDrawingCache();
////		Bitmap bmap = mImageView.getDrawingCache();
////		try {
////			FileOutputStream fos = openFileOutput(
////					getString(R.string.panel_photo_file_name), MODE_PRIVATE);
////			bmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
////			fos.flush();
////			fos.close();
////		} catch (IOException ioe) {
////			ioe.printStackTrace();
////		}
////
////
////
////	}
////
////
////
//}
