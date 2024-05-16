package com.brian.project101.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.brian.project101.navigation.ROUTE_HOME
import com.brian.project101.navigation.ROUTE_LOGIN
import com.brian.project101.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(private var navController: NavHostController, private var context: Context){

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    //private val progress: ProgressDialog = ProgressDialog(context)

    init {
        // progress.setTitle("Loading")
        //  progress.setMessage("PLease Wait.....")
    }
    fun signup(email:String,pass:String,confpass:String){
        //  progress.show()

        if (email.isBlank() || pass.isBlank() ||confpass.isBlank()){
            //     progress.dismiss()
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener { it->
                if (it.isSuccessful){
                    val userdata=
                        com.brian.project101.model.User(email, pass, mAuth.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER)
                }

            } }

    }
    fun login(email: String,pass: String){
        // progress.show()

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            //   progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}