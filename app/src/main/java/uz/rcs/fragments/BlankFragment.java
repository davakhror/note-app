package uz.rcs.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import uz.rcs.fragments.databinding.FragmentBlankBinding;
import uz.rcs.fragments.models.Note;
import uz.rcs.fragments.utils.MyShared;


public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    private FragmentBlankBinding binding;
    private MyShared myShared;

    private List<Note> notes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(getLayoutInflater(), container, false);

        initUI();
        return binding.getRoot();

    }

    private void initUI() {
        myShared = new MyShared(requireContext(), new Gson());
        notes = new ArrayList<>();

        // Note dan ma'lumotlar olyabmiz myShared orqali(getlist).
        try {
            notes.addAll(myShared.getList("notes", Note.class));
        } catch (Exception e) {

        }


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show();


                if (
                        binding.etTitle.getText().toString() == "" &&
                                binding.etDescription.getText().toString() == ""

                ) {
                    // new dan keyin har doim katta harf bilan yoziladi (Class Nomi)
                    notes.add(new Note(binding.etTitle.getText().toString(),
                            binding.etDescription.getText().toString()));
                    myShared.putList("notes", notes);

                    binding.etTitle.setText("");
                    binding.etDescription.setText("");
                } else
                    Toast.makeText(requireContext(),
                            "ILTIMOS MALUMOT KIRITING", Toast.LENGTH_SHORT).show();


            }
        });


        binding.btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotesFragment notesFragment = new NotesFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, notesFragment)
                        .addToBackStack("SECOND")
                        .commit();
            }
        });
    }

}