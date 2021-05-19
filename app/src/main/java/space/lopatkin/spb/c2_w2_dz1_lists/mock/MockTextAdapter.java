package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import space.lopatkin.spb.c2_w2_dz1_lists.R;

import java.util.ArrayList;
import java.util.List;

public class MockTextAdapter extends RecyclerView.Adapter<MockTextHolder> {

//    был в начале
//    private List<Mock> mockList;

    private final List<MockText> mockTextList = new ArrayList<>();


    @NonNull
    @Override
    public MockTextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_mock_text, parent, false);

        return new MockTextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MockTextHolder holder, int position) {

        holder.bind(mockTextList.get(position));

    }

    @Override
    public int getItemCount() {
        return mockTextList.size();
    }


    //    добавили для нового листа
    public void addData(List<MockText> mockTexts) {

        mockTextList.addAll(mockTexts);
        notifyDataSetChanged();
    }


}
