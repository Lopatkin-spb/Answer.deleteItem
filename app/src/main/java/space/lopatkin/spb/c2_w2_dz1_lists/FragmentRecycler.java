package space.lopatkin.spb.c2_w2_dz1_lists;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import space.lopatkin.spb.c2_w2_dz1_lists.mock.ComplexRecyclerViewAdapter;
import space.lopatkin.spb.c2_w2_dz1_lists.mock.MockImageGenerator;
import space.lopatkin.spb.c2_w2_dz1_lists.mock.MockTextGenerator;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecycler extends Fragment implements MainActivity.DataSendToFragment {
    private static final String TAG = "myLogs";
    private static FragmentRecycler fragment;
    private RecyclerView recyclerView;


    private final ComplexRecyclerViewAdapter adapter = new ComplexRecyclerViewAdapter();
    private int countText = 1;
    private int countImage = 1;
    private static List globalList = new ArrayList();


    //    фабричный метод/паттерн - передача данных во фрагмент из активити
    public static FragmentRecycler newInstance() {
        fragment = new FragmentRecycler();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        globalList.addAll(MockTextGenerator.generate(countText));
        globalList.addAll(MockImageGenerator.generate(countImage));

        recyclerView.setAdapter(adapter);
        adapter.addData(globalList);

        adapter.setListener(listener);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_text:
                try {
                    globalList.addAll(MockTextGenerator.generate(countText));
                    adapter.addData(globalList);
                } catch (Exception e) {
                }
                break;
            case R.id.add_image:
                try {
                    globalList.addAll(MockImageGenerator.generate(countImage));
                    adapter.addData(globalList);
                } catch (Exception e) {
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //блок обработки нажатия по итему
    private ComplexRecyclerViewAdapter.OnItemClickListener listener;

    //забор лисенера из активити
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ComplexRecyclerViewAdapter.OnItemClickListener) {
            listener = (ComplexRecyclerViewAdapter.OnItemClickListener) context;
        }
    }


    //зануляем лисенер после работы, облегчая работу сборщику мусора
    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }
    //блок обработки нажатия по итему


    @Override
    public void dataSendToFragment(final String s) {
        try {

            String sssss = s;
            for (int index = 0; index < globalList.size(); index++) {
                Object o = globalList.get(index);
                String str = o.toString();
                if (sssss.equals(str)) {
                    Log.d(TAG, "--------------FragmentRecycler: в цикле перед удаления-------------------");

                    globalList.remove(index);
//                    adapter.addData(globalList);


                    Log.d(TAG, "--------------FragmentRecycler: в цикле после удаления-------------------");
                }
            }

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.addData(globalList);

                }
            });


        } catch (Exception e) {
            Log.d(TAG, "интерфейс из активити в фрагменте не срабатывает", e);
        }


    } //конец метода


}
