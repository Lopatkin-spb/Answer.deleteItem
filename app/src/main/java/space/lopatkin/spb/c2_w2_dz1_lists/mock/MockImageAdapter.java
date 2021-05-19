package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import space.lopatkin.spb.c2_w2_dz1_lists.R;

import java.util.ArrayList;
import java.util.List;

public class MockImageAdapter extends RecyclerView.Adapter<MockImageHolder> {

    private final List<MockImage> images = new ArrayList<>();


    @NonNull
    @Override
    public MockImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_mock_image, parent, false);

        return new MockImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MockImageHolder holder, int position) {
        holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }



    public void addData(List<MockImage> mockImageList){
        images.addAll(mockImageList);
        notifyDataSetChanged();
    }




}
