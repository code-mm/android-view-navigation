package org.ms.view.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NavigationChildItemView extends RelativeLayout {

    private Context context;
    private int navigation_navigationChildTextColor = Color.BLACK;
    private int navigation_navigationChildImageWidth = 60;
    private int navigation_navigationChildImageHeight = 60;
    private int navigation_navigationChildTextSize = 12;
    private ImageView imageViewIcon;
    private TextView textViewName;
    private String navigation_child_view_navigationChildText;
    private Drawable navigation_child_view_navigationChildDrawable;

    public NavigationChildItemView(Context context) {
        super(context);

        this.context = context;
    }

    public NavigationChildItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.navigation_child_view);

            navigation_navigationChildTextColor = typedArray.getColor(R.styleable.navigation_child_view_navigationChildTextColor, Color.BLACK);
            navigation_navigationChildImageWidth = typedArray.getInt(R.styleable.navigation_child_view_navigationChildImageWidth, 60);
            navigation_navigationChildImageHeight = typedArray.getInt(R.styleable.navigation_child_view_navigationChildImageHeight, 60);
            navigation_navigationChildTextSize = typedArray.getInt(R.styleable.navigation_child_view_navigationChildTextSize, 12);
            navigation_child_view_navigationChildText = typedArray.getString(R.styleable.navigation_child_view_navigationChildText);
            navigation_child_view_navigationChildDrawable = typedArray.getDrawable(R.styleable.navigation_child_view_navigationChildDrawable);
        }
        this.context = context;

        Item item = new Item();
        item.name = navigation_child_view_navigationChildText;
        item.drawable = navigation_child_view_navigationChildDrawable;

        createItemView(item);
    }

    private Item item;

    public Item getItem() {
        return item;
    }

    public ImageView getImageViewIcon() {
        return imageViewIcon;
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public void createItemView(Item item) {

        if (item == null) {
            return;
        }
        this.item = item;

        RelativeLayout.LayoutParams relativeLayoutNavigationLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(relativeLayoutNavigationLayoutParams);


        imageViewIcon = new ImageView(context);
        imageViewIcon.setImageDrawable(item.drawable);
        RelativeLayout.LayoutParams imageViewIconLayoutParams = new RelativeLayout.LayoutParams(navigation_navigationChildImageWidth, navigation_navigationChildImageHeight);
        imageViewIconLayoutParams.setMargins(2, -5, 2, 2);
        imageViewIcon.setPadding(2, 2, 2, 2);
        imageViewIcon.setLayoutParams(imageViewIconLayoutParams);
        imageViewIcon.setId(View.generateViewId());
        this.addView(imageViewIcon);

        textViewName = new TextView(context);
        textViewName.setText(item.name);
        RelativeLayout.LayoutParams textViewNameLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewNameLayoutParams.setMargins(2, 2, 2, 2);
        textViewName.setPadding(2, 2, 2, 2);
        textViewName.setTextSize(navigation_navigationChildTextSize);
        textViewName.setLayoutParams(textViewNameLayoutParams);
        textViewName.setTextColor(navigation_navigationChildTextColor);
        this.addView(textViewName);

        ((RelativeLayout.LayoutParams) imageViewIcon.getLayoutParams()).addRule(RelativeLayout.CENTER_IN_PARENT);
        ((RelativeLayout.LayoutParams) textViewName.getLayoutParams()).addRule(RelativeLayout.CENTER_HORIZONTAL);
        ((RelativeLayout.LayoutParams) textViewName.getLayoutParams()).addRule(RelativeLayout.BELOW, imageViewIcon.getId());

    }

    public static class Item {
        public Drawable drawable;
        public String name;
        public int textSize;
        public Color textColor;
        public Color backgroundColor;
    }
}