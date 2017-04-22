using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace Clicker
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private const decimal CASE = 1, TAX = (decimal) .05, INSURANCE = 2;
        decimal[] costs = {9, 7, 10, 5};
        private string numcase, numinst;
        private int pos = 0;

        public MainPage()
        {
            this.InitializeComponent();
        }

        private void DropDownChange(object sender, SelectionChangedEventArgs e)
        {
            try
            {
                string selection = ((ComboBoxItem) e.AddedItems[0]).Content.ToString();
                ItemType.Text = selection;
                pos = ((ComboBox) sender).SelectedIndex;
                calculate();
            }
            catch { }
        }

        private void RentalChange(object sender, TextChangedEventArgs e)
        {
            numinst = ((TextBox) sender).Text;
            calculate();
        }

        private void calculate()
        {
            int banjos = 0, cases = 0;
            try
            {
                banjos = int.Parse(numinst);
            }
            catch
            {
                banjos = 0;
            }
            try
            {
                cases = int.Parse(numcase);
            }
            catch
            {
                cases = 0;
            }

            decimal basecost = banjos * costs[pos] + cases * CASE;
            decimal tax = basecost * TAX;
            decimal ins = InsSwitch.IsOn ? INSURANCE * banjos : 0;
            decimal tot = basecost + tax + ins;

            BaseCost.Text = string.Format("{0:C2}", basecost);
            Tax.Text = string.Format("{0:C2}", tax);
            Insurance.Text = string.Format("{0:C2}", ins);
            Total.Text = string.Format("{0:C2}", tot);
        }

        private void TextBox_OnTextChanged(object sender, TextChangedEventArgs e)
        {
            numcase = ((TextBox)sender).Text;
            calculate();
        }

        private void InsSwitch_OnToggled(object sender, RoutedEventArgs e)
        {
            calculate();
        }
    }
}
