package edu.dartmouth.cs.frameandtell;
import java.util.Calendar;

import edu.dartmouth.cs.frameandtell.Story;

import android.text.InputType;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.text.Editable;


public class FrameandtellDialogFragments extends DialogFragment {
	private static final String DIALOG_ID_KEY = "dialog_id";
	public static final int DIALOG_ID_ERROR = -1;

	public static final int DIALOG_ID_IMAGE_PICKER = 1;
	public static final int DIALOG_DRAG_AND_DROP = 2;
	public static final int DIALOG_ENTER_TITLE = 3;
	public static final int DIALOG_ID_COMMENT = 4;

	// For photo picker selection:
	public static final int ID_PHOTO_PICKER_FROM_GALLERY = 1;
	public static final int ID_PHOTO_PICKER_FROM_CAMERA = 0;

	public static FrameandtellDialogFragments newInstance(int dialog_id) {
		FrameandtellDialogFragments frag = new FrameandtellDialogFragments();
		Bundle args = new Bundle();
		args.putInt(DIALOG_ID_KEY, dialog_id);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		final EditText textEntryView;

		int dialog_id = getArguments().getInt(DIALOG_ID_KEY);

		final Activity parent = getActivity();

		// Setup dialog appearance and onClick Listeners

		switch (dialog_id) {
		case DIALOG_ID_IMAGE_PICKER:
			AlertDialog.Builder builder = new AlertDialog.Builder(parent);
			builder.setTitle(R.string.Edit_panel_photo_picker_title);
			builder.setItems(R.array.Edit_panel_photo_picker_items, new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int item) 
				{
				//s	((EditPanelActivity)parent).onImagePickerItemSelected(item);

				}
			});					

			return builder.create();

		case DIALOG_ENTER_TITLE:
			AlertDialog.Builder title = new AlertDialog.Builder(parent);
			
			textEntryView = new EditText(parent);
			textEntryView.setInputType(InputType.TYPE_CLASS_TEXT);
			textEntryView.setHint(R.string.story_input_title_hint);
			textEntryView.setLines(4);
			
			title
			.setTitle(R.string.story_input_title_title)
			.setView(textEntryView)
			.setPositiveButton(R.string.story_save_title,
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
						int whichButton) {
					String edit = textEntryView.getText().toString();
					//Story story = new Story(edit);
					((TimelineActivity)parent).onStorySet(edit);

				}
			})
			.setNegativeButton(R.string.story_cancel_title,
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
						int whichButton) {
					textEntryView.setText("");
				}
			}).create();
			
			return title.create();
			
		case DIALOG_ID_COMMENT:
			AlertDialog.Builder comment = new AlertDialog.Builder(parent);
			comment.setTitle("Set Title Here:");
			//set an edittext view to get user input
			final EditText CommentInput = new EditText (parent);
			comment.setView(CommentInput);

			comment.setPositiveButton("OK", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int whichButton) {
					// TODO Auto-generated method stub
					Editable Edit = CommentInput.getText();
					//((TimelineActivity) getActivity()).doPositiveClick();
					((TimelineActivity) getActivity()).onStorySet(CommentInput.getText().toString());
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int whichButton) {
					// TODO Auto-generated method stub
					
					((TimelineActivity) getActivity()).doNegativeClick();
				}
			}).create();
			return comment.create();	

		default:
			return null;
		}

	}
}