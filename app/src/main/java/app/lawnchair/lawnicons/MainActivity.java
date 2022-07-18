package app.lawnchair.lawnicons;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app.lawnchair.lawnicons.screens.about.AboutFragment;
import app.lawnchair.lawnicons.screens.home.HomeFragment;
import app.lawnchair.lawnicons.screens.icons.GetIconInfo;
import app.lawnchair.lawnicons.screens.icons.IconsFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFragments();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setSelectedItemId(R.id.page_home);
        bottomNav.setOnItemSelectedListener(this);


        //Run threads
        Thread dataThread = new Data();
        Data.setContext(getApplicationContext());
        dataThread.start();

        Thread iconsThread = new GetIconInfo();
        GetIconInfo.setContext(getApplicationContext());
        iconsThread.start();
    }

    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();
    IconsFragment iconsFragment = new IconsFragment();
    FragmentManager manager = getSupportFragmentManager();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.page_home:
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.zoom_in_lite, R.anim.fade_out)
                        .show(homeFragment)
                        .hide(aboutFragment)
                        .hide(iconsFragment)
                        .commit();
                return true;

            case R.id.page_icons:
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.zoom_in_lite, R.anim.fade_out)
                        .show(iconsFragment)
                        .hide(homeFragment)
                        .hide(aboutFragment)
                        .commit();
                return true;

            case R.id.page_about:
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.zoom_in_lite, R.anim.fade_out)
                        .show(aboutFragment)
                        .hide(homeFragment)
                        .hide(iconsFragment)
                        .commit();
                return true;
            default:
                return false;
        }

    }

    void initializeFragments(){
        manager.beginTransaction()
                .add(R.id.container, homeFragment)
                .add(R.id.container, iconsFragment)
                .add(R.id.container, aboutFragment)
                .hide(iconsFragment)
                .hide(aboutFragment)
                .commit();
    }
}
