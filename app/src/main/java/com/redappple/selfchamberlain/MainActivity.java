package com.redappple.selfchamberlain;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MainActivity extends ActionBarActivity  {

    private static final String S_iniName="UserInfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefault();
        Button btn_login =(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context ctx = MainActivity.this;
                SharedPreferences sp = ctx.getSharedPreferences(S_iniName, MODE_PRIVATE);
                //¥Ê»Î ˝æ›
                SharedPreferences.Editor editor = sp.edit();
                EditText tb_LoginName=(EditText)findViewById(R.id.tb_loginName);
                EditText tb_Pwd=(EditText)findViewById(R.id.tb_Pwd);
                editor.putString("LoginName", tb_LoginName.getText().toString());
                editor.putString("LoginPwd", tb_Pwd.getText().toString());
                editor.putInt("INT_KEY", 0);
                editor.putBoolean("BOOLEAN_KEY", true);
                editor.commit();
                new AlertDialog.Builder(ctx)
                        .setTitle("Info")
                        .setMessage("Welcome"+tb_LoginName.getText())
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    private void setDefault() {
        Context ctx = MainActivity.this;
        SharedPreferences sp = ctx.getSharedPreferences(S_iniName, MODE_PRIVATE);
        EditText tb_LoginName=(EditText)findViewById(R.id.tb_loginName);
        EditText tb_Pwd=(EditText)findViewById(R.id.tb_Pwd);
        tb_LoginName.setText(sp.getString("LoginName", ""));
        tb_Pwd.setText(sp.getString("LoginPwd", ""));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
