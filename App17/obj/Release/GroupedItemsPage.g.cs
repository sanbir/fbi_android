﻿

#pragma checksum "C:\Users\Alex.Alex-PC\Source\Repos\infokioskfbi\App17\GroupedItemsPage.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "2C50543BA214F1BA46580A75D4A5BC35"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace App17
{
    partial class GroupedItemsPage : global::Windows.UI.Xaml.Controls.Page, global::Windows.UI.Xaml.Markup.IComponentConnector
    {
        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Windows.UI.Xaml.Build.Tasks"," 4.0.0.0")]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
 
        public void Connect(int connectionId, object target)
        {
            switch(connectionId)
            {
            case 1:
                #line 157 "..\..\GroupedItemsPage.xaml"
                ((global::Windows.UI.Xaml.Controls.ListViewBase)(target)).ItemClick += this.ItemView_ItemClick;
                 #line default
                 #line hidden
                break;
            case 2:
                #line 336 "..\..\GroupedItemsPage.xaml"
                ((global::Windows.UI.Xaml.Controls.Primitives.ButtonBase)(target)).Click += this.btnLogin_Click;
                 #line default
                 #line hidden
                break;
            case 3:
                #line 354 "..\..\GroupedItemsPage.xaml"
                ((global::Windows.UI.Xaml.Controls.Primitives.ButtonBase)(target)).Click += this.btnCancel_Click;
                 #line default
                 #line hidden
                break;
            case 4:
                #line 215 "..\..\GroupedItemsPage.xaml"
                ((global::Windows.UI.Xaml.Controls.Primitives.Selector)(target)).SelectionChanged += this.lookAndFeelCombo_SelectionChanged;
                 #line default
                 #line hidden
                break;
            case 5:
                #line 182 "..\..\GroupedItemsPage.xaml"
                ((global::Windows.UI.Xaml.Controls.Primitives.ButtonBase)(target)).Click += this.Header_Click;
                 #line default
                 #line hidden
                break;
            }
            this._contentLoaded = true;
        }
    }
}

