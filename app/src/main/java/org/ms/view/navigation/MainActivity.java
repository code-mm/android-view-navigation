package org.ms.view.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;

    private List<NavigationChildItemView> navigationChildItemViews = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation);


        NavigationChildItemView navigationChildItemViewMessage = new NavigationChildItemView(this);
        NavigationChildItemView.Item itemMessage = new NavigationChildItemView.Item();
        itemMessage.name = "消息";
        itemMessage.drawable = getResources().getDrawable(R.drawable.tab_bar_message);
        navigationChildItemViewMessage.createItemView(itemMessage);
        navigationChildItemViews.add(navigationChildItemViewMessage);


        NavigationChildItemView navigationChildItemViewTool = new NavigationChildItemView(this);
        NavigationChildItemView.Item itemTool = new NavigationChildItemView.Item();
        itemTool.name = "工具";
        itemTool.drawable = getResources().getDrawable(R.drawable.tab_bar_tool);
        navigationChildItemViewTool.createItemView(itemTool);
        navigationChildItemViews.add(navigationChildItemViewTool);


        NavigationChildItemView navigationChildItemViewMy = new NavigationChildItemView(this);
        NavigationChildItemView.Item itemMy = new NavigationChildItemView.Item();
        itemMy.name = "我的";
        itemMy.drawable = getResources().getDrawable(R.drawable.tab_bar_my);
        navigationChildItemViewMy.createItemView(itemMy);
        navigationChildItemViews.add(navigationChildItemViewMy);

        for (NavigationChildItemView it : navigationChildItemViews) {
            navigationView.addItem(it);
        }

        navigationView.setOnItemClickListener(new NavigationView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, NavigationChildItemView navigationChildItemView) {


                Toast.makeText(MainActivity.this, ""+navigationChildItemView.getItem().name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}