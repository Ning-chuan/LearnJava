package view;

import domain.User;
import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmFrame extends BaseFrame {
    //单例模式
    private AtmFrame(String aname){
        super("操作窗口");
        this.aname = aname;
        this.init();
    }
    private static AtmFrame atmFrame;
    public synchronized static AtmFrame getAtmFrame(String aname){
        if(atmFrame==null){
            atmFrame = new AtmFrame(aname);
        }
        return atmFrame;
    }


    //添加一个用户名 用来管理登录进来的用户
    private String aname;
    //添加一个AtmService对象 支持各种业务
    private AtmService service = MySpring.getBean("service.AtmService");


    //添加窗体上的组件
    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("欢迎进入你的老公银行!");
    private JLabel balanceLabelCN = new JLabel();
    private JLabel balanceLabelEN = new JLabel();
    private JLabel selectServerLabelCN = new JLabel("您好!请选择所需服务");
    private JLabel selectServerLabelEN = new JLabel("Please choose your service");
    private JButton logoutButton = new JButton("注销账户");
    private JButton exitButton = new JButton("退出");
    private JButton depositButton = new JButton("存款");
    private JButton withdrawalButton = new JButton("取款");
    private JButton transferButton = new JButton("转账");

    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(20,20,80,80);
        logoLabel.setIcon(this.drawImage("src//img//Husband.jpg",100,100));
        titleLabel.setBounds(120,30,400,60);
        titleLabel.setFont(new Font("微软雅黑",Font.ITALIC,32));

        balanceLabelCN.setBounds(250,200,300,40);
        balanceLabelCN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balanceLabelCN.setText("账户余额:￥"+service.inquireBalance(aname));
        balanceLabelCN.setHorizontalAlignment(JTextField.CENTER);
        balanceLabelEN.setBounds(200,240,400,40);
        balanceLabelEN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balanceLabelEN.setText("Account Balance:￥"+service.inquireBalance(aname));
        balanceLabelEN.setHorizontalAlignment(JTextField.CENTER);

        selectServerLabelCN.setBounds(250,370,300,40);
        selectServerLabelCN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelCN.setHorizontalAlignment(JTextField.CENTER);
        selectServerLabelEN.setBounds(250,400,300,40);
        selectServerLabelEN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelEN.setHorizontalAlignment(JTextField.CENTER);

        logoutButton.setBounds(10,150,120,40);
        logoutButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        logoutButton.setBackground(Color.lightGray);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        exitButton.setBounds(10,390,120,40);
        exitButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        exitButton.setBackground(Color.lightGray);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        depositButton.setBounds(670,150,120,40);
        depositButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        depositButton.setBackground(Color.lightGray);
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        withdrawalButton.setBounds(670,270,120,40);
        withdrawalButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        withdrawalButton.setBackground(Color.lightGray);
        withdrawalButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        transferButton.setBounds(670,390,120,40);
        transferButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        transferButton.setBackground(Color.lightGray);
        transferButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void addElements() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(balanceLabelCN);
        mainPanel.add(balanceLabelEN);
        mainPanel.add(selectServerLabelCN);
        mainPanel.add(selectServerLabelEN);
        mainPanel.add(logoutButton);
        mainPanel.add(exitButton);
        mainPanel.add(depositButton);
        mainPanel.add(withdrawalButton);
        mainPanel.add(transferButton);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {

        //退出
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(AtmFrame.this,"您确认退出银行吗？");
                if(result==0) {
                    System.exit(0);
                }
            }
        });


        //注销
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(AtmFrame.this,"您确认注销账户吗？");
                if(result==0) {
                    if(service.logout(aname)==1){
                        JOptionPane.showMessageDialog(AtmFrame.this,"注销成功");
                        System.exit(0);
                    }else{
                        JOptionPane.showMessageDialog(AtmFrame.this,"注销失败");
                    }
                }
            }
        });


        //转账
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inName = JOptionPane.showInputDialog(AtmFrame.this,"请您输入转入账户：");
                    if(inName!=null && !"".equals(inName) && service.isExist(inName)) {
                        String value = JOptionPane.showInputDialog(AtmFrame.this,"请您输入转账金额：");
                        if (value != null && !"".equals(value)) {
                            Float transferMoney = Float.parseFloat(value);
                            if (transferMoney <= 0) {
                                throw new NumberFormatException();
                            }
                            int result = service.transferMoney(aname,inName, transferMoney);
                            if (result == 2) {
                                JOptionPane.showMessageDialog(AtmFrame.this, "转账成功！");
                                balanceLabelCN.setText("账户余额:￥" + service.inquireBalance(aname));
                                balanceLabelEN.setText("Account Balance:￥" + service.inquireBalance(aname));
                            } else if (result == -1) {
                                JOptionPane.showMessageDialog(AtmFrame.this, "您的余额不足");
                            } else {
                                JOptionPane.showMessageDialog(AtmFrame.this, "取款失败！");
                            }
                        }else{
                            JOptionPane.showMessageDialog(AtmFrame.this,"输入不能为空！");
                        }
                    }else{
                        JOptionPane.showMessageDialog(AtmFrame.this,"江湖无此人");
                    }
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(AtmFrame.this,"非法输入");
                }
            }
        });


        //取款
        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String value = JOptionPane.showInputDialog(AtmFrame.this,"请您输入取款金额：");
                    if(value!=null && !"".equals(value) ){
                        Float withdrawalMoney = Float.parseFloat(value);
                        if(withdrawalMoney<=0){
                            throw new NumberFormatException();
                        }
                        int result = service.withdrawalMoney(aname,withdrawalMoney);
                        if(result==1){
                            JOptionPane.showMessageDialog(AtmFrame.this,"取款成功！");
                            balanceLabelCN.setText("账户余额:￥"+service.inquireBalance(aname));
                            balanceLabelEN.setText("Account Balance:￥"+service.inquireBalance(aname));
                        }else if(result==-1){
                            JOptionPane.showMessageDialog(AtmFrame.this,"您的余额不足");
                        }else{
                            JOptionPane.showMessageDialog(AtmFrame.this,"取款失败！");
                        }
                    }else{
                        JOptionPane.showMessageDialog(AtmFrame.this,"输入不能为空！");
                    }
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(AtmFrame.this,"非法输入");
                }
            }
        });


        //存款
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String value = JOptionPane.showInputDialog(AtmFrame.this,"请您输入存款金额：");
                    if(value!=null && !"".equals(value) ){
                        Float depositMoney = Float.parseFloat(value);
                        if(depositMoney<=0){
                            throw new NumberFormatException();
                        }
                        int result = service.depositMoney(aname,depositMoney);
                        if(result==1){
                            JOptionPane.showMessageDialog(AtmFrame.this,"存款成功！");
                            balanceLabelCN.setText("账户余额:￥"+service.inquireBalance(aname));
                            balanceLabelEN.setText("Account Balance:￥"+service.inquireBalance(aname));
                        }else{
                            JOptionPane.showMessageDialog(AtmFrame.this,"存款失败！");
                        }
                    }else{
                        JOptionPane.showMessageDialog(AtmFrame.this,"输入不能为空！");
                    }
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(AtmFrame.this,"非法输入");
                }
            }
        });
    }

    @Override
    protected void setFrameSelf() {
        this.setBounds(570,230,800,520);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
