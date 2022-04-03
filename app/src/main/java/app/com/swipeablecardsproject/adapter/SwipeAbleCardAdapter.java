package app.com.swipeablecardsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import app.com.swipeablecardsproject.R;
import app.com.swipeablecardsproject.response.CardResponse;

public class SwipeAbleCardAdapter extends BaseAdapter {

    private List<CardResponse> courseData;
    private Context context;
    public SwipeAbleCardAdapter(List<CardResponse> courseData, Context context) {
        this.courseData = courseData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return courseData.size();
    }

    @Override
    public Object getItem(int position) {
        return courseData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int currentPosition = position<0 ? 0 : position;
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_swipeable_layout, parent, false);
        }
        ((TextView) v.findViewById(R.id.name)).setText(courseData.get(currentPosition).getText());
        return v;
    }
}

