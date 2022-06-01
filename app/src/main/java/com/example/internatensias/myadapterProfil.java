package com.example.internatensias;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class myadapterProfil extends FirebaseRecyclerAdapter<profil, myadapterProfil.myviewholder>
{
    public myadapterProfil(@NonNull FirebaseRecyclerOptions<profil> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull final profil profil)
    {
        holder.name.setText(profil.getName());
        holder.adress.setText(profil.getAdress());
        holder.email.setText(profil.getEmail());
        holder.NumTel.setText(profil.getNumTel());
        holder.email.setText(profil.getEmail());

        Glide.with(holder.img.getContext()).load(profil.getPurl()).into(holder.img);



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontentprofil))
                        .setExpanded(true,1100)
                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText purl=myview.findViewById(R.id.uimgurl);
                final EditText name=myview.findViewById(R.id.unom);
                final EditText email=myview.findViewById(R.id.uemail);
                final EditText adress=myview.findViewById(R.id.uadress);
                final EditText NumTel=myview.findViewById(R.id.uNumTel);

                Button submit=myview.findViewById(R.id.usubmit);

                purl.setText(profil.getPurl());
                name.setText(profil.getName());
                email.setText(profil.getEmail());
                adress.setText(profil.getAdress());
                NumTel.setText(profil.getNumTel());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("purl",purl.getText().toString());
                        map.put("name",name.getText().toString());
                        map.put("adress",adress.getText().toString());

                        map.put("email",email.getText().toString());
                        map.put("NumTel",NumTel.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("profil")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("profil")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });

    } // End of OnBindViewMethod

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowprofil,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        ImageView edit,delete;
        TextView name,email,NumTel,adress;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img1);
            adress=(TextView)itemView.findViewById(R.id.adresstext);
            name=(TextView)itemView.findViewById(R.id.nomtext);
            email=(TextView)itemView.findViewById(R.id.emailtext);

            NumTel=(TextView)itemView.findViewById(R.id.Numteltxt);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
        }
    }
}
