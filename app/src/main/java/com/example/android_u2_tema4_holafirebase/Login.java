package com.example.android_u2_tema4_holafirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @BindView(R.id.btnlogin)
    Button btnlogin;
    @BindView(R.id.edtuser)
    TextInputEditText edtuser;
    @BindView(R.id.edtpass)
    TextInputEditText edtpass;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterProducto adaptador;
    private ArrayList<Usuario> misdatos;
    private static final String PATH_USUARIO = "USUARIOS";

    FirebaseDatabase database;
    DatabaseReference reference;
    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        database = FirebaseDatabase.getInstance();
        reference = FirebaseDatabase.getInstance().getReference(PATH_USUARIO);
        misdatos = new ArrayList<>();

        Validar();
    }

    void Validar() {
        reference.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Usuario usuario = dataSnapshot.getValue(Usuario.class);
                usuario.setId(dataSnapshot.getKey());
                if (!misdatos.contains(usuario)) {
                    misdatos.add(usuario);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.btnlogin)
    public void onViewClicked() {

        for (int i = 0; i < misdatos.size(); i++) {
            if (misdatos.get(i).getUsuario().equals(edtuser.getText().toString()) && misdatos.get(i).getContraseña().equals(edtpass.getText().toString())) {
                Log.i("iteracion", edtuser.getText().toString() + " = " + misdatos.get(i).getUsuario());
                startActivity(new Intent(Login.this, MainActivity.class));

            } else {
                Toast.makeText(Login.this, "Intentelo de nuevo", Toast.LENGTH_LONG).show();
                Log.i("fallido", "El usuario y/o contrasena no es correcto");
            }
        }
    }
}
