package com.example.androidtutorial;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sample extends Activity {

    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String URLS="https://dummyjson.com/products/1";
    String URLS1="https://dummyjson.com";
    private List<String> images= new ArrayList<>();
     //private ImageView imageView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog= new ProgressDialog(this, androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
        requestQueue= Volley.newRequestQueue(this);
       // imageView=(ImageView)findViewById(R.id.imageview);


       // Servicecall();
        ServiceCall1();
    }

    private void ServiceCall1() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLS1) .
                addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        RetrofitAPICall retrofitAPI = retrofit.create(RetrofitAPICall.class);
        Call<ResponseObject> call = retrofitAPI.getData();
        call.enqueue(new Callback<ResponseObject>() {
            // on below line calling on response method.


            @Override
            public void onResponse(Call<ResponseObject> call, retrofit2.Response<ResponseObject> response) {

                Log.e("id",response.body().getId());
                Log.e("title",response.body().getTitle());

                Log.e("desc",response.body().getDescription());
                Log.e("price",response.body().getPrice());
                Log.e("rating",response.body().getRating());
                Log.e("stock",response.body().getStock());
                Log.e("brand",response.body().getBrand());
                Log.e("category",response.body().getCategory());
                Log.e("thumbnail",response.body().getThumbnail());
                images=response.body().getImages();

                for(int i=0;i<images.size();i++){
                    String image=images.get(i);
                    /*RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher_round);
                    Glide.with(Sample.this).load(image).apply(options).into(imageView);*/
                    Log.e("images",image);
                }


            }

            // on below line calling on failure method.
            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                // displaying a toast message when as error is received.
                Toast.makeText(Sample.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Servicecall() {
         /*JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name","khan");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        final List<NameValuePair> params = new ArrayList<NameValuePair>();

       // params.add(new BasicNameValuePair("opt","details"));
      //  params.add(new BasicNameValuePair("json-string",jsonObject.toString()));

        progressDialog.setTitle("Loading");
        progressDialog.setIndeterminate(true);;
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLS,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response",response);
                        if (response != null && response.length() > 0) {

                            try {

                                JSONObject jsonObject1 = new JSONObject(response);
                                String id = jsonObject1.getString("id");
                                Log.e("id",id);
                                String  title=jsonObject1.getString("title");
                                Log.e("title",title);
                                String description=jsonObject1.getString("description");
                                Log.e("description",description);
                                String price=jsonObject1.getString("price");
                                Log.e("price",price);
                                String rating=jsonObject1.getString("rating");
                                Log.e("rating",rating);
                                String stock=jsonObject1.getString("stock");
                                Log.e("stock",stock);
                                String brand=jsonObject1.getString("brand");
                                Log.e("brand",brand);
                                String category=jsonObject1.getString("category");
                                Log.e("category",category);
                                String thumbnail=jsonObject1.getString("thumbnail");
                                Log.e("thumbnail",thumbnail);
                                String images=jsonObject1.getString("images");
                                Log.e("images",images);
                                JSONArray jsonArray = new JSONArray(images);
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    String object = jsonArray.getString(i);
                                    Log.e("images",object.toString());
                                 }








                                }catch (JSONException e) {
                                e.printStackTrace();
                            }



                            }



                        }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> params1 = new HashMap<String,String>();
                String cred= String.format("%s:%s","user123","abcd");
                String auth ="Basic"+Base64.encodeToString(cred.getBytes(),Base64.NO_WRAP);

                params1.put("Authoraztion",auth);

                return params1;
            }


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap <String,String> nparams = new HashMap<String,String>();

                for (int i=0;i<params.size();i++){

                    nparams.put(params.get(i).getName(),params.get(i).getValue());
                }
                return nparams;
            }
        };

        int sockettime=30000;
        RetryPolicy policy = new DefaultRetryPolicy(sockettime,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);

    }
}
