using App17.Common;
using App17.Data;
using App17.Selectors;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// Шаблон элемента страницы сведений о группе задокументирован по адресу http://go.microsoft.com/fwlink/?LinkId=234229

namespace App17
{
    /// <summary>
    /// Страница, на которой показываются общие сведения об отдельной группе, включая предварительный просмотр элементов
    /// внутри группы.
    /// </summary>
    public sealed partial class GroupDetailPage : Page
    {
        private NavigationHelper navigationHelper;
        private ObservableDictionary defaultViewModel = new ObservableDictionary();

        /// <summary>
        /// NavigationHelper используется на каждой странице для облегчения навигации и 
        /// управление жизненным циклом процесса
        /// </summary>
        public NavigationHelper NavigationHelper
        {
            get { return this.navigationHelper; }
        }

        /// <summary>
        /// Эту настройку можно изменить на модель строго типизированных представлений.
        /// </summary>
        public ObservableDictionary DefaultViewModel
        {
            get { return this.defaultViewModel; }
        }


        public GroupDetailPage()
        {
            this.InitializeComponent();
            this.navigationHelper = new NavigationHelper(this);
            this.navigationHelper.LoadState += navigationHelper_LoadState;
        }

        /// <summary>
        /// Заполняет страницу содержимым, передаваемым в процессе навигации.  Также предоставляется любое сохраненное состояние
        /// при повторном создании страницы из предыдущего сеанса.
        /// </summary>
        /// <param name="sender">
        /// Источник события; как правило, <see cref="NavigationHelper"/>
        /// </param>
        /// <param name="e">Данные события, предоставляющие параметр навигации, который передается
        /// <see cref="Frame.Navigate(Type, Object)"/> при первоначальном запросе этой страницы и
        /// словарь состояний, сохраненных этой страницей в ходе предыдущего
        /// сеанса.  Это состояние будет равно NULL при первом посещении страницы.</param>
        private async void navigationHelper_LoadState(object sender, LoadStateEventArgs e)
        {
            String navigationParameter = (String)e.NavigationParameter;

            // TODO: Создание соответствующей модели данных для области проблемы, чтобы заменить пример данных
            var group = await SampleDataSource.GetGroupFromItemAsync(navigationParameter);
            this.DefaultViewModel["Group"] = group;
            this.DefaultViewModel["Items"] = group.Items;

            ///////////////////////

            SampleDataItem item;
            if (navigationParameter.Contains("Item"))
            {
                item = await SampleDataSource.GetItemAsync(navigationParameter);
            }
            else
            // Если нажать по заголовку, выбрать 1-ый элемент 
            {
                item = await SampleDataSource.GetItemAsync(navigationParameter + "-Item-1");
            }
            //itemFlipView.SelectedItem = item;
            ////////////////
            int ww = item.UniqueId.Length - 1;
            var ii = item.UniqueId[item.UniqueId.Length - 1];
            int qq = int.Parse(item.UniqueId[item.UniqueId.Length - 1].ToString()) - 1;
            itemFlipView.SelectedIndex = qq;
            
        }
        
        #region Регистрация NavigationHelper

        /// Методы, предоставленные в этом разделе, используются исключительно для того, чтобы
        /// NavigationHelper для отклика на методы навигации страницы.
        /// 
        /// Логика страницы должна быть размещена в обработчиках событий для 
        /// <see cref="GridCS.Common.NavigationHelper.LoadState"/>
        /// и <see cref="GridCS.Common.NavigationHelper.SaveState"/>.
        /// Параметр навигации доступен в методе LoadState 
        /// в дополнение к состоянию страницы, сохраненному в ходе предыдущего сеанса.

        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            navigationHelper.OnNavigatedTo(e);
            this.MyTheme2 = MyTheme.CurrentTheme;
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            navigationHelper.OnNavigatedFrom(e);
        }

        #endregion

        public static readonly DependencyProperty MyTheme2Property =
        DependencyProperty.Register(
            "MyTheme2",
            typeof(MyTheme),
            typeof(Page), null
        );
        public MyTheme MyTheme2
        {
            get { return (MyTheme)GetValue(MyTheme2Property); }
            set { SetValue(MyTheme2Property, (MyTheme)value); }
        }
    }
}