package com.lzy.sql;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
  
import com.lzy.adm.Adm_1;
import com.lzy.adm.Adm_5;
import com.lzy.stuExam.StuExam;
import com.lzy.stuExam.StuThread;
  
public class GetSQL {
    static Connection ct;
    static PreparedStatement ps;
    static ResultSet rs;
    public static String name;
    public static String pwd;
    public static boolean k;
    public static String num;
    public static String question;
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String answers;
    public static int maxrow;
    public static int j=0;
    public static String [] answersArray;
      
    //连接数据库
    public static void connectSQL(){
        try {
            ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=exam_db", "sa", "1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //查找用户，密码（管理员）
    public static void adm(String s){
        try {
            ps=ct.prepareStatement("select * from adm where 管理员=?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                pwd=rs.getString(2);
            }else {
                JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
      
    //查找用户，密码（学生）
    public static void stu(String s){
        try {
            ps=ct.prepareStatement("select * from stu where 学号=?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                pwd=rs.getString(2);
            }else {
                JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
      
    //查看信息
    public static void qadm_1(){
        int s=0;
        try {
            ps=ct.prepareStatement("select * from stu");
            rs=ps.executeQuery();
            while(rs.next()){
                name=rs.getString(1);
                pwd=rs.getString(2);
                Adm_1.prit(s);
                s++;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //学号重复
    public static  void qadm_2(String s){
        try {
            ps=ct.prepareStatement("select * from stu where 学号 =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "学号重复，请重新输入!");
                k=false;
            }else{
                k=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //添加信息
    public static void qadm_2(String s1,String s2){
        try {
            ps=ct.prepareStatement("insert into stu values(?,?)");
            ps.setString(1, s1);
            ps.setString(2, s2);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "添加成功");
            }else {
                JOptionPane.showMessageDialog(null, "添加失败");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //学号不存在
    public static void qadm_3(String s){
        try {
            ps=ct.prepareStatement("select * from stu where 学号 =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                k=true;
            }else{
                JOptionPane.showMessageDialog(null, "学号不存在");
                k=false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //修改信息
    public static void qadm_3(String s1, String s2){
        // TODO Auto-generated method stub
        try {
            ps=ct.prepareStatement("update stu set 密码 = ? where 学号 =?");
            ps.setString(1, s2);
            ps.setString(2, s1);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "修改成功");
            }else {
                JOptionPane.showMessageDialog(null, "修改失败，请重新输入");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //删除信息
    public static void qadm_4(String s) {
        try {
            ps=ct.prepareStatement("delete from stu  where 学号=?");
            ps.setString(1, s);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "删除成功");
            }else {
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  
    //查看试题
    public static void qadm_5(){
        int s=0;
        try {
            ps=ct.prepareStatement("select * from question");
            rs=ps.executeQuery();
            while(rs.next()){
                num=rs.getString(1);
                question=rs.getString(2);
                A=rs.getString(3);
                B=rs.getString(4);
                C=rs.getString(5);
                D=rs.getString(6);
                answers=rs.getString(7);
                Adm_5.prit(s);
                s++;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //试题号是否重复
    public static  void qadm_6(String s){
        try {
            ps=ct.prepareStatement("select * from question where 试题序号 =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "学号重复，请重新输入!");
                k=false;
            }else{
                k=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //添加试题
    public static void qadm_6(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        try {
            ps=ct.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setString(3, s3);
            ps.setString(4, s4);
            ps.setString(5, s5);
            ps.setString(6, s6);
            ps.setString(7, s7);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "添加成功");
            }else {
                JOptionPane.showMessageDialog(null, "添加失败");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //试题号是否存在
    public static void qadm_7(String s){
        try {
            ps=ct.prepareStatement("select * from question where 试题序号 =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                k=true;
            }else{
                JOptionPane.showMessageDialog(null, "试题序号不存在");
                k=false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //修改试题
    public static void qadm_7(String s1,String s2,String s3,String s4){//试题序号，修改属性，修改内容，正确答案
        try {
            ps=ct.prepareStatement("update question  set "+s2+" = ? ,正确答案=? where 试题序号=?");
            ps.setString(1, s3);
            ps.setString(2, s4);
            ps.setString(3, s1);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "修改成功", "提示消息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "修改失败，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //删除试题
    public static void qadm_8(String s) {
        try {
            ps=ct.prepareStatement("delete from question  where 试题序号=?");
            ps.setString(1, s);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "删除成功");
            }else {
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //考生修改密码
    public static void stu_1(String s1, String s2, String s3, String s4) {
        // TODO Auto-generated method stub
        try {
            ps=ct.prepareStatement("select * from stu  where 学号 =? and 密码=?");
            ps.setString(1, s1);
            ps.setString(2, s2);
            rs=ps.executeQuery();
            if(rs.next()){
                k=true;
            }else{
                JOptionPane.showMessageDialog(null, "原始密码错误，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
                k=false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(k){
            if(s3.equals(s4)){
                try {
                    ps=ct.prepareStatement("update stu  set 密码 = ? where 学号 =?");
                    ps.setString(1, s3);
                    ps.setString(2, s1);
                    int m=ps.executeUpdate();
                    if(m!=0){
                        JOptionPane.showMessageDialog(null, "修改成功");
                    }else {
                        JOptionPane.showMessageDialog(null, "修改失败，请重新输入");
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(null, "新密码输入不一致，请重新输入");
            }
        }
    }
      
    //获取试题最大行数
    public static void getMaxRow(){
        try {
            ps=ct.prepareStatement("select * from question");
            rs=ps.executeQuery();
            while(rs.next()){
                maxrow=rs.getRow();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //记录正确答案
    public static void readAnswers(){
        getMaxRow();
        answersArray=new String[maxrow];
        try {
            ps=ct.prepareStatement("select * from question");
            rs=ps.executeQuery();
            while(rs.next()){
                answersArray[j]=rs.getString(7).trim();
                j++;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //读取试题
    public static void read(int s){
        try {
            ps=ct.prepareStatement("select * from question where 试题序号=?");
            ps.setInt(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                num=rs.getString(1);
                question=rs.getString(2);
                A=rs.getString(3);
                B=rs.getString(4);
                C=rs.getString(5);
                D=rs.getString(6);
                StuThread.print();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
      
}
