package uz.rcs.fragments.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uz.rcs.fragments.R;
import uz.rcs.fragments.models.Note;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private List<Note> notesList;
    private Callback listener;

    public NotesAdapter(List<Note> notesList, Callback listener) {
        this.notesList = notesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(notesList.get(position).getTitle());
        holder.tvDescription.setText(notesList.get(position).getDescription());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeleteClicked(notesList.get(position));


            }
        });

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView tvTitle, tvDescription;
        AppCompatButton btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //ItemTopicBinding.bind(itemView.getRootView())
            tvTitle = (AppCompatTextView) itemView.findViewById(R.id.tv_title);
            tvDescription = (AppCompatTextView) itemView.findViewById(R.id.tv_description);
            btnDelete = itemView.findViewById(R.id.btn_delete);


        }
    }

    public interface Callback {
        public void onDeleteClicked(Note note);
    }
}


