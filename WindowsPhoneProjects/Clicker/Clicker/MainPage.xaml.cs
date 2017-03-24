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
        private int _amt = 1;
        private readonly Counter _ctr;
        public MainPage()
        {
            this.InitializeComponent();
            _ctr = new Counter();
        }

        private void RadioClick(object sender, RoutedEventArgs e)
        {
            var content = ((RadioButton) sender).Content;
            if (content != null) _amt = int.Parse(content.ToString());
        }

        private void Add(object sender, RoutedEventArgs e)
        {
            Score.Text = _ctr.Add(_amt).ToString();
        }

        private void Sub(object sender, RoutedEventArgs e)
        {
            Score.Text = _ctr.Sub(_amt).ToString();
        }

        private void Negatives(object sender, RoutedEventArgs e)
        {
            Score.Text = _ctr.ToggleNeg().ToString();
        }
    }

    public class Counter
    {
        private int _count;
        private bool _negatives;

        public Counter()
        {
            _count = 0;
        }

        public int Add(int i)
        {
            _count += i;
            return _count;
        }

        public int Sub(int i)
        {
            if (_count >= i || _negatives) _count -= i;
            else _count = 0;
            return _count;
        }

        public int ToggleNeg()
        {
            _negatives = !_negatives;
            if (!_negatives && _count < 0) _count = 0;
            return _count;
        }
    }
}
