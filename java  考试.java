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
      
    //�������ݿ�
    public static void connectSQL(){
        try {
            ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=exam_db", "sa", "1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //�����û������루����Ա��
    public static void adm(String s){
        try {
            ps=ct.prepareStatement("select * from adm where ����Ա=?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                pwd=rs.getString(2);
            }else {
                JOptionPane.showMessageDialog(null, "û�д��û������������룡");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
      
    //�����û������루ѧ����
    public static void stu(String s){
        try {
            ps=ct.prepareStatement("select * from stu where ѧ��=?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                pwd=rs.getString(2);
            }else {
                JOptionPane.showMessageDialog(null, "û�д��û������������룡");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
      
    //�鿴��Ϣ
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
      
    //ѧ���ظ�
    public static  void qadm_2(String s){
        try {
            ps=ct.prepareStatement("select * from stu where ѧ�� =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "ѧ���ظ�������������!");
                k=false;
            }else{
                k=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //�����Ϣ
    public static void qadm_2(String s1,String s2){
        try {
            ps=ct.prepareStatement("insert into stu values(?,?)");
            ps.setString(1, s1);
            ps.setString(2, s2);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "��ӳɹ�");
            }else {
                JOptionPane.showMessageDialog(null, "���ʧ��");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //ѧ�Ų�����
    public static void qadm_3(String s){
        try {
            ps=ct.prepareStatement("select * from stu where ѧ�� =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                k=true;
            }else{
                JOptionPane.showMessageDialog(null, "ѧ�Ų�����");
                k=false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //�޸���Ϣ
    public static void qadm_3(String s1, String s2){
        // TODO Auto-generated method stub
        try {
            ps=ct.prepareStatement("update stu set ���� = ? where ѧ�� =?");
            ps.setString(1, s2);
            ps.setString(2, s1);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
            }else {
                JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�����������");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //ɾ����Ϣ
    public static void qadm_4(String s) {
        try {
            ps=ct.prepareStatement("delete from stu  where ѧ��=?");
            ps.setString(1, s);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
            }else {
                JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  
    //�鿴����
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
      
    //������Ƿ��ظ�
    public static  void qadm_6(String s){
        try {
            ps=ct.prepareStatement("select * from question where ������� =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "ѧ���ظ�������������!");
                k=false;
            }else{
                k=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //�������
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
                JOptionPane.showMessageDialog(null, "��ӳɹ�");
            }else {
                JOptionPane.showMessageDialog(null, "���ʧ��");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //������Ƿ����
    public static void qadm_7(String s){
        try {
            ps=ct.prepareStatement("select * from question where ������� =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
            if(rs.next()){
                k=true;
            }else{
                JOptionPane.showMessageDialog(null, "������Ų�����");
                k=false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //�޸�����
    public static void qadm_7(String s1,String s2,String s3,String s4){//������ţ��޸����ԣ��޸����ݣ���ȷ��
        try {
            ps=ct.prepareStatement("update question  set "+s2+" = ? ,��ȷ��=? where �������=?");
            ps.setString(1, s3);
            ps.setString(2, s4);
            ps.setString(3, s1);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //ɾ������
    public static void qadm_8(String s) {
        try {
            ps=ct.prepareStatement("delete from question  where �������=?");
            ps.setString(1, s);
            int m=ps.executeUpdate();
            if(m!=0){
                JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
            }else {
                JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    //�����޸�����
    public static void stu_1(String s1, String s2, String s3, String s4) {
        // TODO Auto-generated method stub
        try {
            ps=ct.prepareStatement("select * from stu  where ѧ�� =? and ����=?");
            ps.setString(1, s1);
            ps.setString(2, s2);
            rs=ps.executeQuery();
            if(rs.next()){
                k=true;
            }else{
                JOptionPane.showMessageDialog(null, "ԭʼ�����������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
                k=false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(k){
            if(s3.equals(s4)){
                try {
                    ps=ct.prepareStatement("update stu  set ���� = ? where ѧ�� =?");
                    ps.setString(1, s3);
                    ps.setString(2, s1);
                    int m=ps.executeUpdate();
                    if(m!=0){
                        JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
                    }else {
                        JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�����������");
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(null, "���������벻һ�£�����������");
            }
        }
    }
      
    //��ȡ�����������
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
      
    //��¼��ȷ��
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
      
    //��ȡ����
    public static void read(int s){
        try {
            ps=ct.prepareStatement("select * from question where �������=?");
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
