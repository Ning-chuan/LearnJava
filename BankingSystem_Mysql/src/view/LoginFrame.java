package view;

import service.AtmService;
import util.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends BaseFrame {
    //单例模式
    private LoginFrame(){
        super("登录窗口");
        this.init();
    }
    private static LoginFrame loginFrame;
    public synchronized static LoginFrame getLoginFrame(){
        if(loginFrame==null){
            loginFrame = new LoginFrame();
        }
        return loginFrame;
    }

    //添加一个注册窗口 作为属性
    private RegisterFrame registerFrame = null;


    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("老  公  银  行");
    private JLabel accountLabel = new JLabel("请输入账号:");
    private JTextField accountField = new JTextField();
    private JLabel passwordLabel = new JLabel("请输入密码:");
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("登录");
    private JButton registButton = new JButton("注册");



    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(135,40,40,40);
        logoLabel.setIcon(this.drawImage("src//img//Husband.jpg",60,60));
        titleLabel.setBounds(185,40,200,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
        accountLabel.setBounds(40,100,140,40);
        accountLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        accountField.setBounds(170,105,260,32);
        accountField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordLabel.setBounds(40,150,140,40);
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        passwordField.setBounds(170,155,260,32);
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        loginButton.setBounds(120,210,100,32);
        loginButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        registButton.setBounds(260,210,100,32);
        registButton.setFont(new Font("微软雅黑",Font.BOLD,14));
    }

    @Override
    protected void addElements() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(registButton);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户名和密码
                String aname = accountField.getText();
                String apassword = new String(passwordField.getPassword());
                //调用登录方法
                AtmService service = new AtmService();
                String result = service.login(aname,apassword);
                if(result.equals("登录成功")) {
                    LoginFrame.this.setVisible(false);
                    AtmFrame.getAtmFrame(aname);
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        });

        registButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.setVisible(false);
                if(registerFrame==null){
                    registerFrame = RegisterFrame.getRegisterFrame("注册一个老公银行账号");
                }else{
                    registerFrame.cleanText();
                    registerFrame.setVisible(true);
                }
            }
        });
    }

    //设计一个方法 清空所有文本框
    void cleanText(){//默认不写修饰符 适用范围为 同包
        accountField.setText("");
        passwordField.setText("");
    }


    @Override
    protected void setFrameSelf() {
        this.setBounds(700,380,500,340);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }
}
