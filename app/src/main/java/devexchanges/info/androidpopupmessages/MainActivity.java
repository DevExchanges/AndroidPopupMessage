package devexchanges.info.androidpopupmessages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSingle;
    private Button btnMultiple;
    private Button btn3Alert;
    private Button btnToast;

    private void findViews() {
        btnSingle = (Button) findViewById(R.id.btn_single);
        btnMultiple = (Button) findViewById(R.id.btn_multiple);
        btn3Alert = (Button) findViewById(R.id.btn_3_alert);
        btnToast = (Button) findViewById(R.id.btn_toast);

        btnSingle.setOnClickListener(this);
        btnMultiple.setOnClickListener(this);
        btn3Alert.setOnClickListener(this);
        btnToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnMultiple) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //Set title for AlertDialog
            builder.setTitle("Dialog with 2 Buttons");

            //Set body message of Dialog
            builder.setMessage("See Android tuts at DevExchanges.info");

            // Is dismiss when touching outside?
            builder.setCancelable(true);

            //Positive Button and it onClicked event listener
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, "Positive Button clicked!", Toast.LENGTH_SHORT).show();
                        }
                    });

            //Negative Button
            builder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Usually, negative use to close Dialog
                            //So, do nothing here, just dismiss it
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else if (v == btnSingle) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //Set title for AlertDialog
            builder.setTitle("Dialog with 1 Buttons");

            //Set body message of Dialog
            builder.setMessage("See Android tuts at DevExchanges.info");

            //// Is dismiss when touching outside?
            builder.setCancelable(true);

            //Negative Button
            builder.setNegativeButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Usually, negative use to close Dialog
                            //So, do nothing here, just dismiss it
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else if (v == btn3Alert) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //Set title for AlertDialog
            builder.setTitle("Dialog with 3 Buttons");

            //Set body message of Dialog
            builder.setMessage("See Android tuts at DevExchanges.info");

            //// Is dismiss when touching outside?
            builder.setCancelable(true);

            //Positive Button and it onClicked event listener
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Invoke Positive event
                            Toast.makeText(MainActivity.this, "Positive Button clicked!", Toast.LENGTH_SHORT).show();
                            btn3Alert.setText("Showed!"); //change Button Text
                        }
                    });

            //Negative Button
            builder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Usually, negative use to close Dialog. So, do nothing here, just dismiss it
                            Toast.makeText(MainActivity.this, "Negative Button clicked!", Toast.LENGTH_SHORT).show();
                        }
                    });

            //Neutral Button
            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Usually, negative use to close Dialog. So, do nothing here, just dismiss it
                    Toast.makeText(MainActivity.this, "Neutral Button clicked!", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else if (v == btnToast) {
            Toast.makeText(this, "This is a Toast message!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
}
