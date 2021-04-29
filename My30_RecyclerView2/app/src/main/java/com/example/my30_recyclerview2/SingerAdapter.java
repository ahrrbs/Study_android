package com.example.my30_recyclerview2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SingerAdapter extends
        RecyclerView.Adapter<SingerAdapter.ViewHolder> implements OnSingerItemClickListener{
    private static final String TAG = "main:SingerAdapter";

    //리스너 선언
    OnSingerItemClickListener listener;

    // 메인에서 넘겨 받는것
    ArrayList<SingerDTO> dtos;
    Context context;

    LayoutInflater inflater;

    public SingerAdapter(ArrayList<SingerDTO> dtos, Context context) {
        this.dtos = dtos;
        this.context = context;

        inflater = LayoutInflater.from(this.context);
    }

    // 화면을 인플레이트 시킨다
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.singerview,
                parent, false);
        return new ViewHolder(itemView, this);
    }

    // 인플레이트 시킨 화면에 데이터를 셋팅시킨다
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);

        SingerDTO dto = dtos.get(position);
        // 뷰홀더에 만들어 놓은 setDto에 선택된 dto를 넘긴다
        holder.setDto(dto);
        
        //쓰레기통 클릭하여 삭제
        holder.ivTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDto(position);
                notifyDataSetChanged();
            }
        });
        
        //항목을 클릭하면 그 항목 dto를 가져올 수 있다.
    /*    holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingerDTO dto1 = dtos.get(position);
                Toast.makeText(context, "이름 : " + dto1.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }

    // ArrayList<SingerDto>에 dto를 추가할수 있도록 매소드를 만든다
    public void addDto(SingerDTO dto){
        dtos.add(dto);
    }

    // ArrayList<SingerDto>에 특정위치에 dto를 제거할수 있도록 매소드를 만든다
    public void removeDto(int position){
        dtos.remove(position);
    }

    public SingerDTO getItem(int position){
        return dtos.get(position);
    }


    public void setOnItemClickListener(OnSingerItemClickListener listener){
        this.listener = listener;
    }
    
    // 인터페이스에 정의된 매소드 구현

    @Override
    public void onItemClick(ViewHolder holderm, View view, int position) {
        if(listener != null) {
            listener.onItemClick(holderm, view, position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        // singerview에 있는 모든 위젯을 정의한다
        TextView tvName, tvMobile;
        ImageView ivImage, ivTrash;
        LinearLayout parentLayout;

        

        // singerview에 정의한 아이디와 연결시킨다 (생성자)
        public ViewHolder(@NonNull View itemView, OnSingerItemClickListener listener) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            tvName = itemView.findViewById(R.id.tvName);
            tvMobile = itemView.findViewById(R.id.tvMobile);
            ivImage = itemView.findViewById(R.id.ivImage);
            ivTrash = itemView.findViewById(R.id.ivTrash);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        // 함수를 만들어서 singerview에 데이터를 셋팅시킨다.
        public void setDto(SingerDTO dto){
            tvName.setText(dto.getName());
            tvMobile.setText(dto.getMobile());
            ivImage.setImageResource(dto.getResId());
        }


    }

}
