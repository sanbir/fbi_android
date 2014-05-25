using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Markup;
using App17.Data;

namespace App17.Selectors
{
    class MyTileSelector : DataTemplateSelector
    {
        protected override DataTemplate SelectTemplateCore(object item, DependencyObject container)
        {
            SampleDataItem selectedItem = item as SampleDataItem;
            String template;
            
            if (selectedItem.Icon == "")
            {
                template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                <Grid HorizontalAlignment=""Left"" Width=""150"" Height=""150"">
                    <Border Background=""{Binding Path=MyTheme1.TileBackBrush, ElementName=pageRoot}"">
                        <Image Source=""{Binding ImagePath}"" Stretch=""UniformToFill"" AutomationProperties.Name=""{Binding Title}""/>
                    </Border>
                    <StackPanel VerticalAlignment=""Bottom"" Background=""{StaticResource ListViewItemOverlayBackgroundThemeBrush}"">
                        <TextBlock Text=""{Binding Title}"" Foreground=""{StaticResource ListViewItemOverlayForegroundThemeBrush}"" Style=""{StaticResource TitleTextStyle}"" Height=""60"" Margin=""15,0,15,0""/>
                        <TextBlock Text=""{Binding Subtitle}"" Foreground=""{StaticResource ListViewItemOverlaySecondaryForegroundThemeBrush}"" Style=""{StaticResource CaptionTextStyle}"" TextWrapping=""NoWrap"" Margin=""15,0,15,10""/>
                    </StackPanel>
                </Grid>
            </DataTemplate>";
            }
            else
            {
                if (SampleDataSource.SubMenu == "StartData.json")
                {
                    template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                                    <Grid HorizontalAlignment=""Left"" Width=""250"" Height=""250"">
                                        <Border Background=""{Binding Path=MyTheme1.TileBackBrush, ElementName=pageRoot}"">
                                            <Viewbox Margin=""10"" HorizontalAlignment=""Center"" VerticalAlignment=""Center"">
                                                <Path Fill=""{Binding Path=MyTheme1.LogoBrush, ElementName=pageRoot}"" Data=""{Binding Icon}"" 
                                                                            Stretch=""Uniform""  
                                                                            Width=""26"" Height=""26"" 
                                                                            Margin=""0"" RenderTransformOrigin=""0.5,0.5"">
                                                </Path>
                                            </Viewbox>
                                        </Border>
                                        <StackPanel VerticalAlignment=""Bottom"" Background=""{StaticResource ListViewItemOverlayBackgroundThemeBrush}"">
                                            <TextBlock Text=""{Binding Title}"" Foreground=""{StaticResource ListViewItemOverlayForegroundThemeBrush}"" Style=""{StaticResource TitleTextStyle}"" Height=""60"" Margin=""15,0,15,0""/>
                                            <TextBlock Text=""{Binding Subtitle}"" Foreground=""{StaticResource ListViewItemOverlaySecondaryForegroundThemeBrush}"" Style=""{StaticResource CaptionTextStyle}"" TextWrapping=""NoWrap"" Margin=""15,0,15,10""/>
                                        </StackPanel>
                                    </Grid>
                                </DataTemplate>";
                }
                else 
                {
                    template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                                    <Grid HorizontalAlignment=""Left"" Width=""150"" Height=""150"">
                                        <Border Background=""{Binding Path=MyTheme1.TileBackBrush, ElementName=pageRoot}"">
                                            <Viewbox Margin=""10"" HorizontalAlignment=""Center"" VerticalAlignment=""Center"">
                                                <Path Fill=""{Binding Path=MyTheme1.LogoBrush, ElementName=pageRoot}"" Data=""{Binding Icon}"" 
                                                                            Stretch=""Uniform""  
                                                                            Width=""26"" Height=""26"" 
                                                                            Margin=""0"" RenderTransformOrigin=""0.5,0.5"">
                                                </Path>
                                            </Viewbox>
                                        </Border>
                                        <StackPanel VerticalAlignment=""Bottom"" Background=""{StaticResource ListViewItemOverlayBackgroundThemeBrush}"">
                                            <TextBlock Text=""{Binding Title}"" Foreground=""{StaticResource ListViewItemOverlayForegroundThemeBrush}"" Style=""{StaticResource TitleTextStyle}"" Height=""60"" Margin=""15,0,15,0""/>
                                            <TextBlock Text=""{Binding Subtitle}"" Foreground=""{StaticResource ListViewItemOverlaySecondaryForegroundThemeBrush}"" Style=""{StaticResource CaptionTextStyle}"" TextWrapping=""NoWrap"" Margin=""15,0,15,10""/>
                                        </StackPanel>
                                    </Grid>
                                </DataTemplate>";
                }
            }

            return XamlReader.Load(template) as DataTemplate;
        }
    }
}
