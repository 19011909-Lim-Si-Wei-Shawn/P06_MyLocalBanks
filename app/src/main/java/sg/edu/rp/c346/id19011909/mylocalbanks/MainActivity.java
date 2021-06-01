package sg.edu.rp.c346.id19011909.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creating Variable,
    TextView tvOptionDBS;
    TextView tvOptionOCBC;
    TextView tvOptionUOB;

    String Selected = "";



    //----------------------------------------------------------------------------------------------\\



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Variable,
        tvOptionDBS = findViewById(R.id.tvDBS);
        tvOptionOCBC = findViewById(R.id.tvOCBC);
        tvOptionUOB = findViewById(R.id.tvUOB);

        //Setting Action,
        registerForContextMenu(tvOptionDBS);
        registerForContextMenu(tvOptionOCBC);
        registerForContextMenu(tvOptionUOB);
    }



    //----------------------------------------------------------------------------------------------\\



    //Displaying Dropdown List {Option},
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    //Displaying Dropdown List {Context},
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Inflating Menu,
        getMenuInflater().inflate(R.menu.menu, menu);

        //Setting Selected Information,
        if(v == tvOptionDBS)
        {   Selected = "DBS";       }

        else if(v == tvOptionOCBC)
        {   Selected = "OCBC";      }

        else if(v == tvOptionUOB)
        {   Selected = "UOB";       }

    }



    //----------------------------------------------------------------------------------------------\\



    //Translating Language,
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvOptionDBS.setText(R.string.DBSbank);
            tvOptionOCBC.setText(R.string.OCBCbank);
            tvOptionUOB.setText(R.string.UOBbank);

            return true;
        } else if (id == R.id.ChineseSelection) {
            tvOptionDBS.setText(R.string.CDBSbank);
            tvOptionOCBC.setText(R.string.COCBCbank);
            tvOptionUOB.setText(R.string.CUOBbank);

            return true;
        } else {
            tvOptionDBS.setText("Error translation");
            tvOptionOCBC.setText("Error translation");
            tvOptionUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    //Setting Options Selected,
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (Selected.equalsIgnoreCase("DBS")) {
            if (id == R.id.Website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.EDBSbank)));
                startActivity(intent);

                return true;
            } else if (id == R.id.Contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.DBSbankC)));
                startActivity(intentCall);

                return true;
            } else if (id == R.id.FavBank) {
                if(tvOptionDBS.getCurrentTextColor() == Color.RED) {
                    tvOptionDBS.setTextColor(Color.BLACK);
                }
                else
                {   tvOptionDBS.setTextColor(Color.RED);        }


            }

        }

        else if(Selected.equalsIgnoreCase("OCBC"))
        {
            if (id == R.id.Website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.EOCBCbank)));
                startActivity(intent);

                return true;
            } else if (id == R.id.Contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.OCBCbankC)));
                startActivity(intentCall);

                return true;
            } else if (id == R.id.FavBank) {
                if (tvOptionOCBC.getCurrentTextColor() == Color.RED) {
                    tvOptionOCBC.setTextColor(Color.BLACK);
                } else {
                    tvOptionOCBC.setTextColor(Color.RED);
                }

            }
        }

        else if(Selected.equalsIgnoreCase("UOB"))
        {
            if (id == R.id.Website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.EUOBbank)));
                startActivity(intent);

                return true;
            } else if (id == R.id.Contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.UOBbankC)));
                startActivity(intentCall);

                return true;
            } else if (id == R.id.FavBank) {
                if (tvOptionUOB.getCurrentTextColor() == Color.RED) {
                    tvOptionUOB.setTextColor(Color.BLACK);
                } else {
                    tvOptionUOB.setTextColor(Color.RED);
                }
            }
        }

        return super.onOptionsItemSelected(item);

    }
}