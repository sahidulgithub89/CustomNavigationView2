package com.brahmanbaria.customnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  private Toolbar toolbar1;
  private DrawerLayout drawerLayout;
  private NavigationView navigationView;


    TextView notic;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference fastDatabase = databaseReference.child("notic1");

    ImageSlider imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar1=findViewById(R.id.toolBar);
        notic=findViewById(R.id.notic);

        notic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobile= "https://wa.me/+8801782121284?text= Hi im fine";

                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mobile));
                startActivity(intent);





              /* Intent in =new Intent(Intent.ACTION_SEND );
                in.setType("Text/plain");
                in.putExtra(Intent.EXTRA_SUBJECT,"CHCP COMMUNITY");
                in.putExtra(Intent.EXTRA_TEXT,"LINK");
                startActivity(Intent.createChooser(in,"Share via"));

               */


            }
        });

        //// scrollHorizontally Text ///
        notic=findViewById(R.id.notic);
        notic.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        notic.setSelected(true);
        //// scrollHorizontally Text End ///



        setSupportActionBar(toolbar1);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout=findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar1,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener( this);



        ///// Slider ////

        imageSlider=findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.bb, "Sritoshod", null));
        imageList.add(new SlideModel(R.drawable.brahmanbariacollegepic1, "Brahmanbaria Gov: College", null));
        imageList.add(new SlideModel(R.drawable.abirpark, "Abi River Park", null));
        imageList.add(new SlideModel(R.drawable.univercityofbrahmanbariapic, "Univercity Of Btahmanbaria", null));
        imageList.add(new SlideModel(R.drawable.boromosjid, "Boro Mosjid ", null));
        imageList.add(new SlideModel(R.drawable.brahmanjala, "Brahmanbaria Jila", null));
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);


        ///// End Slider /////



    }

    @Override
    protected void onStart() {
        super.onStart();

        fastDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.getValue(String.class) != null) {
                    String key = snapshot.getKey();

                    if (key.equals("notic1")) {

                        String notic1 = snapshot.getValue(String.class);
                        notic.setText(notic1);


                    }


                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        switch (menuitem.getItemId()) {
            case R.id.share:

                Intent in =new Intent(Intent.ACTION_SEND);
                in.setType("Text/plain");
                in.putExtra(Intent.EXTRA_SUBJECT,"CHCP COMMUNITY");
                in.putExtra(Intent.EXTRA_TEXT,"LINK");
                startActivity(Intent.createChooser(in,"Share via"));

                Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

        }

        return false;

    }
}