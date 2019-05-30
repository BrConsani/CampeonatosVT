package br.com.beirario.campeonatosvt.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.beirario.campeonatosvt.interfaces.Listener;
import br.com.beirario.campeonatovt.R;

public abstract class OneLineAdapter<T> extends RecyclerView.Adapter<OneLineViewHolder>
        implements Listener.onClickListener {

    private List<T> items;

    OneLineAdapter(List<T> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public OneLineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.textview_list_item, viewGroup, false);
        return new OneLineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneLineViewHolder holder, int i) {
        holder.textView.setText(items.get(i).toString());
        holder.parent.setOnClickListener((view) -> this.onClick(view, i));
        holder.parent.setOnLongClickListener((view -> this.onLongClick(view, i)));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class OneLineViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    View parent;

    OneLineViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        parent = itemView;
    }

}
