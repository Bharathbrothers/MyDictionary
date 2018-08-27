package com.starks.english;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by RCP on 1/26/2018.
 */

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener,View.OnCreateContextMenuListener{


    TextView wordtxt,meantxt,sentxt;
    ItemClickListener itemClickListener;
    MyLongClickListener longClickListener;


    public MyHolder(View itemView) {
        super(itemView);

        wordtxt=  itemView.findViewById(R.id.wordTxt);
        meantxt=  itemView.findViewById(R.id.meanTxt);
        sentxt=  itemView.findViewById(R.id.senTxt);


        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

    }
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;

    }
    public void setLongClickListener(MyLongClickListener longClickListener)
    {
        this.longClickListener=longClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onLongClick(getLayoutPosition());
        return false;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //OUR CONTEXT MENU
        menu.setHeaderTitle("ACTION : ");
        menu.add(0,0,0,"New");
        menu.add(0,1,0,"Delete");

    }
}
