package testgui;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;

public class TestGUI {
    public static void main(String[] args){
        //frame 最大的窗体  管理方式边界式  中 东 西 南 北    BorderLayout
        //JMenuBar 菜单条  上面  frame.setJMenuBar(bar);
        //Panel  面板  可以有多个  管理方式流式 居中           FlowLayout
        //组件
        //frame.setLayOut(new FlowLayout());    frame.setLayout(null);

        //创建窗体对象
        JFrame frame = new JFrame();
        //创建面板对象
        JPanel panel = new JPanel();

        JLabel userLabel = new JLabel("账号");
        JTextField text = new JTextField(15);//文本框
        JLabel passLabel = new JLabel("密码");
        JPasswordField pass = new JPasswordField(15);//密码框

        JButton button = new JButton("登录");//按钮
        //button.setText("登录");

        //复选框
        JCheckBox box1 = new JCheckBox("抽烟");
        JCheckBox box2 = new JCheckBox("喝酒");
        JCheckBox box3 = new JCheckBox("烫头");

        //单选按钮
        JRadioButton r1 = new JRadioButton("男");
        JRadioButton r2 = new JRadioButton("女");
        //创建一个按钮组 将两个单选按钮添加在一个组里面 才能达到单选的效果
        ButtonGroup group = new ButtonGroup();//注意按钮组并不是组件
        group.add(r1);
        group.add(r2);

        //文本域
        JTextArea area = new JTextArea(10,20);
        //将文本域用窗格包起来 即给文本域添加滚动条
        JScrollPane pane = new JScrollPane(area);//注意包起来之后 往面板添加pane 不用再添加area

        //添加菜单
        JMenuBar bar = new JMenuBar();//菜单条
        JMenu menu = new JMenu("File");//菜单
        JMenuItem item = new JMenuItem("New");//菜单项


        bar.add(menu);//给菜单条添加菜单
        menu.add(item);//给菜单添加菜单项
        //最后只需要把菜单条添加到窗体就好了

        //将创建的项添加到面板上
        panel.add(userLabel);
        panel.add(text);
        panel.add(passLabel);
        panel.add(pass);
        panel.add(button);
        panel.add(box1);
        panel.add(box2);
        panel.add(box3);
        panel.add(r1);
        panel.add(r2);
        panel.add(pane);


        frame.setJMenuBar(bar);//菜单条添加到窗体
        frame.add(panel);//将面板添加到窗体



        //设置窗体基本样式
        frame.setTitle("登录");//标题
        frame.setBounds(500,300,600,350);//窗口位置 大小
        //frame.setResizable(false);//不可拖拽
        frame.setVisible(true);//设置窗口可见
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置✖关闭程序


    }
}
