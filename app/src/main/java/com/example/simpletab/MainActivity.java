package com.example.simpletab;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbr;
private TabLayout tablout;
private ViewPager viewpger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbr=findViewById(R.id.toolbar);
        toolbr.setTitle("GPLUS");
        setSupportActionBar(toolbr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//used to add back arrow
        viewpger=findViewById(R.id.viewpager);
        setupViewpager(viewpger);
        tablout=findViewById(R.id.tblayt);
        tablout.setupWithViewPager(viewpger);

    }

    private void setupViewpager(ViewPager viewpger) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewpger.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    Message mss = new Message();//layoutname obj=new layoutname;
                    return mss;
                case 1:
                    Status sts = new Status();
                    return sts;
                case 2:
                    Calls cll = new Calls();
                    return cll;
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return "Messages";
                case 1:
                    return "Status";
                case 2:
                    return "Calls";
                    default:return null;
            }
        }
    }

}
