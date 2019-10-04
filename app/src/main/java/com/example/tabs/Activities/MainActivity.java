package com.example.tabs.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Menu;

import com.example.tabs.Adapters.PagerAdapter;
import com.example.tabs.R;
import com.google.android.material.tabs.TabLayout;


import static com.example.tabs.R.id.tab;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TabLayout mytabLayout = findViewById(tab);
        mytabLayout.addTab(mytabLayout.newTab().setText("About"));
        mytabLayout.addTab(mytabLayout.newTab().setText("Cotizacion"));
        mytabLayout.addTab(mytabLayout.newTab().setText("Extras"));
        mytabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewpager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),mytabLayout.getTabCount());

        viewpager.setAdapter(adapter);


        viewpager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(mytabLayout));
        mytabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Cuando seleccionamos un Tab
                int position = tab.getPosition();
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                    //Cuando el tab que estaba activo deja de serlo
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Cuando seleccionamos el tab que esta activo
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
