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
    class MyItemTemlateSelector : DataTemplateSelector
    {
        protected override DataTemplate SelectTemplateCore(object item, DependencyObject container)
        {
            SampleDataItem selectedItem = item as SampleDataItem;
            String template;

            if (selectedItem.ItemType == "browser") 
            {
                template = @"
                <DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <WebView Source="""
                    + selectedItem.ImagePath
                    + @""" />
                </DataTemplate>";
            }
            else if (selectedItem.ItemType == "photo")
            {
                template = @"
                <DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <Image Source=""{Binding ImagePath}"" />
                </DataTemplate>";
            }
            else if (selectedItem.ItemType == "user")
            {
                template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation' xmlns:common='using:App17.Common'>
                        <ScrollViewer Style=""{StaticResource HorizontalScrollViewerStyle}"" Grid.Row=""1"">
                            <common:RichTextColumns Margin=""117,0,117,47"" VerticalAlignment=""Top"">
                                <RichTextBlock Width=""560"" Style=""{StaticResource ItemRichTextStyle}"" IsTextSelectionEnabled=""False"">
                                    <Paragraph>
                                        <Run FontSize=""26.667"" FontWeight=""Light"" Text=""{Binding Title}""/>
                                        <LineBreak/>
                                        <LineBreak/>
                                        <Run FontWeight=""Normal"" Text=""{Binding Subtitle}""/>
                                    </Paragraph>
                                    <Paragraph LineStackingStrategy=""MaxHeight"">
                                        <InlineUIContainer>
                                            <Image MaxHeight=""480"" Width=""300"" Margin=""0,20,0,10"" Stretch=""Uniform"" Source=""{Binding ImagePath}"" AutomationProperties.Name=""{Binding Title}""/>
                                        </InlineUIContainer>
                                    </Paragraph>
                                    <Paragraph>
                                        <Run FontWeight=""SemiLight"" Text=""{Binding Content}""/>
                                    </Paragraph>
                                </RichTextBlock>
                                <common:RichTextColumns.ColumnTemplate>
                                    <DataTemplate>
                                        <RichTextBlockOverflow Width=""560"" Margin=""80,0,0,0"">
                                            <RichTextBlockOverflow.RenderTransform>
                                                <TranslateTransform X=""-1"" Y=""4""/>
                                            </RichTextBlockOverflow.RenderTransform>
                                        </RichTextBlockOverflow>
                                    </DataTemplate>
                                </common:RichTextColumns.ColumnTemplate>
                            </common:RichTextColumns>
                        </ScrollViewer>
                    </DataTemplate>";
            }
            else if (selectedItem.ItemType == "launch")
            {
                template = @"
                <DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <Button Content=""Открыть документ"" HorizontalAlignment=""Center"" VerticalAlignment=""Center"" FontSize=""40""  />
                </DataTemplate>";
            }
            else if (selectedItem.ItemType == "table") 
            {
                if (selectedItem.Title == "Бакалавриат")
                {
                    template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <ScrollViewer Style=""{StaticResource HorizontalScrollViewerStyle}"" Grid.Row=""1"">
                        <Grid>
                            <Grid.RowDefinitions>
                                <RowDefinition Height=""50""/>
                                <RowDefinition Height=""*""/>
                            </Grid.RowDefinitions>
                            <TextBlock Style=""{StaticResource PageSubheaderTextStyle}"" Margin=""70,0"">План набора на бакалавриат</TextBlock>
                            <StackPanel Orientation=""Horizontal"" Margin=""70"" Grid.Row=""1"">
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Направления и профиль</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"">Информационные системы и технологии</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"">Прикладная информатика</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"">Менеджмент Логистика и управление цепями поставок</TextBlock>
                                </StackPanel>
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Полное возмещение затрат</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">30</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">35</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">75</TextBlock>
                                </StackPanel>
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Бюджетное финансирование</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">20</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">15</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">8</TextBlock>
                                </StackPanel>
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Всего</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">50</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">50</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">83</TextBlock>
                                </StackPanel>
                            </StackPanel>
                        </Grid>
                    </ScrollViewer>
                </DataTemplate>";
                }
                else if (selectedItem.Title == "Магистратура")
                {
                    template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <ScrollViewer Style=""{StaticResource HorizontalScrollViewerStyle}"" Grid.Row=""1"">
                        <Grid>
                            <Grid.RowDefinitions>
                                <RowDefinition Height=""50""/>
                                <RowDefinition Height=""*""/>
                            </Grid.RowDefinitions>
                            <TextBlock Style=""{StaticResource PageSubheaderTextStyle}"" Margin=""70,0"">План набора в магистратуру</TextBlock>
                            <StackPanel Orientation=""Horizontal"" Margin=""70,50"" Grid.Row=""1"">
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Направления и профиль</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"">Информационные системы и технологии</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"">Менеджмент Логистика и управление цепями поставок</TextBlock>
                                </StackPanel>
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Полное возмещение затрат</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">5</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">8</TextBlock>
                                </StackPanel>
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Бюджетное финансирование</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">5</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">2</TextBlock>
                                </StackPanel>
                                <StackPanel>
                                    <TextBlock Style=""{StaticResource GroupHeaderTextStyle}"" Margin=""10"">Всего</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">10</TextBlock>
                                    <TextBlock Style=""{StaticResource TitleTextBlockStyle}"" Margin=""10"" TextAlignment=""Center"">10</TextBlock>
                                </StackPanel>
                            </StackPanel>
                        </Grid>
                    </ScrollViewer>
                </DataTemplate>";
                }
                else
                {
                    template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <TextBox Text=""Элемент отображается неправильно"" FontSize=""50"" />
                </DataTemplate>";
                }
            }
            else
            {
                template = @"<DataTemplate xmlns='http://schemas.microsoft.com/winfx/2006/xaml/presentation'>
                    <TextBox Text=""Элемент отображается неправильно"" FontSize=""50"" />
                </DataTemplate>";
            }

            return XamlReader.Load(template) as DataTemplate;
        }
    }
}
