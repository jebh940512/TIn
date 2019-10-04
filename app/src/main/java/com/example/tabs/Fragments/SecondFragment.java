package com.example.tabs.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tabs.R;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private View view;
    private Context context;
    private Button btn;
    private TextView textview;
    private EditText number;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_second, container, false);
        btn = view.findViewById(R.id.boton_peticion);
        textview=view.findViewById(R.id.text_peticion);
        number=view.findViewById(R.id.number_peticion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = ""+number.getText();
                final int SIMPLE_REQUEST = 1;
                String url = "http://34.67.39.126:8082/auditoria/getAuditoriaId/"+numero;
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        textview.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textview.setText("Error en la peticion");
                        System.out.println("Error"+error);
                    }
                });
                request.setTag(SIMPLE_REQUEST);
                requestQueue.add(request);
            }
        });
        return view;
    }
}
