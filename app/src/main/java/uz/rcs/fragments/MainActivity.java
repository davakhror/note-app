package uz.rcs.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import uz.rcs.fragments.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        BlankFragment blankFragment = new BlankFragment();
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//
//        fragmentTransaction.add(R.id.container,blankFragment);
//        fragmentTransaction.commit();
// Dastur ishga tushganda birinchi bob shu korinishi uchun.
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new BlankFragment())
                .addToBackStack("first")
                .commit();
//   Endi bu kerak emas sababi nav_graph orqali ishlaydi va birinchi bolib chiqadi app da

    }
}