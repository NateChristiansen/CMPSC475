﻿#pragma checksum "F:\School\CmpSc475\Projects\WindowsPhoneProjects\Clicker\Clicker\MainPage.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "144CE1A86355F3C38B05571B7462CE0B"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Clicker
{
    partial class MainPage : 
        global::Windows.UI.Xaml.Controls.Page, 
        global::Windows.UI.Xaml.Markup.IComponentConnector,
        global::Windows.UI.Xaml.Markup.IComponentConnector2
    {
        /// <summary>
        /// Connect()
        /// </summary>
        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Windows.UI.Xaml.Build.Tasks"," 14.0.0.0")]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void Connect(int connectionId, object target)
        {
            switch(connectionId)
            {
            case 1:
                {
                    global::Windows.UI.Xaml.Controls.RadioButton element1 = (global::Windows.UI.Xaml.Controls.RadioButton)(target);
                    #line 11 "..\..\..\MainPage.xaml"
                    ((global::Windows.UI.Xaml.Controls.RadioButton)element1).Click += this.RadioClick;
                    #line default
                }
                break;
            case 2:
                {
                    global::Windows.UI.Xaml.Controls.RadioButton element2 = (global::Windows.UI.Xaml.Controls.RadioButton)(target);
                    #line 12 "..\..\..\MainPage.xaml"
                    ((global::Windows.UI.Xaml.Controls.RadioButton)element2).Click += this.RadioClick;
                    #line default
                }
                break;
            case 3:
                {
                    global::Windows.UI.Xaml.Controls.RadioButton element3 = (global::Windows.UI.Xaml.Controls.RadioButton)(target);
                    #line 13 "..\..\..\MainPage.xaml"
                    ((global::Windows.UI.Xaml.Controls.RadioButton)element3).Click += this.RadioClick;
                    #line default
                }
                break;
            case 4:
                {
                    this.Score = (global::Windows.UI.Xaml.Controls.TextBox)(target);
                }
                break;
            case 5:
                {
                    global::Windows.UI.Xaml.Controls.CheckBox element5 = (global::Windows.UI.Xaml.Controls.CheckBox)(target);
                    #line 19 "..\..\..\MainPage.xaml"
                    ((global::Windows.UI.Xaml.Controls.CheckBox)element5).Click += this.Negatives;
                    #line default
                }
                break;
            case 6:
                {
                    global::Windows.UI.Xaml.Controls.Button element6 = (global::Windows.UI.Xaml.Controls.Button)(target);
                    #line 16 "..\..\..\MainPage.xaml"
                    ((global::Windows.UI.Xaml.Controls.Button)element6).Click += this.Add;
                    #line default
                }
                break;
            case 7:
                {
                    this.min = (global::Windows.UI.Xaml.Controls.Button)(target);
                    #line 17 "..\..\..\MainPage.xaml"
                    ((global::Windows.UI.Xaml.Controls.Button)this.min).Click += this.Sub;
                    #line default
                }
                break;
            default:
                break;
            }
            this._contentLoaded = true;
        }

        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Windows.UI.Xaml.Build.Tasks"," 14.0.0.0")]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public global::Windows.UI.Xaml.Markup.IComponentConnector GetBindingConnector(int connectionId, object target)
        {
            global::Windows.UI.Xaml.Markup.IComponentConnector returnValue = null;
            return returnValue;
        }
    }
}
