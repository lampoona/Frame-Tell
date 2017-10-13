package edu.dartmouth.cs.frameandtell;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReaderPageFragment extends Fragment {

	public static final String KEY_PAGE_NUMBER = "page";

	private int mPageNumber;

	// Constructs a new fragment for the given page number
	public static ReaderPageFragment create(int pageNumber) {
		ReaderPageFragment fragment = new ReaderPageFragment();
		Bundle args = new Bundle();
		args.putInt(KEY_PAGE_NUMBER, pageNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public ReaderPageFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPageNumber = getArguments().getInt(KEY_PAGE_NUMBER);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.fragment_reader_page, container, false);

		// show the page number.
		((TextView) rootView.findViewById(R.id.textView1))
				.setText(String.valueOf(mPageNumber + 1));

		return rootView;
	}
	
    public int getPageNumber() {
        return mPageNumber;
    }
}
