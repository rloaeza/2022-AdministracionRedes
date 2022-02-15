package mx.edu.itsuruapan.admnistracionderedes;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mx.edu.itsuruapan.admnistracionderedes.databinding.ActivityPlanesPreCorBinding;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        xi = 2,
        d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J0\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"},
        d2 = {"Lmx/edu/itsuruapan/admnistracionderedes/PlanesPreCor;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/widget/AdapterView$OnItemClickListener;", "()V", "binding", "Lmx/edu/itsuruapan/admnistracionderedes/databinding/ActivityPlanesPreCorBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "parent", "Landroid/widget/AdapterView;", "viw", "Landroid/view/View;", "position", "", "id", "", "Admnistracion_de_Redes.app"}
)
public final class planesPreCor2 extends AppCompatActivity implements OnItemClickListener {

    private ActivityPlanesPreCorBinding binding;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlanesPreCorBinding var10001 = ActivityPlanesPreCorBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var10001, "ActivityPlanesPreCorBind…g.inflate(layoutInflater)");
        this.binding = var10001;
        var10001 = this.binding;

        this.setContentView(var10001.getRoot());
        String[] var10000 = this.getResources().getStringArray(R.array.planesPrevencion);
        String[] opciones = var10000;
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_pd,opciones);
        ActivityPlanesPreCorBinding var7 = this.binding;
        if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }

        AutoCompleteTextView var4 = var7.autoCompleteTextView;
        var4.setAdapter(adapter);
        var4.setOnItemClickListener((OnItemClickListener)this);
    }

    public void onItemClick(@Nullable AdapterView parent, @Nullable View viw, int position, long id) {
        String item = String.valueOf(parent != null ? parent.getItemAtPosition(position) : null);
        Toast.makeText((Context)this, (CharSequence)item, 0).show();
    }
}
