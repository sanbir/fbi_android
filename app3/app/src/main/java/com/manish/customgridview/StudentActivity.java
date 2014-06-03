package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.manish.customgridview.displayingbitmaps.ui.ImageGridActivity;

import java.util.ArrayList;

public class StudentActivity extends Activity
{
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.GONE);

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.fbi256);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.study);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.library);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.sport);
        Bitmap icon9 = BitmapFactory.decodeResource(this.getResources(), R.drawable.sdo);

        gridArray.add(new Item(icon1,"О ФБИ"));
        gridArray.add(new Item(icon2,"Фотогалерея"));
        gridArray.add(new Item(icon3,"Объявления"));
        gridArray.add(new Item(icon4,"Учеба"));
        gridArray.add(new Item(icon5,"Новости"));
        gridArray.add(new Item(icon6,"Профком"));
        gridArray.add(new Item(icon7,"Библиотека"));
        gridArray.add(new Item(icon8,"Спорт"));
        gridArray.add(new Item(icon9,"СДО"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

            switch (position) {
                case 0:
                    startActivity (new Intent(getApplicationContext(), OfbiActivity.class));
                    break;
                case 1:
                    startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));
                    break;
                case 2:
                    ArrayList<UserItemNew> notices = getListNotices();
                    Intent intent = new Intent(StudentActivity.this, UserListViewNew.class);
                    intent.putExtra("customList", notices);
                    startActivity(intent);

                    //startActivity (new Intent(getApplicationContext(), UserListViewNew.class));
                    break;
                case 3:
                    startActivity (new Intent(getApplicationContext(), StudyActivity.class));
                    break;
                case 4:
                    ArrayList<UserItemNew> news = getListNews();
                    intent = new Intent(StudentActivity.this, UserListViewNew.class);
                    intent.putExtra("customList", news);
                    startActivity(intent);
                    break;
                case 5:
                    startActivity (new Intent(getApplicationContext(), ProfStudentActivity.class));
                    break;
                case 6:
                    Intent i = new Intent(getApplicationContext(), WebBrowserActivity.class);
                    i.putExtra("site","http://81.1.243.214");
                    startActivity(i);
                    break;
                case 7:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
                case 8:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
            }

            }
        });


    }

    private ArrayList<UserItemNew> getListNotices() {
        ArrayList<UserItemNew> results = new ArrayList<UserItemNew>();
        UserItemNew newsData = new UserItemNew();
        newsData.setHeadline("Dance of Democracy");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        newsData.setUrl("http://www.stu.ru/images/theme/29804.jpg");
        newsData.setBody("ffffffffff1");
        newsData.setUrlBig("http://www.stu.ru/images/theme/29805.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Major Naxal attacks in the past");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        newsData.setUrl("http://www.stu.ru/images/theme/29806.jpg");
        newsData.setBody("ffffffffff2");
        newsData.setUrlBig("http://www.stu.ru/images/theme/29807.jpg");
        results.add(newsData);

        return results;
    }

    private ArrayList<UserItemNew> getListNews() {
        ArrayList<UserItemNew> results = new ArrayList<UserItemNew>();

        UserItemNew newsData = new UserItemNew();
        newsData.setHeadline("СГУПС разрабатывает комплексную транспортную модель Новосибирска.");
        newsData.setReporterName("");
        newsData.setDate("03.06.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_f74fbe0d_big.jpg");
        newsData.setBody("Еще 5 лет назад пробки на дорогах города Новосибирска встречались только в часы пик – утром и вечером. Теперь же ситуация на дорогах крайне ухудшилась, и на некоторых участках дороги пробки не прекращаются, а машины двигаются с такой скоростью, что быстрее пройти пешком.\n\nЭто связано с особенностями города. Новосибирск – сравнительно молодой мегаполис, который развивается очень быстро. Однако, улицы и микрорайоны, торговые центры и другие крупные объекты, места размещения дорог и развязок создаются без должного анализа пропускной способности улично-дорожной сети.\n\nНовосибирская мэрия обратилась в СГУПС за помощью в создании комплексной транспортной модели города. Все изменения будут сначала тестироваться на ней. Это поможет просчитать поведение транспортных потоков перед тем, как начать строительство развязки, торгового центра или большого микрорайона. Зачастую такие крупные проекты оказывают существенное влияние на транспортную картину города, так как подразумевают серьезные перенаправление потоков людей и транспорта.\n\nДля создания адекватной модели необходимо большое количество данных, в том числе о перемещении жителей города. Не важно, как именно человек добирается до места. Важны – начальная, средняя и конечная точки его маршрута. Для сбора этой информации создан специальный сайт http://geosocinform.ru/, где любой желающий может анонимно заполнить анкету о своих перемещениях. Чем больше будет записей в анкете, тем точнее будет построенная модель.\n\nПоэтому СГУПС обращается за помощью ко всем жителям города Новосибирска и, персонально, ко всем студентам и сотрудникам СГУПС: удели 2 минуты анкете – заставь транспортную модель учитывать тебя!");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_f74fbe0d_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Приглашаем на открытие выставки и подведение итогов молодёжной акции \"Письмо ветерану\"");
        newsData.setReporterName("");
        newsData.setDate("30.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        newsData.setBody("«Спасибо, что живём» скажут ветеранам, труженикам тыла в Музее Заельцовского района (Красный проспект, 179) 30 мая 2014 года в 15.00 на открытии одноимённой выставки.\n" +
                "\n" +
                "На выставке будут представлены документы, фотографии и другие памятники военного времени из фондов музея, предметы быта военного времени, амуниция времен войны, позволяющие узнать о вкладе Заельцовского района и его жителей в великую Победу.\n" +
                "\n" +
                "На открытие выставки приглашены ветераны и участники Великой Отечественной войны, труженики тыла, защитники блокадного Ленинграда, дети войны. Для них со сцены будут звучать слова благодарности, концертные номера в исполнении представителей молодёжи Заельцовского района.\n" +
                "\n" +
                "На церемонии открытия выставки будут подведены итоги молодёжной акции «Письмо ветерану» и письма, написанные учащимися общеобразовательных школ и студентами ВУЗов, будут вручены адресатам.\n" +
                "\n" +
                "Посетить выставку можно с 30 мая по 15 августа, со вторника по субботу, с 10.00 до 17.30. Вход свободный.\n" +
                "Все подробности по телефону: 2000 – 271, Алимханова Дарья Адамовна, куратор проекта.\n" +
                "www.zmnsk.ru\n" +
                "VK: vk.com/zaelmuseumnsk\n" +
                "OK: odnoklassniki.ru/group/56851236978732\n" +
                "FB: www.facebook.com/muzei.zaeltzovskij ");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_16ee516f_big.jpg");
        results.add(newsData);

        return results;
    }

}
