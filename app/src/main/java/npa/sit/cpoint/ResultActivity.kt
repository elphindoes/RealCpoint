package npa.sit.cpoint

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
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

        result_emailData.text = user!!.email
        result_uidData.text = user!!.uid



        logout_logoutBtn.setOnClickListener{
            if(mAuth!=null){
                mAuth!!.signOut()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }


    }

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener { mAuthListener }
    }
    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) { mAuth!!.removeAuthStateListener { mAuthListener } }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) { moveTaskToBack(true) }
        return super.onKeyDown(keyCode, event)
    }
}