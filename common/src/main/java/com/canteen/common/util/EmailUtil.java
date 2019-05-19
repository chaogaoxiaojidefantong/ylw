package com.canteen.common.util;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailUtil {
    public String emailFrom="759646095@qq.com";
    public String emailAuthorization="osncxfknzvhqbdgb";
    public String getEmailFrom() {
        return emailFrom;
    }


    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }


    public String getEmailAuthorization() {
        return emailAuthorization;
    }


    public void setEmailAuthorization(String emailAuthorization) {
        this.emailAuthorization = emailAuthorization;
    }


    /**
     *
     * @param toEmail 收方的邮箱
     *
     * @return
     */
    public String emailCheck(String toEmail) {
        String verifyCode=null;//邮箱登录验证码
        // 收件人电子邮箱
        String from = emailFrom;
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com"; //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(emailFrom,emailAuthorization); //发件人邮件用户名、授权码
            }
        });
        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmail));
            // Set Subject: 头部头字段
            message.setSubject("ggg验证码");
            // 设置消息体
            verifyCode=RandomUtil.randomVerifyCode(6);
            message.setText(verifyCode);
            // 发送消息
            Transport.send(message);
            System.out.println("发送成功");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return verifyCode;
    }
}
