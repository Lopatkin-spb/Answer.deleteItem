package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import space.lopatkin.spb.c2_w2_dz1_lists.R;


public class MockTextHolder extends RecyclerView.ViewHolder {
public static final String TAG = "myLogs";
    private TextView name;
    private TextView value;


    public MockTextHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.text_view_name);
        value = itemView.findViewById(R.id.text_view_value);
    }

    public void bind(MockText mockText) {
        name.setText(mockText.getName());
        value.setText(mockText.getValue());
    }

    public void setListener(final ComplexRecyclerViewAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick (View view){
                try {
                    listener.onItemClick((String) value.getText());

                } catch (Exception e) {
                    Log.d(TAG, "MockTextHolder setListener : нажать на вью (логика в активити) нельзя", e);

                    e.printStackTrace();
                }


            }



        });
    }


}
