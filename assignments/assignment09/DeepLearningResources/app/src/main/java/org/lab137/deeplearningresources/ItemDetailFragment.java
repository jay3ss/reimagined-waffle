package org.lab137.deeplearningresources;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.lab137.deeplearningresources.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // First, grab the root view. Then, grab each view in the layout
        View rootView = inflater.inflate(R.layout.fastai, container, false);
        TextView text = rootView.findViewById(R.id.txtResource);
        ImageView image = rootView.findViewById(R.id.imgResource);
        WebView web = (WebView) rootView.findViewById(R.id.webResource);

        int txtResourceId = 0;
        int imgResourceId = 0;
        String url = "";

        // Show the dummy content as text in a TextView.
        if (mItem.id.equals("1")) {
            txtResourceId = R.string.txtFastai;
            imgResourceId = R.drawable.fastai;
            url = getString(R.string.urlFastai);
        }

        if (mItem.id.equals("2")) {
            txtResourceId = R.string.txtFastai;
            imgResourceId = R.drawable.fastai;
            url = getString(R.string.urlFastai);
        }

        if (mItem.id.equals("3")) {
            txtResourceId = R.string.txtFastai;
            imgResourceId = R.drawable.fastai;
            url = getString(R.string.urlFastai);
        }

        if (mItem.id.equals("4")) {
            txtResourceId = R.string.txtFastai;
            imgResourceId = R.drawable.fastai;
            url = getString(R.string.urlFastai);
        }

        // Now, set the resources
        text.setText(txtResourceId);
        image.setImageResource(imgResourceId);
        web.loadUrl(url);

        return rootView;
    }
}
