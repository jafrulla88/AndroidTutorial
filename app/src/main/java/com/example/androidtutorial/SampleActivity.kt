package com.example.androidtutorial

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.apache.http.NameValuePair
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class SampleActivity :AppCompatActivity() {
    var requestQueue: RequestQueue? = null
    var progressDialog: ProgressDialog? = null
   // var URLS = "https://dummyjson.com/products/1"
    var URLS = "https://eos-api.mlsdigital.net/v1/www.fcdallas.com/players?club_opta_id=1903&player_status=active&token=AcQ5w0M67d9TKwbg"
    var URLS1 = "https://dummyjson.com"
    private var parentList: ArrayList<ParentData> = ArrayList()
    var childList:ArrayList<Members> = ArrayList()
    var midfileder:ArrayList<String> = ArrayList()


    private var recyclerView:RecyclerView?=null
    var parentData :ParentData?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          recyclerView = findViewById<RecyclerView>(R.id.parent_recycler_view)

        progressDialog = ProgressDialog(this, androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert)
        requestQueue = Volley.newRequestQueue(this)


        Servicecall()
    }
    private fun ParentItemList(): List<ParentItem>? {
        val itemList: MutableList<ParentItem> = ArrayList()
        val item = ParentItem("Title 1", ChildItemList())
        itemList.add(item)
        val item1 = ParentItem("Title 2", ChildItemList())
        itemList.add(item1)
        val item2 = ParentItem("Title 3", ChildItemList())
        itemList.add(item2)
        val item3 = ParentItem("Title 4", ChildItemList())
        itemList.add(item3)
        return itemList
    }
    private fun ChildItemList(): List<ChildItem>? {
        val ChildItemList: MutableList<ChildItem> = java.util.ArrayList()
        ChildItemList.add(ChildItem("Card 1"))
        ChildItemList.add(ChildItem("Card 2"))
        ChildItemList.add(ChildItem("Card 3"))
        ChildItemList.add(ChildItem("Card 4"))
        return ChildItemList
    }
    private fun Servicecall() {
        /*JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name","khan");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        val params: List<NameValuePair> = java.util.ArrayList()

        // params.add(new BasicNameValuePair("opt","details"));
        //  params.add(new BasicNameValuePair("json-string",jsonObject.toString()));
        progressDialog!!.setTitle("Loading")
        progressDialog!!.setIndeterminate(true)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        val stringRequest: StringRequest = object : StringRequest(
            Method.GET, URLS,
            Response.Listener { response ->
                var response1:String="[\n" +
                        "   {\n" +
                        "      \"slug\":\"stark\",\n" +
                        "      \"name\":\"House Stark of Winterfell\",\n" +
                        "      \"members\":[\n" +
                        "         {\n" +
                        "            \"name\":\"Jon Snow\",\n" +
                        "            \"slug\":\"jon\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Sansa Stark\",\n" +
                        "            \"slug\":\"sansa\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Eddard \\\"Ned\\\" Stark\",\n" +
                        "            \"slug\":\"ned\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Arya Stark\",\n" +
                        "            \"slug\":\"arya\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Bran Stark\",\n" +
                        "            \"slug\":\"bran\"\n" +
                        "         }\n" +
                        "      ]\n" +
                        "   },\n" +
                        "   {\n" +
                        "      \"slug\":\"lannister\",\n" +
                        "      \"name\":\"House Lannister of Casterly Rock\",\n" +
                        "      \"members\":[\n" +
                        "         {\n" +
                        "            \"name\":\"Jaime Lannister\",\n" +
                        "            \"slug\":\"jaime\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Tyrion Lannister\",\n" +
                        "            \"slug\":\"tyrion\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Cersei Lannister\",\n" +
                        "            \"slug\":\"cersei\"\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"name\":\"Tywin Lannister\",\n" +
                        "            \"slug\":\"tywin\"\n" +
                        "         }\n" +
                        "      ]\n" +
                        "   }\n" +
                        "   \n" +
                        "]"
                Log.e("Response", response!!)
             //   Log.e("Response1", response1!!)
                if (response != null && response.length > 0) {

                    try {
                        val jsonarray = JSONArray(response)

                        for (i in 0 until jsonarray.length()) {
                            var members=Members()
                            var headshotnew=Headshot()
                            val jsonobject: JSONObject = jsonarray.getJSONObject(i)
                            val position = jsonobject.getString("position")
                            val fname = jsonobject.getString("first_name")
                            val lname = jsonobject.getString("last_name")
                            val jersy =jsonobject.getString("jersey_number")
                            /*val headshot =jsonobject.getString("headshot")
                            if(headshot!==null) {
                                val jsonobject1 = JSONObject(headshot)
                                val original = jsonobject1.getString("original")
                                if (original !== null) {
*/
                                    parentData = ParentData()

                                    members.first_name = fname
                                    members.last_name = lname
                                    members.jersey_number = jersy
                                    members.memberslist.add(members)

                                  //  headshotnew!!.original = original
                                    parentData!!.position = position
                                    parentData = ParentData(position,members)
                                    parentList.add(parentData!!)
                            //    }
                          //  }
                                /* val subName = "Midfielder"
                            val groupJsonWithSubName = JSONArray()
                            if (jsonobject.getString("position") == subName) {
                               *//* groupJsonWithSubName.put(jsonobject)
                                Log.e("group",groupJsonWithSubName.toString())*//*

                                midfileder.add(fname);
                            }
                            Log.e("jsondata", midfileder.toString())
                            parentData!!.first_name=midfileder.toString()
                            parentList.add(parentData!!)*/


                                /* for (i in 0 until groupJsonWithSubName.length()) {
                                val jsonObject2 = groupJsonWithSubName.getJSONObject(i)
                                val fname = jsonObject2.getString("first_name")
                                val lname = jsonObject2.getString("last_name")
                                val jersy =jsonObject2.getString("jersey_number")
                                val members = Members()
                                members.first_name=fname
                                members.last_name=lname
                                members.jersey_number=jersy
                                parentData.members=childList
                                parentList.add(parentData)
                                childList.add(members)

                                
                            }*/
                                val layoutManager = LinearLayoutManager(
                                    this, LinearLayoutManager.VERTICAL,
                                    false
                                )
                                val parentItemAdapter = ParentsDataAdapter(parentList,this)

                                recyclerView?.setAdapter(parentItemAdapter)
                                recyclerView?.setLayoutManager(layoutManager)
                                parentItemAdapter.notifyDataSetChanged()


                        }




                         // Initialise the Linear layout manager



                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            },
            Response.ErrorListener { }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val params1 = HashMap<String, String>()
                val cred = String.format("%s:%s", "user123", "abcd")
                val auth = "Basic" + Base64.encodeToString(cred.toByteArray(), Base64.NO_WRAP)
                params1["Authorization"] = auth
                return params1
            }

            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val nparams = HashMap<String, String>()
                for (i in params.indices) {
                    nparams[params[i].name] = params[i].value
                }
                return nparams
            }
        }
        val sockettime = 30000
        val policy: RetryPolicy = DefaultRetryPolicy(
            sockettime,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        stringRequest.retryPolicy = policy
        requestQueue?.add<String>(stringRequest)
    }


}