package com.example.nian.androiddemo.mvptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nian.androiddemo.R;

/**
 * Created by niangang on 2016/5/30.
 */
public class MVPTestActiviy extends Activity implements OnClickListener, LoginContract.View {
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        presenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                presenter.isLoginResult(username.getText().toString(), password.getText().toString());
                break;
        }
    }

    @Override
    public void showSuccessToast() {

        Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clearInput() {

    }

    @Override
    public void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }
}
