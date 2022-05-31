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


public class myadapterProfil extends FirebaseRecyclerAdapter<demande, myadapterProfil.myviewholder>
{
    public myadapterProfil(@NonNull FirebaseRecyclerOptions<demande> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull final demande demande)
    {
        holder.nom.setText(demande.getNom());
        holder.email.setText(demande.getEmail());
        holder.NumTel.setText(demande.getNumTel());
        holder.Content.setText(demande.getContent());




        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontentdemande))
                        .setExpanded(true,1100)
                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText content=myview.findViewById(R.id.contenturl);
                final EditText nom=myview.findViewById(R.id.unom);
                final EditText email=myview.findViewById(R.id.uemail);
                final EditText NumTel=myview.findViewById(R.id.uNumTel);

                Button submit=myview.findViewById(R.id.usubmit);

                content.setText(demande.getContent());
                nom.setText(demande.getNom());
                email.setText(demande.getEmail());
                NumTel.setText(demande.getNumTel());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("content",content.getText().toString());
                        map.put("nom",nom.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("NumTel",NumTel.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("DemandeBenef")
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
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.Content.getContext());
                builder.setTitle("Supprimer");
                builder.setMessage("Supprimer?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("DemandeBenef")
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdemande,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        ImageView edit,delete;
        TextView nom,email,NumTel,Content;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            nom=(TextView)itemView.findViewById(R.id.nomtext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
            NumTel=(TextView)itemView.findViewById(R.id.Numteltxt);
            Content=(TextView)itemView.findViewById(R.id.contenttext);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
        }
    }
}
