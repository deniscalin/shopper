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

import com.braze.Braze;
import com.braze.models.outgoing.BrazeProperties;
import com.example.shopper.MainActivity;
import com.example.shopper.R;
import com.example.shopper.databinding.FragmentHomeBinding;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    final Context activityContext = getActivity();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //Submit buttons
        MaterialButton submit_btn_id = (MaterialButton) root.findViewById(R.id.submit_btn_id);

        MaterialButton submit_btn_email = (MaterialButton) root.findViewById(R.id.submit_btn_email);

        MaterialButton submit_btn_phone = (MaterialButton) root.findViewById(R.id.submit_btn_phone);

        MaterialButton submit_btn_first = (MaterialButton) root.findViewById(R.id.submit_btn_first);

        MaterialButton submit_btn_last = (MaterialButton) root.findViewById(R.id.submit_btn_last);

        MaterialButton submit_custom_attributes = (MaterialButton) root.findViewById(R.id.submit_custom_attributes);

        MaterialButton submit_custom_events = (MaterialButton) root.findViewById(R.id.submit_custom_events);


        //Buttons actions

        //Setting External ID
        submit_btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add method to set External ID

                TextView external_user_id = (TextView) root.findViewById(R.id.external_user_id);
                String external_user_id_str = external_user_id.getText().toString();

                //Add Braze method to set External ID
                Braze.getInstance(activityContext).changeUser(external_user_id_str);

            }
        });

        //Setting Email
        submit_btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add method to set email

                TextView email = (TextView) root.findViewById(R.id.email);
                String email_str = email.getText().toString();

                //Add Braze method to set Email
                Braze.getInstance(activityContext).getCurrentUser().setEmail(email_str);

            }
        });

        //Setting Phone
        submit_btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView phone = (TextView) root.findViewById(R.id.phone);
                String phone_str = phone.getText().toString();

                //Add Braze method to set Phone
                Braze.getInstance(activityContext).getCurrentUser().setPhoneNumber(phone_str);

            }
        });

        //Setting First Name
        submit_btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView first_name = (TextView) root.findViewById(R.id.first_name);
                String first_name_str = first_name.getText().toString();

                //Add Braze method to set First Name
                Braze.getInstance(activityContext).getCurrentUser().setFirstName(first_name_str);

            }
        });

        //Setting Last Name
        submit_btn_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView last_name = (TextView) root.findViewById(R.id.last_name);
                String last_name_str = last_name.getText().toString();

                //Add Braze method to set Last Name
                Braze.getInstance(activityContext).getCurrentUser().setLastName(last_name_str);

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

                //Add Braze method to set Custom Attributes
                Braze.getInstance(activityContext).getCurrentUser().setCustomUserAttribute(custom_key_str,custom_value_str);

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

                    //Add Braze method to log custom event without properties
                    Braze.getInstance(activityContext).logCustomEvent(event_name_str);
                }
                else {
                    BrazeProperties eventProperties = new BrazeProperties();
                    eventProperties.addProperty(event_key_str, event_value_str);

                    //Add Braze method to log custom even with properties by using the eventProperties object
                    Braze.getInstance(activityContext).logCustomEvent(event_name_str, eventProperties);
                }
            }
        });

        return root;


    }

}
