package uz.rcs.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import uz.rcs.fragments.adapters.NotesAdapter;
import uz.rcs.fragments.databinding.FragmentNotesBinding;
import uz.rcs.fragments.models.Note;
import uz.rcs.fragments.utils.MyShared;

public class NotesFragment extends Fragment {

    private List<Note> noteList = new ArrayList<>();
    private NotesAdapter notesAdapter;
    private MyShared myShared;



    private FragmentNotesBinding binding;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        loadNotes();
        notesAdapter = new NotesAdapter(noteList, new NotesAdapter.Callback() {
            @Override
            public void onDeleteClicked(Note note) {
                noteList.remove(note);
                myShared.putList("notes", noteList);
                notesAdapter.notifyDataSetChanged();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        binding.rvNotes.setLayoutManager(linearLayoutManager);
        binding.rvNotes.setAdapter(notesAdapter);
    }

    private void loadNotes() {
        myShared = new MyShared(requireContext(), new Gson());
        noteList = myShared.getList("notes", Note.class);
    }
}