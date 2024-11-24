package izisluu.fpoly.librarymanagerment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import izisluu.fpoly.librarymanagerment.Model.Sach;
import izisluu.fpoly.librarymanagerment.R;

public class AdapterSach extends RecyclerView.Adapter<AdapterSach.SachViewHolder> {
    private Context context;
    private ArrayList<Sach> list;
    public AdapterSach(Context context, ArrayList<Sach> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.customrcv_sach,parent,false);
        return new SachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SachViewHolder holder, int position) {
        Sach sach = list.get(position);
        holder.tvMS.setText(sach.getMaSach());
        holder.tvTen.setText(sach.getTenSach());
        holder.tvGiaTien.setText(sach.getGiaTien());
        holder.tvTenLoai.setText(sach.getTenLoaiSach());
        holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class SachViewHolder extends RecyclerView.ViewHolder{
        TextView tvMS, tvTen, tvGiaTien, tvTenLoai;
        ImageView btnEdit, btnDelete;
        public SachViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMS = itemView.findViewById(R.id.tvMS);
            tvTen = itemView.findViewById(R.id.tvTen);
            tvGiaTien = itemView.findViewById(R.id.tvGiaTien);
            tvTenLoai = itemView.findViewById(R.id.tvTenLoai);
            btnEdit = itemView.findViewById(R.id.btnEditSach);
            btnDelete = itemView.findViewById(R.id.btnDeleteSach);
        }
    }
}
