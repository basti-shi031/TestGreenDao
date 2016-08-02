package com.example.boateng17.testgreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.boateng17.testgreendao.entity.Car;
import com.example.boateng17.testgreendao.entity.Color;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import cn.com.workshop7.factory.greendao.gen.CarDao;
import cn.com.workshop7.factory.greendao.gen.ColorDao;
import cn.com.workshop7.factory.greendao.gen.DaoMaster;
import cn.com.workshop7.factory.greendao.gen.DaoSession;

public class MainActivity extends AppCompatActivity {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private CarDao carDao;
    private ColorDao colorDao;

    private Button save, load;
    private EditText nameEt, REt, GEt, BEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(this, "car", null);
        daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        carDao = daoSession.getCarDao();
        colorDao = daoSession.getColorDao();


    }

    private void initEvent() {

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                String R = REt.getText().toString();
                String G = GEt.getText().toString();
                String B = BEt.getText().toString();

                Color color = new Color(null, Integer.parseInt(R), Integer.parseInt(G), Integer.parseInt(B));

/*
                Query query = colorDao.queryBuilder().where(ColorDao.Properties.R.eq(color.getR()),
                        ColorDao.Properties.G.eq(color.getG()),
                        ColorDao.Properties.B.eq(color.getB())).limit(1).build();
                List<Color> list = query.list();
*/

                long colorId = colorDao.insert(color);

                Car car = new Car();
                car.setName(name);
                car.setColorId(colorId);
                //  car.setColor(color);

                carDao.insert(car);
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Car> cars = carDao.queryBuilder().list();
                Color color = cars.get(0).getColor();
            }
        });

    }

    private void initView() {

        nameEt = (EditText) findViewById(R.id.name);
        REt = (EditText) findViewById(R.id.R);
        GEt = (EditText) findViewById(R.id.G);
        BEt = (EditText) findViewById(R.id.B);

        save = (Button) findViewById(R.id.save);

        load = (Button) findViewById(R.id.load);
    }
}
