package journal.com.journalapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.nfc.Tag;
import android.provider.Contacts;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import journal.com.journalapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions googleSignInOptions;
    private GoogleApiClient mGoogleApiClient;
    private int RC_SIGN_IN = 30;
    private DatabaseReference userData;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        userData = FirebaseDatabase.getInstance().getReference().child("Users");

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

       // mGoogleApiClient = new GoogleApiClient.Builder(this)
           //     .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
         //       .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
             //   .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        mainBinding.signinWithGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
               Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUserInterface(currentUser);
       // GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account = task.getResult(ApiException.class);
                
                firebaseAuthWithGoogle(account);
                
            }catch (ApiException e){
                Toast.makeText(this, "Failed to signIn", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential  = GoogleAuthProvider.getCredential(account.getIdToken(),null);
       mAuth.signInWithCredential(credential)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {

                       if(task.isSuccessful()){

                           FirebaseUser user = mAuth.getCurrentUser();



                           updateUserInterface(user);

                       }else{
                           Toast.makeText(MainActivity.this, "signInWithCredential:failure", Toast.LENGTH_SHORT).show();
                        updateUserInterface(null);
                       }

                   }
               });

    }

    private void updateUserInterface(FirebaseUser user) {


        if(user != null) {
            mainBinding.nameLogged.setText(user.getEmail());

            if(userData.child(user.getUid()).getDatabase() !=null) {

                Toast.makeText(this, "There is an existing information", Toast.LENGTH_SHORT).show();

            }else{ Users users = new Users(user.getUid(),user.getDisplayName(),user.getEmail(),Integer.valueOf(user.getPhoneNumber()));
                userData.child(user.getUid()).setValue(users);
            }
            Intent intent = new Intent(this,MessgaeShow.class);
            intent.putExtra("id",user.getUid());
            startActivity(intent);
        }
    }

 /*   private void handleSignInResult(GoogleSignInResult completedResults) {

        if (completedResults.isSuccess()){
            final GoogleSignInAccount account = completedResults.getSignInAccount();

            String name = account.getDisplayName();
            final String mail = account.getEmail();
            String id = account.getId();

            mainBinding.nameLogged.setText(name);

        }

    }
*/



}
