package app.lawnchair.lawnicons;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app.lawnchair.lawnicons.screens.about.AboutFragment;
import app.lawnchair.lawnicons.screens.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(this);
        bottomNav.setSelectedItemId(R.id.page_home);
    }

    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.page_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                bottomNav.setItemActiveIndicatorEnabled(true);
                break;

            case R.id.page_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();
                bottomNav.setItemActiveIndicatorEnabled(true);
                break;

        }

        return true;
    }

}
