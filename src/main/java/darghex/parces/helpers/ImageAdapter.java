package darghex.parces.helpers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import darghex.parces.AsignaturaActivity;
import darghex.parces.model.LauncherIcon;
import darghex.parces.R;

/**
 * Adaptador que organiza los launchericon en el datagrid
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public static List<LauncherIcon> ICONS ;


    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return ICONS.size();
    }

    @Override
    public LauncherIcon getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public Button icon;

    }

    // Modificamos la imagen por cada item del adaptador
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        final ViewHolder holder;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            v = vi.inflate(R.layout.dashboard_icon, null);
            holder = new ViewHolder();

            holder.icon = (Button) v.findViewById(R.id.btn_default );

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        //personalizamos cada item
        holder.icon.setText( ICONS.get(position).text); // texto
        final Drawable drawableTop = mContext.getResources().getDrawable(ICONS.get(position).imgId);//Imagen
        // definimos un tamaño para cada item
        //FixMe: verificar cuando la pantalla este horizontal en que se ubican 4 items
        holder.icon.setWidth( (parent.getWidth() / 2) -30 );


      //  holder.icon.setPadding(5,10,5,5);

        //holder.icon.setBackgroundColor( Color.parseColor("#E8E8E8"));

        holder.icon.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop, null, null);
        if ( ICONS.get(position).id != 0  ){
            holder.icon.setId(ICONS.get(position).id);
        }
        holder.icon.setOnClickListener( ICONS.get(position).callback ); // asociamos el evento
        return v;

    }
}