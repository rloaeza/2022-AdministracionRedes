package mx.edu.itsuruapan.admnistracionderedes;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class localizacion extends AppCompatActivity {

    Button insert,get;
    ImageView imageView;
    DatabaseHelper db;
    credenciales_Usuario usuario = new credenciales_Usuario();
    String us;
    private static final int PICK_IMAGE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024);
        } catch (Exception e) {

            e.printStackTrace();

        }
        super.onCreate(savedInstanceState);
        us=usuario.getUsuarioIngresado();
        setContentView(R.layout.activity_localizacion);
        insert = (Button)findViewById(R.id.insert);
        get = (Button)findViewById(R.id.get);
        imageView = (ImageView)findViewById(R.id.imageView);

        db = new DatabaseHelper(this);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(db.getImage(us));
                if(db.getImage(us)!=null){
                    Toast.makeText(getApplicationContext(), "Realizado",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(db.getImage(us)!=null){
                    db.deletImage(us);
                }
                Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse(
                        "content://media/internal/images/media"
                ));
                startActivityForResult(intent, PICK_IMAGE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            Uri uri = data.getData();
            String x = getPath(uri);

            if(db.insertImage(x,us)){
                Toast.makeText(getApplicationContext(), "Realizado",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String getPath(Uri uri){
        if(uri==null)return null;
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri,projection,null,null,null);
        if(cursor!=null){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        return uri.getPath();
    }
}
