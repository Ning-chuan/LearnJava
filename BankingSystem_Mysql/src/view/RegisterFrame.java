package view;

import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends BaseFrame {

    //单例模式
    private RegisterFrame(String title){
        super(title);
        this.init();
    }
    private static RegisterFrame registerFrame;
    public synchronized static RegisterFrame getRegisterFrame(String title){
        if(registerFrame==null){
            registerFrame = new RegisterFrame(title);
        }
        return registerFrame;

    }


    //添加一个登录页面的属性
    private LoginFrame loginFrame = LoginFrame.getLoginFrame();

    //添加一些组件的属性
    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("请 您 填 写 信 息");//title
    private JLabel accountLabel = new JLabel("请输入账号：");
    private JTextField accountField = new JTextField();//输入账号
    private JLabel passwordLabel = new JLabel("请输入密码：");
    private JTextField passwordField = new JTextField();//注册时密码用 JTextField 使密码可见
    private JLabel balanceLabel = new JLabel("请输入金额：");
    private JTextField balanceField = new JTextField();
    private JButton registButton = new JButton("注 册");
    private JButton resetButton = new JButton("重 置");
    private JButton backButton = new JButton("返 回");


    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(135,40,40,40);
        logoLabel.setIcon(this.drawImage("src//img//Husband.jpg",40,40));
        titleLabel.setBounds(185,40,200,40);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD,24));
        accountLabel.setBounds(40,100,140,40);
        accountLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        accountField.setBounds(170,105,260,32);
        accountField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordLabel.setBounds(40,150,140,40);
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        passwordField.setBounds(170,155,260,32);
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        balanceLabel.setBounds(40,200,140,40);
        balanceLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        balanceField.setBounds(170,205,260,32);
        balanceField.setFont(new Font("微软雅黑",Font.BOLD,20));
        registButton.setBounds(60,260,100,32);
        registButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        resetButton.setBounds(190,260,100,32);
        resetButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        backButton.setBounds(320,260,100,32);
        backButton.setFont(new Font("微软雅黑",Font.BOLD,14));
    }

    @Override
    protected void addElements() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(balanceLabel);
        mainPanel.add(balanceField);
        mainPanel.add(registButton);
        mainPanel.add(resetButton);
        mainPanel.add(backButton);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        registButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的用户名 密码 余额
                String aname = accountField.getText();
                String apassword = passwordField.getText();
                String abalance = balanceField.getText();
                //获取一个AtmService对象
                AtmService service = MySpring.getBean("service.AtmService");
                if(service.isExist(aname)){
                    JOptionPane.showMessageDialog(RegisterFrame.this,"用户名已存在");
                    RegisterFrame.this.cleanText();
                }else{
                    try{
                        service.register(aname,apassword,Float.parseFloat(abalance));
                        //上一行 如果abalance输入有误 会出现NumberFormatException 我们用 try catch 处理一下
                        JOptionPane.showMessageDialog(RegisterFrame.this,"注册成功，请返回并登录");
                        RegisterFrame.this.back();
                    }catch(Exception ep){
                        JOptionPane.showMessageDialog(RegisterFrame.this,"非法输入");
                        RegisterFrame.this.cleanText();
                    }
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterFrame.this.cleanText();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterFrame.this.back();
            }
        });
    }

    //设计一个方法 清空所有文本框
    void cleanText(){//默认不写修饰符 适用范围为 同包
        accountField.setText("");
        passwordField.setText("");
        balanceField.setText("");
    }
    //设计一个方法 退回登录窗口
    private void back(){
        RegisterFrame.this.cleanText();
        registerFrame.setVisible(false);
        loginFrame.setVisible(true);
        loginFrame.cleanText();
    }



    @Override
    protected void setFrameSelf() {
        this.setBounds(700,320,480,370);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭后隐藏窗口
        this.setResizable(false);
        this.setVisible(true);
    }
}
