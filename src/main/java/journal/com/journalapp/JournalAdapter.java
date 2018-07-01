package journal.com.journalapp;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder> {
        private Context context;
        private List<JournalMessages> messages;

    public JournalAdapter(Context context, List<JournalMessages> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.journal_message_display,null,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JournalMessages journalMessages =messages.get(position);

        holder.message.setText(journalMessages.getMessage());
        holder.dateSet.setText(journalMessages.getDate());

    }


    @Override
    public int getItemCount(){return messages.size();}

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView message,dateSet;


        public ViewHolder(View itemView) {
            super(itemView);

            message = (TextView)itemView.findViewById(R.id.showMessage);
            dateSet= (TextView)itemView.findViewById(R.id.datesPlaced);
        }
    }

}
