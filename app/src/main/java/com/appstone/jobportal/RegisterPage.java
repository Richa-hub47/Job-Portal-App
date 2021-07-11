package com.appstone.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {

    private Toolbar tlBar;

   private DrawerLayout drawerLayout;

//    private TextView vrfyEmail;
//    private Button btnVrfyEmail;
//    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

//        vrfyEmail = findViewById(R.id.tv_vrfyEmail);
//        btnVrfyEmail = findViewById(R.id.btn_vrfyEmail);
//        final FirebaseUser user = auth.getCurrentUser();

        tlBar = findViewById(R.id.tl_home);
        setSupportActionBar(tlBar);

        drawerLayout = findViewById(R.id._drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,tlBar,R.string.open,R.string.close);
        drawerToggle.syncState();






        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){

                    case R.id.profile :
                        startActivity(new Intent(RegisterPage.this,UserDetails.class));

                        break;

                    case R.id.logout:

                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(RegisterPage.this,LoginPage.class));
                        finish();


                        break;


                }

                return false;
            }
        });



    }

    public void onClickJobProvider(View view){
        startActivity(new Intent(RegisterPage.this,MainActivity.class));
    }

    public void onClickJobSeeker(View view){
        startActivity(new Intent(RegisterPage.this,ImagesActivity.class));
    }


}