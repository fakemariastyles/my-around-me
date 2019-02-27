package com.workshop.aroundme.app.ui.login


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.workshop.aroundme.R
import com.workshop.aroundme.app.Injector
import com.workshop.aroundme.app.ui.home.HomeFragment
import com.workshop.aroundme.data.model.UserEntity
import org.json.JSONException
import org.json.JSONObject
import com.android.volley.toolbox.Volley
import com.workshop.aroundme.app.ui.signup.SignUpActivityWrapper
import com.workshop.aroundme.app.ui.signup.SignUpFragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    @SuppressLint("ApplySharedPref")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.signUp).setOnClickListener({
            val intet : Intent = Intent(requireContext(),SignUpActivityWrapper::class.java)
            startActivity(intet)
        })


        val usernameEditText = view.findViewById<EditText>(R.id.username)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        view.findViewById<View>(R.id.login).setOnClickListener {

            if (usernameEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                login(usernameEditText.text.toString(), passwordEditText.text.toString())
            } else {
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

    fun login(username: String, password: String) {
//        println("here")
        var jsonobject: JSONObject = JSONObject()
        try {
            jsonobject.put("email", username.toLowerCase()).put("password", password)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        var jsonObjectRequest =
            object : JsonObjectRequest(Request.Method.POST, "https://restapis.xyz/around-me/v1/user/login",
                jsonobject, object : Response.Listener<JSONObject> {
                    override fun onResponse(response: JSONObject?) {}}
                , object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {} }) {
                override fun parseNetworkResponse(response: NetworkResponse?): Response<JSONObject> {
                    println("started")
                    if (response!!.statusCode == 200) {
                        println(200)
                        val userRepository = Injector.provideUserRepository(view!!.context)
                        val user = UserEntity(username.toString())
                        userRepository.login(user)
                        fragmentManager?.beginTransaction()
                            ?.replace(R.id.content_frame, HomeFragment())
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
        val retryPolicy : RetryPolicy = DefaultRetryPolicy(8000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        jsonObjectRequest.setRetryPolicy(retryPolicy)
    }

}
