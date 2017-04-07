package nhatto.com;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnShow;
    private Button btnShowAlert;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = (Button) findViewById(R.id.btn_show_dialog);
        btnShowAlert = (Button) findViewById(R.id.btn_show_alertDialog);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nhatto.com");
        builder.setMessage("Bạn có muốn đăng xuất không!");

        builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bạn đã đăng xuất thành công!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void showDialog() {
        dialog = new Dialog(this);
        dialog.setTitle("Nhatto.com");
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        Button btnDongY = (Button) dialog.findViewById(R.id.btn_dongy);
        Button btnKhong = (Button) dialog.findViewById(R.id.btn_khong);

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bạn đã đăng xuất thành công!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
