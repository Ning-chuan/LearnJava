package util;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {
    //模板模式

    public BaseFrame(){}
    public BaseFrame(String title){
        super(title);
    }

    protected void init(){
        this.setFontAndSoOn();
        this.addElements();
        this.addListener();
        this.setFrameSelf();
    }

    //设计一个通用的画图方法
    protected ImageIcon drawImage(String path,int width,int height){
        //通过给定路径创建一个icon对象
        ImageIcon imageIcon = new ImageIcon(path);
        //设置icon对象内的image对象信息
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        return imageIcon;
    }


    //设置字体 颜色 背景 布局管理等等
    protected abstract void setFontAndSoOn();
    //添加组件
    protected abstract void addElements();
    //添加事件监听器
    protected abstract void addListener();
    //设置窗体自身属性
    protected abstract void setFrameSelf();



}
