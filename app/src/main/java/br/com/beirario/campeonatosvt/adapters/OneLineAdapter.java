package br.com.beirario.campeonatosvt.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.beirario.campeonatovt.R;

public class OneLineAdapter<T> extends RecyclerView.Adapter<OneLineViewHolder> {

    private List<T> items;
    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;

    public OneLineAdapter(List<T> items, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        this.items = items;
        this.onClickListener = onClickListener;
        this.onLongClickListener = onLongClickListener;
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
        holder.parent.setOnClickListener(onClickListener);
        holder.parent.setOnLongClickListener(onLongClickListener);
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
