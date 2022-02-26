/****
 Shopper, a simple app.
 Created by Denis Calin in February 2022.
 ****/

package com.example.shopper;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopper.MainActivity;
import com.example.shopper.R;
import com.example.shopper.databinding.FragmentHomeBinding;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    //Add getActivity() method here

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //Submit buttons
        MaterialButton submit_btn_id = (MaterialButton) root.findViewById(R.id.submit_btn_id);

        MaterialButton submit_btn_email = (MaterialButton) root.findViewById(R.id.submit_btn_email);

        MaterialButton submit_btn_phone = (MaterialButton) root.findViewById(R.id.submit_btn_phone);

        MaterialButton submit_btn_first = (MaterialButton) root.findViewById(R.id.submit_btn_first);

        MaterialButton submit_btn_last = (MaterialButton) root.findViewById(R.id.submit_btn_last);

        MaterialButton submit_custom_attributes = (MaterialButton) root.findViewById(R.id.submit_custom_attributes);

        MaterialButton submit_custom_events = (MaterialButton) root.findViewById(R.id.submit_custom_events);


        //Button actions

        //Setting External ID
        submit_btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView external_user_id = (TextView) root.findViewById(R.id.external_user_id);
                String external_user_id_str = external_user_id.getText().toString();

                //Add Braze method to set External ID below this comment

            }
        });

        //Setting Email
        submit_btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView email = (TextView) root.findViewById(R.id.email);
                String email_str = email.getText().toString();

                //Add Braze method to set Email below this comment

            }
        });

        //Setting Phone
        submit_btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView phone = (TextView) root.findViewById(R.id.phone);
                String phone_str = phone.getText().toString();

                //Add Braze method to set Phone below this comment

            }
        });

        //Setting First Name
        submit_btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView first_name = (TextView) root.findViewById(R.id.first_name);
                String first_name_str = first_name.getText().toString();

                //Add Braze method to set First Name below this comment

            }
        });

        //Setting Last Name
        submit_btn_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView last_name = (TextView) root.findViewById(R.id.last_name);
                String last_name_str = last_name.getText().toString();

                //Add Braze method to set Last Name below this comment

            }
        });

        //Setting Custom Attributes (string)
        submit_custom_attributes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView custom_key = (TextView) root.findViewById(R.id.custom_key);
                String custom_key_str = custom_key.getText().toString();

                TextView custom_value = (TextView) root.findViewById(R.id.custom_value);
                String custom_value_str = custom_value.getText().toString();

                //Add Braze method to set Custom Attributes below this comment

            }
        });

        //Logging Custom Events
        submit_custom_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView event_name = (TextView) root.findViewById(R.id.event_name);
                String event_name_str = event_name.getText().toString();

                TextView event_key = (TextView) root.findViewById(R.id.event_key);
                String event_key_str = event_key.getText().toString();

                TextView event_value = (TextView) root.findViewById(R.id.event_value);
                String event_value_str = event_value.getText().toString();

                if (event_key_str.matches("") && event_value_str.matches("")) {

                    //Add Braze method to log custom event without properties below this comment

                }
                else {

                    //Add the BrazeProperties object as the eventProperties local variable by copying 2 lines of code from the guide below this comment


                    //Add Braze method to log custom even with properties by using the eventProperties object below this comment

                }
            }
        });

        return root;


    }

}
