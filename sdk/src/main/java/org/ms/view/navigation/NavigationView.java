package org.ms.view.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class NavigationView extends LinearLayout {
    private Context context;

    private int navigation_navigationBackgroundColor = Color.WHITE;


    public NavigationView(Context context) {
        super(context);
        this.context = context;
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.navigation_view);
            navigation_navigationBackgroundColor = typedArray.getColor(R.styleable.navigation_view_navigationBackgroundColor, Color.WHITE);
            this.setBackgroundColor(navigation_navigationBackgroundColor);
        }
        this.context = context;
        setHorizontalGravity(LinearLayout.HORIZONTAL);
    }


    private List<NavigationChildItemView> childItemViews = new ArrayList<>();


    public void addItem(NavigationChildItemView item) {
        if (item == null) {
            return;
        }
        childItemViews.add(item);
        this.addView(item);
        ((LayoutParams) item.getLayoutParams()).weight = 1;
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reSetSelected();
                item.getImageViewIcon().setSelected(true);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, item);
                }
            }
        });
    }

    private void reSetSelected() {
        for (NavigationChildItemView it : childItemViews) {
            if (it != null) {
                it.getImageViewIcon().setSelected(false);
            }
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {

        void onItemClick(View view, NavigationChildItemView navigationChildItemView);

    }

}