package com.odoclean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment
{

    Button image1;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        View rootView = inflater.inflate(R.layout.tab1 , container, false);

        Button image1 = (Button) rootView.findViewById(R.id.image1);
        Button image2 = (Button) rootView.findViewById(R.id.image2);
        Button image3 = (Button) rootView.findViewById(R.id.image3);//Binding the button view
        Button image4=(Button) rootView.findViewById(R.id.image4);
        Button image5=(Button) rootView.findViewById(R.id.image5);
        Button image6=(Button) rootView.findViewById(R.id.image6);

        image1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent (Fragment1.this.getActivity(), Dfragment_image1.class);
                Fragment1.this.getActivity().startActivity(intent);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent (Fragment1.this.getActivity(), Dfragment_image2.class);
                Fragment1.this.getActivity().startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent (Fragment1.this.getActivity(), Dfragment_image3.class);
                Fragment1.this.getActivity().startActivity(intent);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (Fragment1.this.getActivity(), Dfragment_image3.class);
                Fragment1.this.getActivity().startActivity(intent);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (Fragment1.this.getActivity(), Dfragment_image3.class);
                Fragment1.this.getActivity().startActivity(intent);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (Fragment1.this.getActivity(), Dfragment_image3.class);
                Fragment1.this.getActivity().startActivity(intent);
            }
        });


        return rootView;

        // Inflate the layout for this fragment

    }

}