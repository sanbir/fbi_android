package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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
                                "Хабаров Валерий Иванович\nКафедра системного анализа\n" +
                                "и управления проектами\nзав. каф. д-р техн. наук, профессор\n" +
                                "Комаров Константин Леонидович\nФилиал кафедры ИТТ на ИВЦ ЗСЖД\n\tзав. филиалом - зам директора ИВЦ\n" +
                                "Есипенко Сергей Григорьевич\nКафедра общей информатики\nи.о. зав. каф. канд.техн. наук,\n" +
                                "доцент Цветков Дмитрий Николаевич");
                        itemNew.setUrlBig(String.valueOf(R.drawable.komarov));

                        intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("custom", itemNew);
                        startActivity(intent);
                        break;
                    case 3:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Специальности факультета \"Бизнес-информатика\"");
                        itemNew.setBody("Основное направление ФБИ СГУПС\n" +
                                "\n" +
                                "- подготовка специалистов по трем специальностям на дневном отделении:\n" +
                                "\n" +
                                "Специальность 071900 \"Информационные системы и технологии\"\n" +
                                "\n" +
                                "Выпускники по данной специальности получают квалификацию \"инженер\" и могут занимать соответствующие ей должности: инженер-программист, инженер-электроник, инженер по автоматизированным системам управления, руководители IT-служб.\n" +
                                "Объектами профессиональной деятельности специалистов являются информационные системы и сети, их математическое, информационное и программное обеспечение, способы и методы проектирования, отладки, производства и эксплуатации программных средств информационных систем в области управления технологическими бизнес-процессами на железнодорожном транспорте.\n" +
                                "\n" +
                                "Специальность 351400 \"Прикладная информатика (в экономике)\"\n" +
                                "\n" +
                                "Выпускники по данной специальности получают квалификацию \"информатик-экономист\".\n" +
                                "Объектами профессиональной деятельности специалистов являются: информационные системы в сфере экономики и бизнеса, их создание, внедрение, анализ и сопровождение, а также непосредственное их использование для решения функциональных задач управления информационными, материальными и финансовыми потоками.\n" +
                                "Специализации: корпоративные информационные системы, транспортно-логистические системы.\n" +
                                "\n" +
                                "Специальность 080506 \"Логистика и управление цепями поставок\"\n" +
                                "\n" +
                                "Выпускники по специальности «Логистика и управление цепями поставок» получают квалификацию «логист» и могут занимать должности менеджеров, логистов, консультантов, аналитиков, возглавлять отделы логистики и их отдельные подразделения, осуществлять руководство отдельными логистическими проектами в различных отраслях экономики.\n" +
                                "Программа обучения специальности «Логистика» включает в себя все аспекты логистического менеджмента: от элементарных логистических операций до проектирования и стратегического управления цепями поставок. Программа полностью соответствует международным стандартам (European Logistics Association – ELA).\n" +
                                "Специализация: «Транспортировка в цепях поставок».\n" +
                                "\n" +
                                "Все специальности специальности \"Информационные системы и технологии\", \"Прикладная информатика (в экономике)\", \"Логистика и управление цепями поставок\" имеют очную и заочную формы обучения, дополняют друг друга и в целом обеспечивают подготовку специалистов в области корпоративных информационных систем, которые в настоящее время и являются предметом нового направления - бизнес-информатика.\n" +
                                "\n" +
                                "Другими направлениями деятельности ФБИ СГУПС являются:\n" +
                                "\n" +
                                "- научная деятельность и подготовка кадров высшей квалификации (докторов и кандидатов наук) по специальностям 05.22.01. \" Транспортные и транспортно-технологические системы страны, её регионов и городов, организация производства на транспорте (технические науки)\"\n" +
                                "\n" +
                                "- повышение квалификации профессорско-преподавательского состава\n" +
                                "\n" +
                                "- второе высшее и дополнительное образование\n" +
                                "\n" +
                                "- консалтинг в области информационных технологий и корпоративных информационных систем на транспорте, системного анализа транспортных объектов и стратегического менеджмента, моделирования логистических транспортных процессов, информационной безопасности, управления проектами, управления знаниями, управления качеством.\n" +
                                "\n" +
                                "- Специальность 230201 \"Информационные системы и технологии\"\n" +
                                "\n" +
                                "- Специальность 080801 \"Прикладная информатика (в экономике)\"\n" +
                                "\n" +
                                "- Специальность 080506 \"Логистика и управление цепями поставок\"");


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
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Видео-презентация факультета БИ");
                        itemNew.setBody("");
                        itemNew.setUrlBig("");

                        intent = new Intent(OfbiActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                }

            }
        });


    }


}
