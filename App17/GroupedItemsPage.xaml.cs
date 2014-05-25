using App17.Common;
using App17.Data;
using App17.Selectors;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// Шаблон элемента страницы сгруппированных элементов задокументирован по адресу http://go.microsoft.com/fwlink/?LinkId=234231

namespace App17
{
    /// <summary>
    /// Страница, на которой отображается сгруппированная коллекция элементов.
    /// </summary>
    public sealed partial class GroupedItemsPage : Page
    {
        private NavigationHelper navigationHelper;
        private ObservableDictionary defaultViewModel = new ObservableDictionary();
        public static bool IsLoggedIn = false;
        private static SampleDataItem selectedItem;

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

        public GroupedItemsPage()
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
            // TODO: Создание соответствующей модели данных для области проблемы, чтобы заменить пример данных
            var sampleDataGroups = await SampleDataSource.GetGroupsAsync();
            this.DefaultViewModel["Groups"] = sampleDataGroups;
        }

        /// <summary>
        /// Вызывается при нажатии заголовка группы.
        /// </summary>
        /// <param name="sender">Объект Button, используемый в качестве заголовка выбранной группы.</param>
        /// <param name="e">Данные о событии, описывающие, каким образом было инициировано нажатие.</param>
        void Header_Click(object sender, RoutedEventArgs e)
        {
            // Определение группы, представляемой экземпляром Button
            var group = (sender as FrameworkElement).DataContext;

            // Переход к соответствующей странице назначения и настройка новой страницы
            // путем передачи необходимой информации в виде параметра навигации
            this.Frame.Navigate(typeof(GroupDetailPage), ((SampleDataGroup)group).UniqueId);
        }

        /// <summary>
        /// Вызывается при нажатии элемента внутри группы.
        /// </summary>
        /// <param name="sender">Объект GridView (или ListView, если приложение прикреплено),
        /// в котором отображается нажатый элемент.</param>
        /// <param name="e">Данные о событии, описывающие нажатый элемент.</param>
        void ItemView_ItemClick(object sender, ItemClickEventArgs e)
        {
            selectedItem = ((SampleDataItem)e.ClickedItem);

            if (selectedItem.Title == "Студент" || selectedItem.Title == "Преподаватель")
            {
                IsLoggedIn = false;
                grdPassword.Visibility = Visibility.Visible;
                AnimationOpened.Begin();
                return;
            }

            doEnter();
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
            this.MyTheme1 = MyTheme.CurrentTheme;
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            navigationHelper.OnNavigatedFrom(e);
        }

        #endregion

        async void DefaultLaunch(string filename)
        {
            filename = filename.Replace('/', '\\');

            var file = await Windows.ApplicationModel.Package.Current.InstalledLocation.GetFileAsync(filename);
            if (file != null)
            {
                // Set the option to show the picker
                var options = new Windows.System.LauncherOptions();
                options.DisplayApplicationPicker = true;
                // Launch the retrieved file
                bool success = await Windows.System.Launcher.LaunchFileAsync(file, options);
                if (success)
                {
                    // File launched
                }
                else
                {
                    // File launch failed
                }
            }
            else
            {
                // Could not find file
            }
        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            IsLoggedIn = true;
            AnimationClosed.Begin();
            doEnter();
        }

        private void btnCancel_Click(object sender, RoutedEventArgs e)
        {
            IsLoggedIn = false;
            AnimationClosed.Begin();
            grdPassword.Visibility = Visibility.Collapsed;
        }

        private void doEnter() 
        {
            if (selectedItem.ItemType == "launch")
            {
                // Возвожно поменять на другое свойство или вообще ввести новое!!!!!!!
                DefaultLaunch(selectedItem.ImagePath);
                return;
            }

            var itemId = selectedItem.UniqueId;
            if (selectedItem.ItemType == "menu")
            {
                if (selectedItem.Title == "Студент")
                {
                    SampleDataSource.SubMenu = "StudentData.json";
                }
                else if (selectedItem.Title == "Преподаватель")
                {
                    SampleDataSource.SubMenu = "TeacherData.json";
                }
                else if (selectedItem.Title == "Гость")
                {
                    SampleDataSource.SubMenu = "GuestData.json";
                }
                else if (selectedItem.Title == "Гость")
                {
                    SampleDataSource.SubMenu = "GuestData.json";
                }

                // GroupId ?
                this.Frame.Navigate(typeof(GroupedItemsPage), itemId);
                return;
            }

            // Переход к соответствующей странице назначения и настройка новой страницы
            // путем передачи необходимой информации в виде параметра навигации
            this.Frame.Navigate(typeof(GroupDetailPage), itemId);

            //Исправить на группы!!!!!!!!!!!!!!!!!!!!

            //var itemId = ((SubjectItem)e.ClickedItem).UniqueId;
            //this.Frame.Navigate(typeof(ItemDetailPage), itemId);
        }

        public static readonly DependencyProperty MyTheme1Property =
        DependencyProperty.Register(
            "MyTheme1",
            typeof(MyTheme),
            typeof(Page), null
        );
        public MyTheme MyTheme1
        {
            get { return (MyTheme)GetValue(MyTheme1Property); }
            set { SetValue(MyTheme1Property, (MyTheme)value); }
        }

        private void lookAndFeelCombo_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (lookAndFeelCombo == null) return;

            //switch (lookAndFeelCombo.SelectedIndex)
            MyTheme.CurrentThemeName = (MyThemesNames) lookAndFeelCombo.SelectedIndex;
            this.MyTheme1 = MyTheme.CurrentTheme;
        }

    }
}