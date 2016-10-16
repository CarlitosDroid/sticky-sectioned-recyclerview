package pe.com.orbis.stickysectionedrcv.view.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.com.orbis.stickysectionedrcv.R;
import pe.com.orbis.stickysectionedrcv.model.ItemEntity;
import pe.com.orbis.stickysectionedrcv.model.MySectionEntity;
import pe.com.orbis.stickysectionedrcv.model.UserEntity;

/**
 * Created by carlos on 25/05/16.
 * Alias: CarlitosDroid
 */
public class NotificationSectionAdapter extends SectioningAdapter{

    private Context context;
    private List<Object> objectList = new ArrayList<>();

    public NotificationSectionAdapter(Context context, List<Object> objectList){
        this.context = context;
        this.objectList = objectList;
    }

    private class UserViewHolder extends SectioningAdapter.UserViewHolder implements View.OnClickListener{
        AppCompatTextView lblName;
        UserViewHolder(View itemView) {
            super(itemView);
            lblName = (AppCompatTextView) itemView.findViewById(R.id.lblName);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lblName:

                    break;
            }
        }
    }

    private class ItemViewHolder extends SectioningAdapter.ItemViewHolder implements View.OnClickListener{

        LinearLayout lnlNotification;
        AppCompatTextView lblTitle;
        AppCompatTextView lblDescription;
        AppCompatTextView lblHour;
        ImageView imgState;

        ItemViewHolder(View itemView) {
            super(itemView);
            lnlNotification = (LinearLayout) itemView.findViewById(R.id.lnlNotification);
            lblTitle = (AppCompatTextView) itemView.findViewById(R.id.lblTitle);
            lblDescription = (AppCompatTextView) itemView.findViewById(R.id.lblDescription);
            lblHour = (AppCompatTextView) itemView.findViewById(R.id.lblHour);
            imgState = (ImageView) itemView.findViewById(R.id.imgState);
            lnlNotification.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lnlNotification:
                    Toast.makeText(context, "Item: "+lblTitle.getText(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder implements View.OnClickListener{
        AppCompatTextView lblDate;
        HeaderViewHolder(View itemView) {
            super(itemView);
            lblDate = (AppCompatTextView) itemView.findViewById(R.id.lblDate);
            lblDate.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lblDate:
                    Toast.makeText(context, "Header: "+lblDate.getText(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        if(objectList.get(sectionIndex) instanceof UserEntity){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_notification_header, parent, false);
        return new HeaderViewHolder(v);
    }

    @Override
    public UserViewHolder onCreateUserViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_notification, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindUserViewHolder(SectioningAdapter.UserViewHolder viewHolder, int sectionIndex) {
        UserViewHolder userViewHolder = (UserViewHolder) viewHolder;
        userViewHolder.lblName.setText(((UserEntity)objectList.get(sectionIndex)).getName());
    }

    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
        headerViewHolder.lblDate.setText(((MySectionEntity)objectList.get(sectionIndex)).getDate());
    }

    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex) {
        ItemEntity sectionEntity = ((MySectionEntity)objectList.get(sectionIndex)).getItemEntity().get(itemIndex);
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        itemViewHolder.lblTitle.setText(sectionEntity.getTitle());
        itemViewHolder.lblDescription.setText(sectionEntity.getDescription());
        itemViewHolder.lblHour.setText(sectionEntity.getHour());
        if(sectionEntity.getState().equals("1")){
            itemViewHolder.imgState.setImageResource(R.drawable.ic_circle_green);
            itemViewHolder.lnlNotification.setBackgroundColor(ContextCompat.getColor(context, R.color.md_white_1000));
        }else{
            itemViewHolder.imgState.setImageResource(R.drawable.ic_circle_plumb);
            itemViewHolder.lnlNotification.setBackgroundColor(ContextCompat.getColor(context, R.color.notification_viewed));
        }

    }

    @Override
    public int getNumberOfSections() {
        return objectList.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {

        if(objectList.get(sectionIndex) instanceof UserEntity){
            return 1;//all our Entities are sections, in this case our UserEntity class is a section without header and footer
        }else {
            return ((MySectionEntity)objectList.get(sectionIndex)).getItemEntity().size();
        }
    }
}
