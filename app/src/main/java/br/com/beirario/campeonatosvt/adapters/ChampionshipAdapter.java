package br.com.beirario.campeonatosvt.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatovt.R;

public class ChampionshipAdapter extends RecyclerView.Adapter<TextViewViewHolder> {

    private List<Championship> championships = Program.getInstance().getChampionships();

    @NonNull
    @Override
    public TextViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.textview_list_item, viewGroup, false);
        return new TextViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewViewHolder holder, int i) {
        holder.textView.setText(championships.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return championships.size();
    }
}

class TextViewViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    TextViewViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }

}
