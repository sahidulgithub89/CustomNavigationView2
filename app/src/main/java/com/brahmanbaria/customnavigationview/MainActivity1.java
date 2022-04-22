package com.brahmanbaria.customnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity1 extends AppCompatActivity {

    TextView noticTest1, noticTest2, noticTest3, noticTest4, noticTest5;
    ImageView img;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference fastDatabase1 = databaseReference.child("noticdemo1");
    private DatabaseReference fastDatabase2 = databaseReference.child("noticdemo2");
    private DatabaseReference fastDatabase3 = databaseReference.child("noticdemo3");
    private DatabaseReference fastDatabase4 = databaseReference.child("noticdemo4");
    private DatabaseReference fastDatabase5 = databaseReference.child("noticdemo5");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        noticTest1 = findViewById(R.id.noticTest1);
        noticTest2 = findViewById(R.id.noticTest2);
        noticTest3 = findViewById(R.id.noticTest3);
        noticTest4 = findViewById(R.id.noticTest4);

        img = findViewById(R.id.img);


    }

    @Override
    protected void onStart() {
        super.onStart();

        fastDatabase1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.getValue(String.class) != null) {
                    String key = snapshot.getKey();

                    if (key.equals("noticdemo1")) {

                        String notic1 = snapshot.getValue(String.class);
                        noticTest1.setText(notic1);


                    }


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fastDatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.getValue(String.class) != null) {
                    String key = snapshot.getKey();

                    if (key.equals("noticdemo2")) {

                        String notic2 = snapshot.getValue(String.class);
                        noticTest2.setText(notic2);


                    }


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fastDatabase3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.getValue(String.class) != null) {
                    String key = snapshot.getKey();

                    if (key.equals("noticdemo3")) {

                        String notic3 = snapshot.getValue(String.class);
                        noticTest3.setText(notic3);


                    }


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fastDatabase4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.getValue(String.class) != null) {
                    String key = snapshot.getKey();

                    if (key.equals("noticdemo4")) {

                        String notic4 = snapshot.getValue(String.class);
                        noticTest4.setText(notic4);


                    }


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fastDatabase5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String link=snapshot.getValue(String.class);
                Picasso.get().load(link).into(img);
                    }







            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}