package com.starks.english;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by RCP on 1/26/2018.
 */

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    TextView wordtxt,meantxt,sentxt;
    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        wordtxt=  itemView.findViewById(R.id.wordTxt);
        meantxt=  itemView.findViewById(R.id.meanTxt);
        sentxt=  itemView.findViewById(R.id.senTxt);


        itemView.setOnClickListener(this);
    }
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;

    }

}
