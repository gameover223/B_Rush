package com.team_brush.b_rush.activities.TicketDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.team_brush.b_rush.R;

public class TicketDetailActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);

        imageView = findViewById(R.id.qr_image);
        QRCode();
    }

    public void QRCode() {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode("Ticket 1", BarcodeFormat.QR_CODE, 350, 350);
            Bitmap bitMap = Bitmap.createBitmap(350, 350, Bitmap.Config.RGB_565);

            for(int x = 0; x < 350; x++) {
                for(int y = 0; y < 350; y++) {
                    bitMap.setPixel(x, y, bitMatrix.get(x,y) ? Color.BLACK : Color.WHITE);
                }
            }

            imageView.setImageBitmap(bitMap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}