//package com.example.lawfirmapp.Adapters;
//
//import com.example.lawfirmapp.R;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//public class CustomSpinnerAdapter extends ArrayAdapter<String> {
//    private List<String> objects;
//    private Context context;
//
//    public CustomSpinnerAdapter(@NonNull @NotNull Context context, int resource, List<String> objects) {
//        super(context, resource);
//        this.objects = objects;
//        this.context = context;
//    }
//
//    //   LayoutInflater layoutInflater =
//
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        View view = null;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        if (convertView == null) {
//            view = inflater.inflate(R.layout.spinner_item_layout, parent, false);
//        } else {
//            view = convertView;
//        }
//
//        getItem(position);
//
//        return super.getView(position, convertView, parent);
//
//
//    }
//
////    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
////        val view: View
////        if (convertView == null) {
////            view = layoutInflater.inflate(R.layout.item_country, parent, false)
////        } else {
////            view = convertView
////        }
////        getItem(position)?.let { country ->
////                setItemForCountry(view, country)
////        }
////        return view
//
//
//
////override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
////        val view: View
////        if (position == 0) {
////            view = layoutInflater.inflate(R.layout.header_country, parent, false)
////            view.setOnClickListener {
////                val root = parent.rootView
////                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
////                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
////            }
////        } else {
////            view = layoutInflater.inflate(R.layout.item_country_dropdown, parent, false)
////            getItem(position)?.let { country ->
////                    setItemForCountry(view, country)
////            }
////        }
////        return view
////    }
//    @Override
//    public View getDropDownView(int position, @Nullable @org.jetbrains.annotations.Nullable View convertView, @NonNull @NotNull ViewGroup parent) {
//
//        View view = null;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        if (position == 0){
////            view = inflater.inflate(R.layout.)
//        }else{
//
//        }
//
//        return super.getDropDownView(position, convertView, parent);
//    }
//
//
//    @Nullable
//    @Override
//    public String getItem(int position) {
//        if (position == 0) {
//            return null;
//        }
//        return super.getItem(position - 1);
//    }
//
//    @Override
//    public int getCount() {
//        return super.getCount() + 1;
//    }
//
//    @Override
//    public boolean isEnabled(int position) {
//        return position != 0;
//    }
//
//    private void setItemForSpinner(View view, String data) {
//        TextView spinnerTV = view.findViewById(R.id.spinnerTV);
//        spinnerTV.setText(data);
//    }
//
//}