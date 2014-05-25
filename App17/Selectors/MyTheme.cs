using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace App17.Selectors
{
    public class MyTheme
    {
        public Brush LogoBrush { get; set; }
        public Brush BackBrush { get; set; }
        public Brush TileBackBrush { get; set; }
        public Brush TileFrontBrush { get; set; }
        public Brush PopupBrush { get; set; }


        private static List<MyTheme> myThemeStaticList = new List<MyTheme>() 
                {
                    new MyTheme()
                    {
                        LogoBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FF1857DC"" Offset=""0""/>
                                <GradientStop Color=""#FFC0CFF0"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        BackBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFE4EAF7""/>
                                <GradientStop Color=""#FFECF0F9"" Offset=""0.142""/>
                                <GradientStop Color=""#FFD0DAF5"" Offset=""0.582""/>
                                <GradientStop Color=""#FF95AFE8"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        TileBackBrush = new SolidColorBrush(Color.FromArgb(255,7,7,66)),
                        TileFrontBrush = new SolidColorBrush(Colors.Red),
                        PopupBrush = new SolidColorBrush(Colors.Plum)
                    },
                    new MyTheme()
                    {
                        LogoBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFFF1800"" Offset=""0""/>
                                <GradientStop Color=""#FFFF8C69"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        BackBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFFFE5E3"" Offset=""0""/>
                                <GradientStop Color=""#FFF9A58A"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        TileBackBrush = new SolidColorBrush(Color.FromArgb(255,71,3,0)),
                        TileFrontBrush = new SolidColorBrush(Colors.WhiteSmoke),
                        PopupBrush = new SolidColorBrush(Colors.Wheat)
                    },
                    new MyTheme()
                    {
                        LogoBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FF019E06"" Offset=""0""/>
                                <GradientStop Color=""#FFA0F991"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        BackBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFE7F5E7"" Offset=""0""/>
                                <GradientStop Color=""#FF99F789"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        TileBackBrush = new SolidColorBrush(Color.FromArgb(255,10,58,2)),
                        TileFrontBrush = new SolidColorBrush(Colors.Olive),
                        PopupBrush = new SolidColorBrush(Colors.PowderBlue)
                    },
                    new MyTheme()
                    {
                        LogoBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFF55900"" Offset=""0""/>
                                <GradientStop Color=""#FFF7C9A3"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        BackBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFF9F1EC"" Offset=""0""/>
                                <GradientStop Color=""#FFFBBA85"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        TileBackBrush = new SolidColorBrush(Color.FromArgb(255,50,21,0)),
                        TileFrontBrush = new SolidColorBrush(Colors.Red),
                        PopupBrush = new SolidColorBrush(Colors.Plum)
                    },
                    new MyTheme()
                    {
                        LogoBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FF08B6B6"" Offset=""0""/>
                                <GradientStop Color=""#FFAAF8F9"" Offset=""0.987""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        BackBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFF7FDFD"" Offset=""0""/>
        <GradientStop Color=""#FFC4F3F3"" Offset=""0.987""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        TileBackBrush = new SolidColorBrush(Color.FromArgb(255,3,104,104)),
                        TileFrontBrush = new SolidColorBrush(Colors.Red),
                        PopupBrush = new SolidColorBrush(Colors.Plum)
                    },
                    new MyTheme()
                    {
                        LogoBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FF9711B6"" Offset=""0""/>
                                <GradientStop Color=""#FFEE96E6"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        BackBrush = XamlReader.Load(
                            @"<LinearGradientBrush 
                                    xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'
                                    EndPoint=""0.5,1"" StartPoint=""0.5,0"">
                                <GradientStop Color=""#FFF8ECFB"" Offset=""0""/>
                                <GradientStop Color=""#FFE8AEE3"" Offset=""0.993""/>
                            </LinearGradientBrush>"
                        ) as LinearGradientBrush,
                        TileBackBrush = new SolidColorBrush(Color.FromArgb(255,68,1,62)),
                        TileFrontBrush = new SolidColorBrush(Colors.Red),
                        PopupBrush = new SolidColorBrush(Colors.Plum)
                    }
                };

        public static MyThemesNames CurrentThemeName { get; set; }

        public static MyTheme CurrentTheme 
        {
            get
            {
                return myThemeStaticList[(int)CurrentThemeName];
            }
        }
    }

    public enum MyThemesNames 
    {
        Blue,
        Red,
        Green,
        Orange,
        Cyan,
        Violet
    }
}
