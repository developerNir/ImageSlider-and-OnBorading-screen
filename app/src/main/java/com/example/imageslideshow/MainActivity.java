package com.example.imageslideshow;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ImageSlider imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        imageSlider = findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();


//        slideModels.add(new SlideModel(R.drawable.imagemy, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.imagemy, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.imagemy, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.imagemy, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.imagemy, ScaleTypes.FIT));

        slideModels.add(new SlideModel("https://cdn.pixabay.com/photo/2016/03/08/20/03/flag-1244649_960_720.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.pixabay.com/photo/2018/04/26/16/39/beach-3352363_960_720.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/1444101433/photo/flying-drone-over-large-lake-with-view-of-mountain-peaks.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.pixabay.com/photo/2020/09/19/19/37/landscape-5585247_960_720.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/1443409611/photo/man-on-stone-on-the-hill-and-beautiful-mountains-in-haze-at-colorful-sunset-in-autumn.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);


    }
}