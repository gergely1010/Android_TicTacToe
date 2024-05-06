package com.example.android_tictactoe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_tictactoe.Data.Gamer;
import com.example.android_tictactoe.R;

import java.util.Iterator;
import java.util.List;

public class UserHighScoreAdapter  extends RecyclerView.Adapter<UserHighScoreAdapter.GamerPointViewHolder> {
    private List<Gamer> gamers;
    public UserHighScoreAdapter(List<Gamer> gamers, String gameName) {

        List<Gamer> gamersInGame = null;
        Iterator<Gamer> iterator = gamers.iterator();
        while (iterator.hasNext()) {
            Gamer gamer = iterator.next();
            if (gamer.getGameName().equals(gameName)) {
                gamersInGame.add(gamer);
            }
        }
        this.gamers = gamersInGame;
    }

    @NonNull
    @Override
    public UserHighScoreAdapter.GamerPointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.high_score_panel_row,
                        parent,
                        false
                );
        return new GamerPointViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHighScoreAdapter.GamerPointViewHolder holder, int position) {

        Gamer gamer = gamers.get(position);
        holder.txtHighName.setText(gamer.getUserName());
        holder.txtWinMatch.setText(gamer.getGameWPoints());
        holder.txtLostMatch.setText(gamer.getGameLPoint());
        holder.txtPoint.setText(gamer.getGameWPoints()*3);
    }

    @Override
    public int getItemCount() {
        return gamers.size();
    }

    public static class GamerPointViewHolder extends RecyclerView.ViewHolder{
        TextView txtHighName, txtWinMatch, txtLostMatch, txtPoint;
        public GamerPointViewHolder(@NonNull View itemView) {
            super(itemView);

            txtHighName = itemView.findViewById(R.id.txtHighName);
            txtWinMatch = itemView.findViewById(R.id.txtHighWinMatch);
            txtLostMatch = itemView.findViewById(R.id.txtHighLostMatch);
            txtPoint = itemView.findViewById(R.id.txtHighSumPoint);
        }
    }
}
