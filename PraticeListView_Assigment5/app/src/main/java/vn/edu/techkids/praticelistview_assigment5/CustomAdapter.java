package vn.edu.techkids.praticelistview_assigment5;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Admin on 4/14/2016.
 */
public class CustomAdapter extends ArrayAdapter<Employee> implements ObserverDetail{
    private Activity activity;
    private ArrayList<Employee> listEmployee;
    private int layoutItemId;
    private  ObserverDetail mObserverDetail;

    public void setmObserverDetail(ObserverDetail observerDetail) {
        this.mObserverDetail = observerDetail;
    }

    public CustomAdapter(Activity activity, int layoutItemId, ArrayList<Employee> listEmployee){
        super(activity, layoutItemId, listEmployee);
        //can co data, can truyen vao data
        this.activity = activity;
        this.layoutItemId = layoutItemId;
        this.listEmployee = listEmployee;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {//gan data voi Item
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        if(convertView != null){
            return convertView;
        }
        convertView  = layoutInflater.inflate(layoutItemId, null);

        ImageView avatar = (ImageView)convertView.findViewById(R.id.image);
        final TextView txtName = (TextView)convertView.findViewById(R.id.tvName1);
        TextView txtAge = (TextView)convertView.findViewById(R.id.tvAge1);
        TextView txtJob = (TextView)convertView.findViewById(R.id.tvJob);
        Button btnDetail = (Button) convertView.findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetail(position,listEmployee);

            }
        });

        ImageButton close = (ImageButton)convertView.findViewById(R.id.imageButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Employee e = listEmployee.get(position);
                listEmployee.remove(position);
                Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                //Log.d("sizeremove", String.valueOf(listEmployee.size()));

            }
        });

        txtName.setText(listEmployee.get(position).getName());
        txtAge.setText(listEmployee.get(position).getAge());
        txtJob.setText(listEmployee.get(position).getJob());


        return convertView;
    }

    @Override
    public void showDetail(int index,List<Employee> lE) {
      Employee e = lE.get(index);
        new AlertDialog.Builder(getContext())
                .setTitle("Employee Detail")
                .setMessage( e.getName() + "\n"+ e.getAge()+"\n" + e.getJob())
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no,
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(R.mipmap.hinata)
                .show();
    }

}
