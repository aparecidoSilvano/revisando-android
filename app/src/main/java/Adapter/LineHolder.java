package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.silva.praticando_layouts.R;

class LineHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView subTitle;

    LineHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_line_title);
        subTitle = itemView.findViewById(R.id.tv_line_subtitle);
    }
}
