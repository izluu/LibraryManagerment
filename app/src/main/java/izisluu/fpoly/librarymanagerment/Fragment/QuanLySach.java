package izisluu.fpoly.librarymanagerment.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import izisluu.fpoly.librarymanagerment.Adapter.AdapterSach;
import izisluu.fpoly.librarymanagerment.DAO.LoaiSachDAO;
import izisluu.fpoly.librarymanagerment.DAO.SachDAO;
import izisluu.fpoly.librarymanagerment.Model.LoaiSach;
import izisluu.fpoly.librarymanagerment.Model.Sach;
import izisluu.fpoly.librarymanagerment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanLySach#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanLySach extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rcvSach;
    private AdapterSach adapter;
    private FloatingActionButton btnAddSach;
    private ArrayList<Sach> list = new ArrayList<>();
    private SachDAO dao;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuanLySach() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuanLySach.
     */
    // TODO: Rename and change types and number of parameters
    public static QuanLySach newInstance(String param1, String param2) {
        QuanLySach fragment = new QuanLySach();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quan_ly_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        dao = new SachDAO(getContext());
        list = dao.getAll();
        rcvSach = view.findViewById(R.id.RCVSach);
        btnAddSach = view.findViewById(R.id.btnAddSach);
        adapter = new AdapterSach(getContext(),list);
        rcvSach.setAdapter(adapter);
        rcvSach.setLayoutManager(new LinearLayoutManager(getContext()));
        btnAddSach.setOnClickListener(v -> {
            openDialog();
        });

    }
    public void openDialog(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_sach,null);
        builder.setView(view);

        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
        TextInputLayout edtAddMS = view.findViewById(R.id.edtAddMS);
        TextInputLayout edtAddTenSach = view.findViewById(R.id.edtAddTenSach);
        TextInputLayout edtAddTacGia = view.findViewById(R.id.edtAddTacGia);
        TextInputLayout edtAddSoTien = view.findViewById(R.id.edtAddSoTien);
        Spinner spnTenLoai = view.findViewById(R.id.spnTenLoai);
        View btnCancel = view.findViewById(R.id.btnCancel);
        View btnSave = view.findViewById(R.id.btnSave);
        LoaiSachDAO loaiSachDAO = new LoaiSachDAO(getContext());
        ArrayList<LoaiSach> listLS = loaiSachDAO.getAll();
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,listLS);
        spnTenLoai.setAdapter(adapter);
        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnSave.setOnClickListener(v -> {
            String maSach = edtAddMS.getEditText().getText().toString();
            String tenSach = edtAddTenSach.getEditText().getText().toString();
            String tacGia = edtAddTacGia.getEditText().getText().toString();
            String giaTien = edtAddSoTien.getEditText().getText().toString();
            LoaiSach ls = (LoaiSach) spnTenLoai.getSelectedItem();
            String maLoaiSach = ls.getMaLoaiSach();
            Sach sach = new Sach(maSach,maLoaiSach,tenSach,tacGia,giaTien);
            list.clear();
            list.addAll(dao.getAll());
            dao.insert(sach);

            adapter.notifyDataSetChanged();
            dialog.dismiss();
        });




    }
}