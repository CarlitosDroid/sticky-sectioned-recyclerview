package pe.com.orbis.stickysectionedrcv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.com.orbis.stickysectionedrcv.model.ItemEntity;
import pe.com.orbis.stickysectionedrcv.model.MySectionEntity;
import pe.com.orbis.stickysectionedrcv.model.UserEntity;
import pe.com.orbis.stickysectionedrcv.view.StickyHeaderLayoutManager;
import pe.com.orbis.stickysectionedrcv.view.adapter.NotificationSectionAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvNotification;
    pe.com.orbis.stickysectionedrcv.view.adapter.NotificationSectionAdapter adapter;

    List<Object> objectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvNotification = (RecyclerView) findViewById(R.id.rcvNotification);
        rcvNotification.setLayoutManager(new StickyHeaderLayoutManager());
        objectList = new ArrayList<>();

        UserEntity userEntity = new UserEntity("Carlos Leonardo Camilo");
        objectList.add(userEntity);

        List<ItemEntity> listNotification = new ArrayList<>();
        listNotification.add(new ItemEntity("1","Nueva coincidencia con tu búsqueda guardada",
                "Revisa las últimas coincidencias de tu búsqueda","12:00 a.m","1","0"));
        listNotification.add(new ItemEntity("1","Invitación a proceso",
                "Grupo Pana te ha invitado a tomar parte en su proceso de selcción","10:34 a.m","1","0"));
        MySectionEntity mySectionEntity = new MySectionEntity("Hoy",listNotification);
        objectList.add(mySectionEntity);


        List<ItemEntity> listNotification2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listNotification2.add(new ItemEntity("1","Han revisado tu CV",
                    "Alguien ha revisado tu perfil público , mantenlo actualizado para mejorar tus posibilidades",
                    "12:20 p.m","1","0"));
        }
        MySectionEntity mySectionEntity2 = new MySectionEntity("Ayer",listNotification2);
        objectList.add(mySectionEntity2);


        List<ItemEntity> listNotification3 = new ArrayList<>();
        listNotification3.add(new ItemEntity("1","Han revisado tu CV en un proceso",
                "Alguien ha revisado tu CV en un proceso al que has postulad.",
                "11:20 p.m","0","0"));
        for (int i = 0; i < 5; i++) {
            listNotification3.add(new ItemEntity("1","Nuevo mensaje",
                    "Has recibido un mensaje de Corporación Lindley S.A.",
                    "11:20 p.m","0","0"));
        }
        MySectionEntity mySectionEntity3 = new MySectionEntity("15/12/15",listNotification3);
        objectList.add(mySectionEntity3);

        adapter = new NotificationSectionAdapter(this, objectList);
        rcvNotification.setAdapter(adapter);
    }
}
