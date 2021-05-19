package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import space.lopatkin.spb.c2_w2_dz1_lists.R;

public class MockImageHolder extends RecyclerView.ViewHolder {

    private ImageView name;

    public MockImageHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.image_view);
    }

    public void bind(MockImage mockImage) {
        name.setImageResource(mockImage.getResource());
    }
}
