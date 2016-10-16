package pe.com.orbis.stickysectionedrcv.model;

import java.util.List;

/**
 * Created by carlos on 25/05/16.
 * Alias: CarlitosDroid
 */
public class MySectionEntity {

    private String date;
    private List<ItemEntity> itemEntity;


    public MySectionEntity(String date, List<ItemEntity> itemEntity) {
        this.date = date;
        this.itemEntity = itemEntity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ItemEntity> getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(List<ItemEntity> itemEntity) {
        this.itemEntity = itemEntity;
    }

}
