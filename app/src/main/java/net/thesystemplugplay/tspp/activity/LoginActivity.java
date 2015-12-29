package net.thesystemplugplay.tspp.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import net.thesystemplugplay.tspp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.util.TypefaceManager;

/**
 * Created by kongmono on 12/28/15.
 */
public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.username)
    EditText mUsername;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.imageNext)
    ImageView mImageNext;

    private TypefaceManager fontManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        fontManager = new TypefaceManager(this.getAssets());

        mUsername.setTypeface(fontManager.getTRegular());
        mPassword.setTypeface(fontManager.getTRegular());

        mImageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mUsername.getText().toString().contentEquals("1234") && mPassword.getText().toString().contentEquals("1234")) {
                    Prefs.putBoolean("logged", true);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
