package com.example.exercise1;

import android.content.Context;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data Layout Inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data ArrayList
    private ArrayList<ClassNama> arrayList;

    //Membuat konstruktor ListViewAdapter
    public ListViewAdapter(Context context) {
        //Memberi nilai mContext dengan context
        mContext = context;

        //Mengatur LayoutInflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arrayList
        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }

    //Membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam ListView
    public class ViewHolder {
        //Mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount() mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //Mengembalikan nilai berupa jumlah data dari array data
        return HomeActivity.classNamaArrayList.size();
    }

    /*Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi tertentu
    dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi tertentu dalam pengumpulan data item.*/
    @Override
    public Object getItem(int i) {
        //Mengembalikan nilai berupa objek dari array data
        return HomeActivity.classNamaArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi item ke adapter.
    @Override
    public long getItemId(int i) {
        return i;
    }

    /*Fungsi ini secara otomatis dipanggil ketika tampilan item list siap
    untuk ditampilkan atau akan ditampilkan*/
    @Override
    public View getView(int i, View view, ViewGroup ViewGroup) {
        //Deklarasi variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //Membuat kondisi apakah view null atau tidak
        if (view == null) {
            //Membuat objek ViewHolder
            holder = new ViewHolder();

            //Mengatur Layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //Set id untuk TextView
            holder.name = (TextView) view.findViewById(R.id.tvNama_item);

            //Menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        } else {
            //Mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }

        //Set item ke TextView
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getName());

        //Mengembalikan nilai ke variabel view
        return view;
    }
}
