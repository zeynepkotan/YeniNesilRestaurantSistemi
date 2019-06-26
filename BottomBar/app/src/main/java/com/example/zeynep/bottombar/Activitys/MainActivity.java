package com.example.zeynep.bottombar.Activitys;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.zeynep.bottombar.Fragments.FragmentOne;
import com.example.zeynep.bottombar.Fragments.FragmentThree;
import com.example.zeynep.bottombar.Fragments.FragmentTwo;
import com.example.zeynep.bottombar.Fragments.LoginFragment;
import com.example.zeynep.bottombar.Fragments.LoginFragmentKasa;
import com.example.zeynep.bottombar.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
         int deger=0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Menü");
                    FragmentOne fragment1 = new FragmentOne();
                    FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fram,fragment1,"FragmentName"  );
                    fragmentTransaction1.commit();
                    return true;

                case R.id.navigation_dashboard:
                    setTitle("Mutfak");
                    if(deger==1) {
                        FragmentTwo fragment2 = new FragmentTwo();
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.fram, fragment2, "FragmentName");
                        fragmentTransaction2.commit();
                    }
                    else {
                        LoginFragment loginFragment=new LoginFragment();
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.fram, loginFragment, "FragmentName");
                        fragmentTransaction4.commit();
                    }
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Kasa");
                    if (deger==1) {
                        FragmentThree fragment3 = new FragmentThree();
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.fram, fragment3, "FragmentName");
                        fragmentTransaction3.commit();
                    }
                    else{
                        LoginFragmentKasa loginFragmentKasa=new LoginFragmentKasa();
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.fram, loginFragmentKasa, "FragmentName");
                        fragmentTransaction4.commit();

                    }

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Menü");
        FragmentOne fragment = new FragmentOne();
        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fram,fragment, "fragmentname"  );
        fragmentTransaction1.commit();
    }

}
