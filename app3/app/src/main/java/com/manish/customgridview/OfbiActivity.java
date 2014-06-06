package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class OfbiActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    О ФБИ >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.dean);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mission);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.kafedra);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.engineer);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.u4_lab_base);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.video);

        gridArray.add(new Item(icon1, "Декан"));
        gridArray.add(new Item(icon2, "Миссия факультета"));
        gridArray.add(new Item(icon3, "Кафедры"));
        gridArray.add(new Item(icon4, "Направления и специальности"));
        gridArray.add(new Item(icon5, "Учебно-лабораторная база"));
        gridArray.add(new Item(icon6, "Видео-презентация факультета"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        UserItemNew itemNew = new UserItemNew();
                        itemNew.setHeadline("Декан факультета");
                        itemNew.setBody("д.т.н, профессор\n" +
                                "Хабаров\n" +
                                "Валерий Иванович\n" +
                                "Контактный телефон: 328-03-15.\n" +
                                "E-mail: iitt@stu.ru\n" +
                                "каб. 462\n" +
                                "\n" +
                                "Деканат: каб. 462a\n" +
                                "Контактный телефон: 328-03-76.\n" +
                                "E-mail: fbi@stu.ru\n");
                        itemNew.setUrlBig(String.valueOf(R.drawable.dean1));

                        Intent intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("custom", itemNew);
                        startActivity(intent);
                        break;
                    case 1:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Миссия факультета");
                        itemNew.setBody("Подготовка специалистов в области информационного сопровождения бизнес-процессов, корпоративных информационных систем, IT-индустрии и бизнеса:\n" +
                                "Разработка, анализ и оптимизация бизнес-процессов предприятия\n" +
                                "Проектирование, внедрение и эксплуатация информационных систем\n" +
                                "Математическое, информационное и программное обеспечение корпоративных систем и сетей\n" +
                                "Эксплуатация информационных систем и сетей\n" +
                                "Переподготовка специалистов в ситуации, требующей повышения темпов бизнес-процессов и высокого качества логистики:\n" +
                                "Переподготовка специалистов с высшим образованием в области информационного сопровождения бизнес-процессов и корпоративных информационных систем для железнодорожного транспорта России\n" +
                                "Переподготовка научных и педагогических кадров высшей квалификации в аспирантуре и докторантуре\n" +
                                "Выполнение НИОКР в сфере управления организационно-техническими и экономическими системами\n" +
                                "Консолидация научных исследований в области бизнес-информатики в университете совместно с предприятиями РЖД ");
                        itemNew.setUrlBig("");

                        intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                    case 2:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Кафедры факультета");
                        itemNew.setBody("Выпускающая кафедра информационных\n" +
                                "технологий на транспорте (ИТТ)\nзав. кафедрой д.т.н., профессор\n" +
                                "Хабаров Валерий Иванович\n\nКафедра системного анализа\n" +
                                "и управления проектами\nзав. каф. д-р техн. наук, профессор\n" +
                                "Комаров Константин Леонидович\n\nФилиал кафедры ИТТ на ИВЦ ЗСЖД\n\tзав. филиалом - зам директора ИВЦ\n" +
                                "Есипенко Сергей Григорьевич\n\nКафедра общей информатики\nи.о. зав. каф. канд.техн. наук,\n" +
                                "доцент Цветков Дмитрий Николаевич");
                        itemNew.setUrlBig(String.valueOf(R.drawable.kafedry1));

                        intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("custom", itemNew);
                        startActivity(intent);
                        break;
                    case 3:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Специальности факультета \"Бизнес-информатика\"");
                        itemNew.setBody("230400 \"Информационные системы и технологии\"\n" +
                                "\n" +
                                "Выпускники по данному направлению получают квалификацию \"бакалавр-инженер\" и могут занимать соответствующие ей должности: инженер-программист, инженер-электроник, инженер по автоматизированным системам управления, руководители IT-служб. \n" +
                                "Объектами профессиональной деятельности являются информационные системы и сети, их математическое, информационное и программное обеспечение, способы и методы проектирования, отладки, производства и эксплуатации программных средств информационных систем в области управления технологическими бизнес-процессами на железнодорожном транспорте.\n" +
                                "\n" +
                                "230700 \"Прикладная информатика\"\n" +
                                "\n" +
                                "Выпускники по данному направлению получают квалификацию \"бакалавр\". \n" +
                                "Объектами профессиональной деятельности специалистов являются: информационные системы в сфере экономики и бизнеса, их создание, внедрение, анализ и сопровождение, а также непосредственное их использование для решения функциональных задач управления информационными, материальными и финансовыми потоками. \n" +
                                "\n" +
                                "080200 Менеджмент, профиль \"Логистика и управление цепями поставок\"\n" +
                                "\n" +
                                "Выпускники по профилю «Логистика и управление цепями поставок» получают квалификацию «бакалавр» и могут занимать должности менеджеров, логистов, консультантов, аналитиков, возглавлять отделы логистики и их отдельные подразделения, осуществлять руководство отдельными логистическими проектами в различных отраслях экономики.\n" +
                                "Программа обучения специальности «Логистика» включает в себя все аспекты логистического менеджмента: от элементарных логистических операций до проектирования и стратегического управления цепями поставок. Программа полностью соответствует международным стандартам (European Logistics Association – ELA).\n" +
                                "\n" +
                                "На все направления открыта магистратура.");


                        intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                    case 4:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Учебно-лабораторная база");
                        itemNew.setBody("    Лаборатория \"Системный анализ и управление транспортными объектами\", ауд. 223а, создана в 2008 г.\n" +
                                "    Лаборатория \"Моделирование бизнес - процессов на транспорте\", ауд. 461, создана в 2007 г.\n" +
                                "    Лаборатория \"Телекоммуникаций и администрирования сетей\", ауд. 457, создана в 2007 г.\n" +
                                "    Лаборатория \"Геоинформатика, 3D и тренажерные технологии\", ауд. 453, создана в 2007 г.\n" +
                                "    Лаборатория \"Проектирование информационных систем\", ауд. 451, создана в 2007 г.\n" +
                                "    Лаборатория логистических процессов, ауд. 4626, создана в 2007 г.\n" +
                                "    Студенческое конструкторское бюро. Серверная ФБИ, ауд. 466, создана в 2007 г.\n" +
                                "    Компьютерный класс ФБИ, ауд. 445, создан в 2007 г.\n" +
                                "    Компьютерный класс ФБИ, ауд. 447, создан в 2007 г.\n" +
                                "    Компьютерный класс ФБИ, ауд. 454, создан в 2007 г.\n" +
                                "    Компьютерный класс ФБИ, ауд. 460, создан в 2007 г.");
                        itemNew.setUrlBig(String.valueOf(R.drawable.u4labb));

                        intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("custom", itemNew);
                        startActivity(intent);
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SEDGWp1gS1A")));
                        Log.i("Video11", "Video Playing11....");
                        break;
                }

            }
        });


    }


}
