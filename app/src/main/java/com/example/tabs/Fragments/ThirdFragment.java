package com.example.tabs.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tabs.R;
import org.json.JSONException;
import org.json.JSONObject;


public class ThirdFragment extends Fragment {
    private EditText cvve;
    private EditText operation;
    private TextView result;
    private Button enviar;

    public ThirdFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_third, container, false);

        enviar=view.findViewById(R.id.Enviar);


        enviar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                String mJSONURLString="https://grupohit.net/igenter/auditoria/GuardarAuditoria";
                JSONObject jsonBody = new JSONObject();
                cvve = view.findViewById(R.id.cvcve);
                operation = view.findViewById(R.id.operation);
                result = view.findViewById(R.id.result);
                int numero = Integer.parseInt(cvve.getText().toString());
                String  oper = operation.getText().toString();
                try {

                    jsonBody.put("cvcve",numero);
                    jsonBody.put("operation",oper);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, mJSONURLString, jsonBody,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                result.setText(response.toString());
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error){
                                result.setText("error al llamar la aplicación");
                            }
                        }
                );


                requestQueue.add(jsonObjectRequest);
            }
        });

    }

}
