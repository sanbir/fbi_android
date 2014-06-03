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
        newsData.setHeadline("Чемпионат СГУПСа по борьбе дзюдо");
        newsData.setReporterName("");
        newsData.setDate("29.05.2014");
        newsData.setUrl("");
        newsData.setBody("28 мая в Доме спорта проходил чемпионат СГУПСа по борьбе дзюдо.\n" +
                "\n" +
                "Победители и призеры:\n" +
                "1. Бекирова Элвина, МЭиП – I место\n" +
                "2. Мамедова Эльнура, МЭиП – I место\n" +
                "3. Худададова Теймура, ПГС – II место\n" +
                "4. Мемадалиева Махара, МЭиП – III место\n" +
                "5. Ширшова Александра, ПГС – III место\n" +
                "6. Цечоева Магамета, МЭиП – I место\n" +
                "7. Шоева Шерафкана, МЭиП – II место\n" +
                "8. Сурадеева Максима, МЭиП – III место\n" +
                "9. Крейса Алексея, МТ – III место\n" +
                "10.Булышева Максима, СЖД – I место\n" +
                "11. Курбанова Махамаджона, МЭиП – II место\n" +
                "12. Бунтова Павла, МТ – III место\n" +
                "13. Агарагимли Рагима , УП – III место\n" +
                "14. Мищенко Самвела, СЖД – I место\n" +
                "15. Бронникова Константина, МТ – II место\n" +
                "16. Позура Tвгения, ПГС – III место\n" +
                "17. Истомина Владимира, МТ – III место\n" +
                "\n" +
                "15-й раз подряд переходящий кубок остается на факультете «Мировая экономика и право»\n" +
                "2 место – «Мосты и тоннели»\n" +
                "3 место – «Промышленное и гражданское строительство»\n" +
                "4 место – «Строительство железных дорог»\n" +
                "5 место – «Управление персоналом»\n" +
                "6 место – «Инженерно-экономический» ");
        newsData.setUrlBig("");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("СГУПС занял призовое место в областной олимпиаде");
        newsData.setReporterName("");
        newsData.setDate("29.05.2014");
        newsData.setUrl("");
        newsData.setBody("В конце мая проходила областная студенческая олимпиада по программированию.\n" +
                "\n" +
                "Студент факультета “Бизнес-информатика”, Бирюков Александр, занял 2-ое место. ");
        newsData.setUrlBig("");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("СГУПС возглавил первую областную спартакиаду по военно-прикладным видам спорта (по многоборью «ГТО»). ");
        newsData.setReporterName("");
        newsData.setDate("29.05.2014");
        newsData.setUrl("http://www.stu.ru/images/news/u_a3f2e5e4_big.jpg");
        newsData.setBody("26-27 мая в Новосибирске на базе спортивного комплекса СГУПСа, не смотря на дождь и ветер, прошла Первая областная спартакиада «Патриотизм, Спорт, Оборона» среди учащихся высших учебных заведений по военно-прикладным видам спорта (по многоборью «ГТО»).\n" +
                "На торжественном открытии присутствовали:\n" +
                "- ректор СГУПСа – Манаков Алексей Леонидович;\n" +
                "- председатель НРО ДОСААФ России – Мусин Реалиль Кашшафович;\n" +
                "- и.о. руководителя департамента физической культуры и спорта НСО – Седов Дмитрий Владимирович;\n" +
                "- начальник управления физической культуры и спорта мэрии города Новосибирска – Ахапов Сергей Александрович;\n" +
                "- начальник отдела развития технических видов спорта ГАУ НСО «ЦСП» НСО – Мануйленко Николай Антонович.\n" +
                "Показательные выступления Новосибирского аэроклуба прошли без парашютистов, в связи с низкой облачностью. Студентов с открытием спартакиады из кабины самолета поздравила проректор по воспитательной работе и социальному развитию Самардак Марина Викторовна (о первом дне ГТО смотри на сайте в разделе новости от 27.05.14).\n" +
                "В соревнованиях приняли участие более 150 студентов СГУПСа и команда спортсменов НРО ДОСААФ России, которая по итогам командного зачета заняла 7 место.\n" +
                "Организаторы областной Спартакиады: Сибирский государственный университет путей и сообщения, Новосибирское региональное отделение ДОСААФ России, департамент физической культуры и спорта Новосибирской области, Правительство Новосибирской области.\n" +
                "\n" +
                "Итоги спартакиады:\n" +
                "27 золотых и 22 серебряных значка.\n" +
                "Результаты командного зачета:\n" +
                "МЭиП – 1 место\n" +
                "УПП -2 место\n" +
                "УП1 - 3 место\n" +
                "УТТК - 4 место\n" +
                "ПГС - 5 место\n" +
                "МТ - 6 место\n" +
                "ДОСААФ - 7 место\n" +
                "ФБИ - 8 место\n" +
                "СЖД - 9 место\n" +
                "ИЭФ - 10 место\n" +
                "УП2 -11 место\n" +
                "\n" +
                "Призеры и победители получили кубки, медали, а также бесплатные сертификаты от Новосибирского аэроклуба на полет на самолете, планере и прыжок в тандеме.\n");
        newsData.setUrlBig("http://www.stu.ru/images/news/u_a3f2e5e4_big.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Открытие соревнований по многоборью ГТО в СГУПСе");
        newsData.setReporterName("");
        newsData.setDate("27.05.2014");
        newsData.setUrl("");
        newsData.setBody("26 мая 2014г. на стадионе СГУПСа состоялось яркое открытие соревнований по многоборью ГТО, которые впервые проходят в Новосибирске.\n" +
                "\n" +
                "Открытие началось с выхода команд на поле под аплодисменты болельщиков, после чего командующий парадом заведующий кафедрой «Физическое воспитание и спорт» Н.Н. Козлов провел построение.\n" +
                "\n" +
                "С приветственным словом выступил ректор СГУПСа А.Л. Манаков. Среди гостей на мероприятии присутствовали - председатель Новосибирского регионального отделения ДОСААФ России Р.К. Мусин, начальник управления физической культуры и спорта мэрии города Новосибирска С.А. Ахапов, начальник отдела студенческого спорта ГАУ НСО «Центр спортивной подготовки Новосибирской области» А.В. Красавина, двукратная олимпийская чемпионка по биатлону А.И. Богалий. Гости отметили, что хорошо развитая спортивная база университета и укоренившиеся традиции подготовки спортсменов мирового и олимпийского уровня позволяет СГУПСу проводить мероприятия подобного масштаба.\n" +
                "\n" +
                "Запоминающимся моментом стал летающий над стадионом самолет, из кабины которого с высоты птичьего полета проректор по воспитательной работе и социальному развитию СГУПСа М.В. Самардак поздравила всех с открытием и пожелала участникам удачи. Также были подготовлены парашютисты, которые должны были спуститься прямо на поле СГУПСа, но, к сожалению, дождливая погода и ветер не позволили реализовать задуманное. Из самолета на поле прилетели только листовки с историей зарождения и развития Всероссийского комплекса ГТО.\n" +
                "\n" +
                "Соревнования продлятся два дня, по итогам которых будут определены победители в личном и командном первенстве. Те, кто выполнит все нормативы, получат значки «Готов к Труду и Обороне» I и II степени. Лучшие в личном первенстве в качестве награды получат также и ценные призы от ДОСААФ России – бесплатный прыжок с парашютом в тандеме или полет на самолете или планере. ");
        newsData.setUrlBig("");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Межвузовские соревнования по картингу");
        newsData.setReporterName("");
        newsData.setDate("26.05.2014");
        newsData.setUrl("");
        newsData.setBody("23-24 мая 2014 года прошли межвузовские соревнования по картингу. Организаторами мероприятия выступили Сибирский государственный университет путей сообщения совместно с «Автомотоцентром» при поддержки Новосибирского регионального отделения Общероссийского общественного движения «Народный фронт «За Россию», УГИБДД ГУ МВД России по НСО и Союза Новосибирских студенческих организаций.\n" +
                "\n" +
                "В соревнованиях приняли участие студенты СГУПСа, НГТУ, НГУ, СГГА, НГАУ и НТИ МГУДТ.\n" +
                "\n" +
                "Программа соревнований была разбита на два дня. В первый день в СГУПСе прошла встреча с начальником УГИБДД ГУ МВД России по НСО Штельмахом Сергеем Викторовичем, тестирование участников на знание ПДД и биатлонная стрельба из пневматической винтовки.\n" +
                "\n" +
                "Во второй день на территории «Автомотоцентра» состоялись сами соревнований по картингу.\n" +
                "\n" +
                "По итогам соревнований СГУПС вошел в четверку лидеров. ");
        newsData.setUrlBig("");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("СГУПС - лидер инновационных научно-образовательных учреждений среди технических вузов");
        newsData.setReporterName("");
        newsData.setDate("26.05.2014");
        newsData.setUrl("");
        newsData.setBody("В Новосибирске в седьмой раз отметили городской День Науки. СГУПС стал лауреатом I степени в номинации «Лидер инновационных научно-образовательных учреждений среди технических вузов».\n" +
                "\n" +
                "Среди награждённых – предприятия, внедряющие в производство современные разработки, научно-исследовательские институты, ведущие фундаментальные исследования. Отметили и учёных, работающих над проектами для развития экономики и социальной сферы города. ");
        newsData.setUrlBig("");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("С 28 июня по 5 июля состоится поездка делегации СГУПСа в Республику Корея");
        newsData.setReporterName("");
        newsData.setDate("23.05.2014");
        newsData.setUrl("");
        newsData.setBody("В рамках двустороннего обмена с Республикой Корея наши преподаватели и студенты в очередной раз отправятся в рабочую поездку в Корейский национальный университет транспорта (KNUT), (Korean National University of Transportation).\n" +
                "Проживание, питание, программа стажировки – за счет принимающей стороны. Участник оплачивает только авиабилет и мед. страховку (Новосибирск-Пекин-Сеул-Пекин Новосибирск – 34 000 р.).\n" +
                "\n" +
                "Цель поездки: участие в ежегодной международной студенческой научно-практической конференции, знакомство с материально-технической базой Корейского национального университета транспорта, посещение Пусанской транспортной корпорации, знакомство с организацией высокоскоростного железнодорожного сообщения компании KORAIL, работой метрополитена.\n" +
                "\n" +
                "Программа визита включает:\n" +
                "1. Участие в ежегодной международной студенческой научно-практической конференции, проводимой на базе КНУТ.\n" +
                "2. Посещение Корейского национального университета транспорта.\n" +
                "3. Посещение Института повышения квалификации и Академии сервиса корейских железных дорог.\n" +
                "4. Знакомство с высокоскоростными железными дорогами Р.Корея – KORAIL.\n" +
                "5. Посещение депо скоростных поездов КТХ.\n" +
                "6. Визит в Транспортную корпорацию г. Пусан.\n" +
                "7. Осмотр достопримечательностей в г. Сеуле, поездка на побережье Восточного моря, г. Пусан.\n" +
                "\n" +
                "Заявки для участия направлять в отдел международных связей в срок до 4 июня 2014 г. – ауд. 446а, тел. 328-03-53 ");
        newsData.setUrlBig("");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Профбюро ФБИ несет лучи добра детям!");
        newsData.setReporterName("Воскресный выходной активисты и профорги факультета решили посвятить детям, оставшимся без попечения родителей.");
        newsData.setDate("19.05.2014");
        newsData.setUrl("http://www.sgups.net/upload/iblock/598/IMG_2063.JPG");
        newsData.setBody("Сегодня, в холодное майское утро, когда все студенты СГУПСа еще спят, а строительные отряды бегают на Весенних Стартах, профбюро факультета «Бизнес-Информатика» съездили в «Санаторный детский дом для детей-сирот и детей, оставшихся без попечения родителей №15 «Надежда»». \n" +
                "\n" +
                "               Сюда уже давно не приезжали посетители, и ребята, увидев нас, сразу же побежали к нам и начали обнимать.\n" +
                "\n" +
                "               Мы провели для них утреннюю зарядку, различные подвижные детские игры, в которые детишки с огромным удовольствием играли.  Потом несколько мальчишек показали нам танец, который они давно уже учат.\n" +
                "\n" +
                "               Воспитатели попросили нас погулять с детьми на площадке. Холодный воздух, идущий снег-град - ничего не остановило ребят. Кто-то катался на велосипеде, кто-то на скейтборде, кто-то качался на качелях, кто-то потягивался на турнике, а кто-то просто бегал за нами и смеялся. Самое прекрасное - слышать их смех. Ребята не хотели нас отпускать и просили приезжать к ним как можно чаще. ");
        newsData.setUrlBig("http://www.sgups.net/upload/iblock/598/IMG_2063.JPG");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Профбюро ФБИ пошло в кино!");
        newsData.setReporterName("Традиционное киноутро выходит за пределы родного университета.");
        newsData.setDate("16.05.2014");
        newsData.setUrl("http://www.sgups.net/upload/iblock/323/UbejIbE2ZJM.jpg");
        newsData.setBody("   Еще один месяц работы активистов Профбюро ФБИ. Пора и отдыхать! А мы любим смотреть кино. В этот раз мы решили не смотреть давно выложенные на торренты фильмы, а отправиться за чем-нибудь свежим и актуальным прямиком в кинотеатр!\n" +
                "            Нам удалось собраться организованной группкой и пойти за зрелищем. Кинозал, попкорн, хорошее кино. Что еще нужно для счастья? Было весело и, хотелось бы, чтобы наша добрая традиция плавно перешла и на следующий год, заодно захватывая будущих новых активистов.\n");
        newsData.setUrlBig("http://www.sgups.net/upload/iblock/323/UbejIbE2ZJM.jpg");
        results.add(newsData);

        newsData = new UserItemNew();
        newsData.setHeadline("Сборная команда СГУПСа – третья на соревнованиях по пауэрлифтингу");
        newsData.setReporterName("");
        newsData.setDate("17.03.2014");
        newsData.setUrl("");
        newsData.setBody("14 - 15 марта 2014 г. проходили соревнования по пауэрлифтингу среди вузов г. Новосибирска. В соревнованиях приняли участие 11 вузов города (около 100 человек).\n" +
                "\n" +
                "Сборная команда СГУПСа заняла почетное III место.\n" +
                "\n" +
                "Честь вуза защищали:\n" +
                "\n" +
                "Сухоставский Артем (ИЭФ);\n" +
                "Шипилов Александр (СЖД);\n" +
                "Курьянов Роман (УП);\n" +
                "Лужанский Алексей (МЭиП);\n" +
                "Гареев Тимур (УПП);\n" +
                "Маслюк Владимир (ИЭФ);\n" +
                "Кузьминых Павел (ФБИ);\n" +
                "\n" +
                "В личном зачете I место заняли Шипилов Александр и Кузьминых Павел.\n" +
                "\n" +
                "III место завоевал Сухоставский Артем.\n" +
                "\n" +
                "Тренер команды – старший преподаватель кафедры «Физическое воспитание и спорт» Воловик Александр Алексеевич. ");
        newsData.setUrlBig("");
        results.add(newsData);

        return results;
    }

}
