package space.lopatkin.spb.c2_w2_dz1_lists;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import space.lopatkin.spb.c2_w2_dz1_lists.mock.ComplexRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements ComplexRecyclerViewAdapter.OnItemClickListener {


//    -recycler view на активитти или фрагменте---work
//-сделать адаптер и холдер для текста с заглушкой---
    // -добавить text адаптер через лайнер лейаут манагер---work
//-сделать картинку: сущность, генератор, разметку, холдер, адаптер---work
//   -совместить два типа в ресайклерВью---w
//    -добавить разделители---w
//    -2 кнопки в тулбаре---w
//    -логика кнопок: добавление нового елемента в конец списка---w

//            -логика при нажатии на елемент списка: удаление его


    //            -рес вью должен поддерживать работу двух разных типов:
//    -для каждого типа свой viewHolder и свой класс обьекта
//    -viewHolder должны быть легко различимы на глаз
//-при запуске АРР в recycler view должно быть по 1 елементу каждого типа
//    -в меню тулбара должны быть 2 кнопки из любых иконок
//            -логика кнопок: добавление 1 елемента в конец списка
//            -логика при нажатии на елемент списка: удаление его
//
//            добавочные
//    -при повороте список должен быть такой же как до поворота
//            -логика прокручивания екрана: список прокручивается до нового елемента
//            (видимость нового елемента)---w

    private static final String TAG = "myLogs";
    private FragmentRecycler fragment = new FragmentRecycler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//          создание екрана только один раз при включении
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment.newInstance())
                    .commit();
        }

//        непонятная махинация чтобы не было наллпоинтерексепшин у интерфейса для фрагмента
//        FragmentRecycler fragment = new FragmentRecycler();
        if (fragment instanceof DataSendToFragment) {
            dataSendToFragment = fragment;
        }
    }

    //    логика нажатия на елемент ресайклерВью
    @Override
    public void onItemClick(String id) {
        try {
            Log.d(TAG, "--------------activity onItemClick: id for fragment -" + id + "---------------");

            dataSendToFragment.dataSendToFragment(id);

        } catch (Exception e) {
            Log.d(TAG, "нажать на вью (логика в активити) нельзя", e);

        }

    }


    private DataSendToFragment dataSendToFragment;

    public interface DataSendToFragment {
        void dataSendToFragment(String s);
    }


}