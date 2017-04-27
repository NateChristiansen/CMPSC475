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
        Expression exp = new Expression();
        public MainPage()
        {
            this.InitializeComponent();
        }

        private void Number(object sender, RoutedEventArgs e)
        {
            string num = ((Button) sender).Content.ToString();
            string curval = Display.Text;
            if (curval.Equals("0"))
                Display.Text = num;
            else
                Display.Text = curval + num;
        }

        private void Equals(object sender, RoutedEventArgs e)
        {
            string curval = Display.Text;
            exp.operand2 = int.Parse(curval);
            Display.Text = exp.getValue().ToString();
        }

        private void Operator(object sender, RoutedEventArgs e)
        {
            string op = ((Button) sender).Content.ToString();
            string curval = Display.Text;
            exp.operand1 = int.Parse(curval);
            exp.op = op;
            Display.Text = "0";
        }

        private void Clear(object sender, RoutedEventArgs e)
        {
            exp = new Expression();
            Display.Text = "0";
        }
    }
    public class Expression
    {
        public int operand1, operand2;
        private int value;
        public String op;

        public Expression()
        {
            operand1 = 0;
            operand2 = 0;
            value = 0;
                op = "+";
        }

        public int getValue()
        {
            computeValue();
            return value;
        }
        private void computeValue()
        {
            value = 0;
            if (op.Equals("+"))
            value = operand1 + operand2;
            else if (op.Equals("-"))
            value = operand1 - operand2;
            else if (op.Equals("x"))
            value = operand1 * operand2;
            else if (op.Equals("/") && operand2 != 0)
            value = operand1 / operand2;
            else if (op.Equals("^"))
            value = (int)Math.Pow(operand1, operand2);
            else if (op.Equals("%") && operand2 != 0)
            value = operand1 % operand2;
            else if (op.Equals("Rand"))
            {
                int rand = new Random().Next(0, 3);
                if (rand == 0)
                    value = operand1 + operand2;
                else if (rand == 1)
                    value = operand1 - operand2;
                else if (rand == 2)
                    value = operand1 * operand2;
                else if (rand == 3)
                    value = (int)Math.Pow(operand1, operand2);
            }
            else
            value = 0;
        }
    }

}
