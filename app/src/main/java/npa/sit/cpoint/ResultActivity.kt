package npa.sit.cpoint

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(){
    var mAuth : FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    private val TAG: String ="Result Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mAuth = FirebaseAuth.getInstance()

        val user = mAuth!!.currentUser

        logout_logoutBtn.setOnClickListener{
            if(mAuth!=null){
                mAuth!!.signOut()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }


    }

}