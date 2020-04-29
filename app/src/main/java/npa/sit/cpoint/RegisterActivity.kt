package npa.sit.cpoint

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity: AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var mDatabase : FirebaseDatabase? = null
    private val TAG: String = "Register Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()

        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@RegisterActivity, Dashboard::class.java))
            finish()
        }
        register_registerBtn.setOnClickListener {
            val displayName = register_displaynameEditText.text.toString().trim{it <=' '}
            var email = register_emailEditText.text.toString().trim { it <= ' ' }
            var password = register_passwordEditText.text.toString().trim { it <= ' ' }

            if (email.isEmpty()) {
                toast("Please enter your email address.")
                Log.d(TAG, "Email was empty!")
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                toast("Please enter your password.")
                Log.d(TAG, "Password was empty!")
                return@setOnClickListener
            }
            mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) {
                        toast("Password too short! Please enter minimum 6 characters.")
                        Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        toast("Authentication Failed: " + task.exception!!.message)
                        Log.d(TAG, "Authentication Failed: " + task.exception!!.message)
                    }
                } else {
                    var user = mAuth!!.currentUser
                    var userId = user!!.uid
                    var userRef = mDatabase!!.reference.child("Users").child(userId)
                    var userObject = HashMap<String,String>()
                    userObject.put("display_name",displayName)
                    userObject.put("email",email)
                    userObject.put("password",password)
                    userObject.put("name","Default")
                    userObject.put("surname","Default")
                    userObject.put("status","Default")
                    userObject.put("image","Default")
                    userObject.put("thumb_img","Default")

                    userRef.setValue(userObject).addOnCompleteListener {
                        if(!task.isSuccessful)
                        toast("Create account successfully!")
                        Log.d(TAG, "Create account successfully!")
                    }

                    startActivity(Intent(this@RegisterActivity, Dashboard::class.java))
                    finish()
                }
            }

        }
        register_signinBtn.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java)) }
    }
}
