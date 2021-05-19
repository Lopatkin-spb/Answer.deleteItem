package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import space.lopatkin.spb.c2_w2_dz1_lists.R;

import java.util.ArrayList;
import java.util.List;

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "myLogs";

    private List listGlobalItems = new ArrayList();
    private final int TEXT = 0, IMAGE = 1;
    private OnItemClickListener listener;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TEXT:
                View viewText = layoutInflater.inflate(R.layout.list_item_mock_text, parent, false);
                viewHolder = new MockTextHolder(viewText);
                break;
            case IMAGE:
                View viewImage = layoutInflater.inflate(R.layout.list_item_mock_image, parent, false);
                viewHolder = new MockImageHolder(viewImage);
                break;
            default:
//                добавить простейший холдер
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TEXT:
                MockTextHolder holderText = (MockTextHolder) holder;
                holderText.bind((MockText) listGlobalItems.get(position));
                holderText.setListener(listener);

                break;
            case IMAGE:
                MockImageHolder holderImage = (MockImageHolder) holder;
                holderImage.bind((MockImage) listGlobalItems.get(position));
                break;
            default:
//                дефолтный простой холдер
                break;
        }

//        h.setListener(listener);


    }

    @Override
    public int getItemCount() {
        return listGlobalItems.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (listGlobalItems.get(position) instanceof MockText) {
            return TEXT;
        } else if (listGlobalItems.get(position) instanceof MockImage) {
            return IMAGE;
        }
        return -1;
    }


//    private void configureHolderText(MockTextHolder mockTextHolder, int position) {
//        MockText mockText = (MockText) listGlobalItems.get(position);
//        if (mockText != null) {
//            mockText.getName()
//        }
//
//
//
//    }

    public void addData(List list) {
        listGlobalItems.clear();
        listGlobalItems.addAll(list);

        notifyDataSetChanged();
        Log.d(TAG, "--------------ComplexRecyclerViewAdapter: после notifyDataSetChanged-------------------");

    }




    public void addData2(List list) {
        listGlobalItems.clear();
        listGlobalItems.addAll(list);
        notifyItemInserted(listGlobalItems.size());
        notifyDataSetChanged();


    }



//    oбработка нажатия итема
    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(String id);

    }


}
