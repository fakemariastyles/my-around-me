package com.workshop.aroundme.app.ui.signup

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.JsonObject
import com.workshop.aroundme.R
import com.workshop.aroundme.app.Injector
import com.workshop.aroundme.app.ui.home.HomeFragment
import com.workshop.aroundme.data.model.UserEntity
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.json.JSONException
import org.json.JSONObject

class SignUpFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    @SuppressLint("ApplySharedPref")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = view.findViewById<EditText>(R.id.email)
        val fullName = view.findViewById<EditText>(R.id.fullName)
        val password = view.findViewById<EditText>(R.id.password)
        val password2 = view.findViewById<EditText>(R.id.password2)
        view.findViewById<View>(R.id.signUp).setOnClickListener(){
            println(email.text.toString())
            if(email.text.isNotEmpty() && fullName.text.isNotEmpty() && password.text.isNotEmpty() && password2.text.isNotEmpty()){
                if(password.text.toString() == password2.text.toString()){
                    signUp(fullName.text.toString(),email.text.toString(),password.text.toString())
                }else{
                    Toast.makeText(requireContext(), "Passwords don't match", Toast.LENGTH_LONG).show()
                }
            }else{
                AlertDialog.Builder(view.context)
                    .setTitle(getString(R.string.error))
                    .setMessage(getString(R.string.invalid_user_or_pass))
                    .setPositiveButton(getString(R.string.ok)) { dialogInterface: DialogInterface, i: Int ->
                        dialogInterface.dismiss()
                    }
                    .create()
                    .show()
            }
        }
    }
    fun signUp (fullName:String , email:String, password:String){
        println ("sing up started")
        var jsonobject : JSONObject = JSONObject()
        try {
            jsonobject.put("fullName",fullName).put("email",email).put("password",password)
            println(jsonobject)
        }catch (e: JSONException){
            e.printStackTrace()
        }
        var jsonObjectRequest =
            object : JsonObjectRequest(Request.Method.POST, "https://restapis.xyz/around-me/v1/user/register",
            jsonobject,
            object : Response.Listener<JSONObject>{
                override fun onResponse(response: JSONObject?) {
                    println(response)
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    println(error.toString())
                    Toast.makeText(requireContext(), "Email format not correct", Toast.LENGTH_LONG).show()
//                    Log.e("VOLLEY",error!!.message)
                } }){

            override fun parseNetworkResponse(response: NetworkResponse?): Response<JSONObject> {
                println (response!!.statusCode)
                if (response!!.statusCode == 200) {
                    println(200)
                    val userRepository = Injector.provideUserRepository(view!!.context)
                    val user = UserEntity(email.toString())
                    userRepository.login(user)
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.signUpFragmentWrapper, HomeFragment())
                        ?.commit()
                } else if (response!!.statusCode == 400) {
                    println(400)
                    Toast.makeText(requireContext(), "User Duplicated", Toast.LENGTH_LONG).show()
                } else {
                    println("nothing")
                    Toast.makeText(requireContext(), "Unexpected!", Toast.LENGTH_LONG).show()
                }
                return super.parseNetworkResponse(response)
            }
        }
        Volley.newRequestQueue(requireContext()).add(jsonObjectRequest)
        val retryPolicy : RetryPolicy = DefaultRetryPolicy(8000,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        jsonObjectRequest.setRetryPolicy(retryPolicy)
    }
    }
